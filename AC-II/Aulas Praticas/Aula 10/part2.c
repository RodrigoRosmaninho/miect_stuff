#include<detpic32.h>
#include "i2c.h"

void delay(int ms){
    for(; ms > 0; ms--){
        resetCoreTimer();
        while(readCoreTimer() < PBCLK / 1000);
    }
}

int getTemperature(int* temperature){
    int ack;
    i2c1_start();                           // Send Start event
    ack = i2c1_send(ADDR_WR);               // Send Address + WR (ADDR_WR); copy return value to "ack" variable
    ack += i2c1_send(RTR);                  // Send Command (RTR); add return value to "ack" variable
    i2c1_start();                           // Send Start event (again)
    ack += i2c1_send(ADDR_RD);              // Send Address + RD (ADDR_RD); add return value to "ack" variable
    if(ack != 0) return 1;                  // Test "ack" variable; if "ack" != 0 then an error has occurred;
    *temperature = i2c1_receive(I2C_NACK);  // Receive a value from slave (send NACK as argument); copy received value to "temperature" variable
    i2c1_stop();                            // Send Stop event
}

int main(void){
    i2c1_init(TC74_CLK_FREQ);
    int temperature, err;
    while (1){
        err = getTemperature(&temperature);
        if(err != 0){
            i2c1_stop();                    // Send the Stop event, print an error message and exit loop
            printStr("Error: ack != 0");
            break;
        }
        printStr("temperature: ");
        printInt10(temperature);            // Print "temperature" variable (syscall printInt10)
        putChar('\r');
        delay(250);
    }
    return 0;
}
