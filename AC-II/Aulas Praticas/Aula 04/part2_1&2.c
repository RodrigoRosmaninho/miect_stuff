#include <detpic32.h>

void delay(int ms) {
    for(; ms > 0; ms--) {
        resetCoreTimer();
        while(readCoreTimer() < 20000);
    }
} 

void send2displays(unsigned char value) {
    static const char display7Scodes[] = {0x3F, 0x06, 0x5B, 0x4F, 0x66, 0x6D, 0x7D, 0x07, 0x7F, 0x6F, 0x77, 0x7C, 0x39, 0x5E, 0x79, 0x71};
    unsigned char dh = display7Scodes[value >> 4];
    unsigned char dl = display7Scodes[value & 0x0F];

    // send digit_high (dh) to display_high: dh = value >> 4
    LATDbits.LATD6 = 1;
    LATDbits.LATD5 = 0;
    LATB = (dh << 8) | (LATB & 0x00FF);

    delay(1);
    // send digit_low (dl) to display_low: dl = value & 0x0F
    LATDbits.LATD6 = 0;
    LATDbits.LATD5 = 1;
    LATB = (dl << 8) | (LATB & 0x00FF);
} 

int main(void){
    TRISD = TRISD & 0xFF9F;
    LATD = LATD & 0xF9FF;

    TRISB = TRISB & 0x80FF;
    LATB = LATB & 0x80FF;

    int counter = 0;
    while(1){
        send2displays(counter & 0xFF);
        delay(200);
        counter++;
    }
    
    return 0;
}
