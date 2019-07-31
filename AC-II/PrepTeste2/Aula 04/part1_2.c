#include<detpic32.h>

void delay(unsigned int ms){
    for(; ms > 0; ms--){
        resetCoreTimer();
        while(readCoreTimer() < PBCLK / 1000);
    }
}

int main(void){
    /* Config */
    LATE &= 0xFFF0;
    TRISE &= 0xFFF0;

    unsigned int counter = 0;
    while(1){
        LATE &= 0xFFF0;
        LATE |= counter & 0x000F;
        counter++;
        delay(125);
    }
    return 0;
}
