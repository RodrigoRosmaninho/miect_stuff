#include <detpic32.h>

int display7Scodes[] = {0x3F, 0x06, 0x5B, 0x4F, 0x66, 0x6D, 0x7D, 0x07, 0x7F, 0x6F, 0x77, 0x7C, 0x39, 0x5E, 0x79, 0x71};

void delay(int ms) {
    for(; ms > 0; ms--) {
        resetCoreTimer();
        while(readCoreTimer() < 20000);
    }
} 

int main(void) {
    LATDbits.LATD5 = 1; // display high active, low inactive 
    // configure RB8-RB14 as outputs
    // configure RD5-RD6 as outputs
    LATB = LATB & 0x80FF;
    TRISB = TRISB | 0x7F0F;
    TRISB = TRISB & 0x80FF;
    TRISD = TRISD & 0xFFDF;
    //LATB = LATB | 0x7F0F;

    while(1) {
        int input = PORTB & 0xF;
        LATB = (display7Scodes[input] << 8) | (0x00FF & LATB);
    }

    return 0;
} 