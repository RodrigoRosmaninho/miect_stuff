#include<detpic32.h>

void delay(unsigned int ms){
    for(; ms > 0; ms--){
        resetCoreTimer();
        while((readCoreTimer() < PBCLK / 1000));
    }
}

void config(void){
    LATE &= 0xFFF0;
    TRISE &= 0xFFF0;
    TRISBbits.TRISB2 = 1;
}

int main(void){
    config();
    while(1){
        if(PORTBbits.RB2){
            int b = LATEbits.LATE3;
            //LATE = LATE << 1;
            LATE = (LATE & 0xFFF0) | ((0x000F & LATE) << 1);
            LATEbits.LATE0 = !b;
        } else {
            int b = LATEbits.LATE0;
            //LATE = LATE >> 1;
            LATE = (LATE & 0xFFF0) | ((0x000F & LATE) >> 1);
            LATEbits.LATE3 = !b;
        }
        delay(750);
    }
    return 0;
}
