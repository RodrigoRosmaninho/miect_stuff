#include <detpic32.h>

void delay(int ms){
    for(; ms > 0; ms--){
        resetCoreTimer();
        while(readCoreTimer() < PBCLK / 1000);
    }
}

int main(void){
    LATD &= 0xFFDF;
    LATB &= 0x80FF ;

    TRISD &= 0xFFDF;
    TRISB = TRISB & 0x80FF | 0x0008;

    static const char display7Scodes[] = {0x6D, 0x5B, 0x66, 0x06, 0x7D, 0x4F};

    LATDbits.LATD5 = 1;
    int cnt = 0;
    while(1){
        while(PORTBbits.RB3 != 0);
        delay(50);
        LATB = display7Scodes[cnt++] << 8 | (LATB & 0x00FF);
        if(cnt == 6) cnt = 0;
    }

    return 0;
}