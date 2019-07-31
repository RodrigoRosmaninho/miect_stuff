#include <detpic32.h>
#include "i2c.c"

volatile unsigned int temperature = 0; // Global variable

int getTemperature(){
    int ack;
    i2c1_start();                           // Send Start event
    ack = i2c1_send(ADDR_WR);               // Send Address + WR (ADDR_WR); copy return value to "ack" variable
    ack += i2c1_send(RTR);                  // Send Command (RTR); add return value to "ack" variable
    i2c1_start();                           // Send Start event (again)
    ack += i2c1_send(ADDR_RD);              // Send Address + RD (ADDR_RD); add return value to "ack" variable
    if(ack != 0) return 1;                  // Test "ack" variable; if "ack" != 0 then an error has occurred;
    temperature = i2c1_receive(I2C_NACK);  // Receive a value from slave (send NACK as argument); copy received value to "temperature" variable
    i2c1_stop();                            // Send Stop event
    return 0;
}

unsigned char toBcd(unsigned char value) {
    return ((value / 10) << 4) + (value % 10);
}

void send2displays(unsigned char value) {
    static const char display7Scodes[] = {0x3F, 0x06, 0x5B, 0x4F, 0x66, 0x6D, 0x7D, 0x07, 0x7F, 0x6F, 0x77, 0x7C, 0x39, 0x5E, 0x79, 0x71};
    static char displayFlag = 1;
    unsigned char dh = display7Scodes[value >> 4];
    unsigned char dl = display7Scodes[value & 0x0F];

    if(displayFlag) {
        // send digit_high (dh) to display_high: dh = value >> 4
        LATDbits.LATD6 = 1;
        LATDbits.LATD5 = 0;
        LATB = (dh << 8) | (LATB & 0x00FF);
    }

    else {
        // send digit_low (dl) to display_low: dl = value & 0x0F
        LATDbits.LATD6 = 0;
        LATDbits.LATD5 = 1;
        LATB = (dl << 8) | (LATB & 0x00FF);
    }

    displayFlag = !displayFlag;
}

void _int_(4) isr_T1(void) {
    int err = getTemperature();
    printStr("temperature: ");
    printInt10(temperature);            // Print "temperature" variable (syscall printInt10)
    putChar('\r');
    if(err != 0){
            i2c1_stop();                    // Send the Stop event, print an error message and exit loop
            printStr("Error: ack != 0");
    }
    IFS0bits.T1IF = 0;          // Reset timer T1 interrupt flag
}

void _int_(12) isr_T3(void) {
    send2displays(toBcd((char) temperature & 0xFF));
    IFS0bits.T3IF = 0;          // Reset timer T3 interrupt flag
}

void config(void) {
    T1CONbits.TCKPS = 3;
    PR1 = 19530;
    TMR1 = 0;                   // Reset timer T1 count register

    IPC1bits.T1IP = 2;          // Interrupt priority (must be in range [1..6])
    IEC0bits.T1IE = 1;          // Enable timer T1 interrupts
    IFS0bits.T1IF = 0;          // Reset timer T1 interrupt flag

    T3CONbits.TCKPS = 2;
    PR3 = 49999;
    TMR3 = 0;                   // Reset timer T3 count register

    IPC3bits.T3IP = 2;          // Interrupt priority (must be in range [1..6])
    IEC0bits.T3IE = 1;          // Enable timer T3 interrupts
    IFS0bits.T3IF = 0;          // Reset timer T3 interrupt flag

    EnableInterrupts();         // Global Interrupt Enable

    T1CONbits.TON = 1;          // Enable timer T1 (must be the last command of the timer configuration sequence)
    T3CONbits.TON = 1;          // Enable timer T3 (must be the last command of the timer configuration sequence)
}

int main(void){
    config();

    LATD = LATD & 0xF9FF;
    TRISD = TRISD & 0xFF9F;

    LATB = LATB & 0x80FF;
    TRISB = TRISB & 0x80FF;
    TRISB = TRISB | 0x03;

    i2c1_init(TC74_CLK_FREQ);

    while(1){
        if(PORTBbits.RB0 == 1 && PORTBbits.RB1 == 1) IEC0bits.T1IE = 1;          // Enable timer T1 interrupts
        else IEC0bits.T1IE = 0;                                                  // Disable timer T1 interrupts
    }
    return 0;
}
