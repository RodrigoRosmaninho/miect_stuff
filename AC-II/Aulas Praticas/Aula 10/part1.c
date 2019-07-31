#include<detpic32.h>

#define I2C_READ 1
#define I2C_WRITE 0
#define I2C_ACK 0
#define I2C_NACK 1

#define SENS_ADDRESS 0x4D                           // device dependent
#define ADDR_WR ((SENS_ADDRESS << 1) | I2C_WRITE)
#define ADDR_RD ((SENS_ADDRESS << 1) | I2C_READ)
#define TC74_CLK_FREQ 100000                        // 100 KHz
#define RTR 0                                       // Read temperature command

void delay(int ms){
    for(; ms > 0; ms--){
        resetCoreTimer();
        while(readCoreTimer() < PBCLK / 1000);
    }
}

void i2c1_init(unsigned int clock_freq){
    I2C1BRG = (PBCLK + clock_freq) / (2 * clock_freq) - 1;
    I2C1CONbits.ON = 1;
}

void i2c1_start(void){
    while((I2C1CON & 0x001F) != 0);     // Wait until the lower 5 bits of I2CxCON are all 0 (the lower 5 bits of I2CxCON must be 0 before attempting to set the SEN bit)
    I2C1CONbits.SEN = 1;                // Activate Start event (I2C1CON, bit SEN)
    while(I2C1CONbits.SEN != 0);        // Wait for completion of the Start event (I2C1CON, bit SEN)
}

void i2c1_stop(void){
    while((I2C1CON & 0x001F) != 0);     // Wait until the lower 5 bits of I2CxCON are all 0 (the lower 5 bits of I2CxCON must be 0 before attempting to set the PEN bit)
    I2C1CONbits.PEN = 1;                // Activate Stop event (I2C1CON, bit PEN)
    while(I2C1CONbits.PEN != 0);        // Wait for completion of the Stop event (I2C1CON, bit PEN)
}

int i2c1_send(unsigned char value){
    I2C1TRN = value;                    // Copy "value" to I2C1TRN register
    while(I2C1STATbits.TRSTAT != 0);    // Wait while master transmission is in progress (8 bits + ACK\) (I2C1STAT, bit TRSTAT – transmit status bit)
    return I2C1STATbits.ACKSTAT;        // Return acknowledge status bit (I2C1STAT, bit ACKSTAT)
}

char i2c1_receive(char ack_bit){
    while((I2C1CON & 0x001F) != 0);     // Wait until the lower 5 bits of I2C1CON are all 0 (the lower 5 bits of I2C1CON must be 0 before attempting to set the RCEN bit)
    I2C1CONbits.RCEN = 1;               // Activate RCEN bit (receive enable bit, I2C1CON register)
    while(I2C1STATbits.RBF != 1);       // Wait while byte not received (I2C1STAT, bit RBF – receive buffer full status bit)

    // Send ACK / NACK bit. For that:
    // Copy "ack_bit" to I2C1CON, bit ACKDT (be sure "ack_bit" value is only 0 or 1)
    if(ack_bit != 0 && ack_bit != 1) return 0;
    I2C1CONbits.ACKDT = ack_bit;
    while((I2C1CON & 0x001F) != 0);     // Wait until the lower 5 bits of I2C1CON are all 0 (the lower 5 bits of I2C1CON must be 0 before attempting to set the ACKEN bit.
    I2C1CONbits.ACKEN = 1;              // Start Acknowledge sequence (I2C1CON register, bit ACKEN=1)
    while(I2C1CONbits.ACKEN != 0);      // Wait for completion of Acknowledge sequence (I2C1CON, bit ACKEN)
    return I2C1RCV;                     // Return received value (I2C1RCV)
}

int main(void){
    int ack = 0;
    int temperature = 0;
    i2c1_init(TC74_CLK_FREQ);
    while(1){
        i2c1_start();                           // Send Start event
        ack = i2c1_send(ADDR_WR);               // Send Address + WR (ADDR_WR); copy return value to "ack" variable
        ack += i2c1_send(RTR);                  // Send Command (RTR); add return value to "ack" variable
        i2c1_start();                           // Send Start event (again)
        ack += i2c1_send(ADDR_RD);              // Send Address + RD (ADDR_RD); add return value to "ack" variable
        if(ack != 0) {                          // Test "ack" variable; if "ack" != 0 then an error has occurred;
            i2c1_stop();                        // Send the Stop event, print an error message and exit loop
            printStr("Error: ack != 0");
            break;
        }
        temperature = i2c1_receive(I2C_NACK);   // Receive a value from slave (send NACK as argument); copy received value to "temperature" variable
        i2c1_stop();                            // Send Stop event
        printStr("temperature: ");
        printInt10(temperature);                // Print "temperature" variable (syscall printInt10)
        putChar('\r');
        delay(250);                             // Wait 250 ms
    }
    return 0;
}
