#include <detpic32.h>

void sendSegment(char segment) {
    LATB = LATB & 0x80FF;
    switch(segment){
            case 'a' | 'A':
                LATBbits.LATB8 = 1;
                break;
            case 'b' | 'B':
                LATBbits.LATB9 = 1;
                break;
            case 'c' | 'C':
                LATBbits.LATB10 = 1;
                break;
            case 'd' | 'D':
                LATBbits.LATB11 = 1;
                break;
            case 'e' | 'E':
                LATBbits.LATB12 = 1;
                break;
            case 'f' | 'F':
                LATBbits.LATB13 = 1;
                break;
            case 'g' | 'G':
                LATBbits.LATB14 = 1;
                break;

            default:
                break;
        }
}

void delay(int ms) {
    for(; ms > 0; ms--) {
        resetCoreTimer();
        while(readCoreTimer() < 20000);
    }
} 

int main(void) {
    char segment;
    LATDbits.LATD6 = 1; // display high active
    LATDbits.LATD5 = 0; // display low inactive
    // configure RB8-RB14 as outputs
    // configure RD5-RD6 as outputs
    LATB = LATB & 0x80FF;
    TRISB = TRISB & 0x80FF;
    TRISD = TRISD & 0xFF9F;
    int i = 0;

    while(1) {
        LATDbits.LATD6 = !LATDbits.LATD6; //
        LATDbits.LATD5 = !LATDbits.LATD5; // toggle display selection
        segment = 'a';

        while(segment != 'h'){
            // send "segment" value to display
            sendSegment(segment);
            delay(500); // wait 0.5 second
            segment += 1;
        }
    }

    return 0;
} 