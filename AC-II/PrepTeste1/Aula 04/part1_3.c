#include <detpic32.h>

void delay(int ms){
    for(;ms > 0; ms--){
        resetCoreTimer();
        while(readCoreTimer() < 20000);
    }
}

int main(void) {
    LATB &= 0x00FF;
    TRISB &= 0x00FF;

    LATD &= 0xFF9F;
    TRISD &= 0xFF9F;

    LATDbits.LATD5 = 1;
    LATDbits.LATD6 = 0;

    while(1){
        char input = getChar();
        putChar(input);
        putChar('\r');
        switch(input){
            case 'a' | 'A':
                LATB = LATB & 0x00FF;
                LATBbits.LATB8 = 1;
                break;
            case 'b' | 'B':
                LATB = LATB & 0x00FF;
                LATBbits.LATB9 = 1;
                break;
            case 'c' | 'C':
                LATB = LATB & 0x00FF;
                LATBbits.LATB10 = 1;
                break;
            case 'd' | 'D':
                LATB = LATB & 0x00FF;
                LATBbits.LATB11 = 1;
                break;
            case 'e' | 'E':
                LATB = LATB & 0x00FF;
                LATBbits.LATB12 = 1;
                break;
            case 'f' | 'F':
                LATB = LATB & 0x00FF;
                LATBbits.LATB13 = 1;
                break;
            case 'g' | 'G':
                LATB = LATB & 0x00FF;
                LATBbits.LATB14 = 1;
                break;
            case '.':
                LATB = LATB & 0x00FF;
                LATBbits.LATB15 = 1;
                break;

            default:
                break;
        }
    }
    return 0;
}