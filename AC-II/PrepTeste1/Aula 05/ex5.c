#include <detpic32.h>

unsigned char toBcd(unsigned char value) {
    return ((value / 10) << 4) + (value % 10);
}

void delay(int ms){
    for(; ms > 0; ms--){
        resetCoreTimer();
        while(readCoreTimer() < PBCLK / 1000);
    }
}

void send2displays(unsigned char value){
    static const char display7Scodes[] = {0x3F, 0x06, 0x5B, 0x4F, 0x66, 0x6D, 0x7D, 0x07, 0x7F, 0x6F, 0x77, 0x7C, 0x39, 0x5E, 0x79, 0x71};
    static int displayFlag = 0;

    int value_high = value >> 4;
    int value_low = value & 0x0F;

    if(displayFlag){
        LATDbits.LATD5 = 0;
        LATDbits.LATD6 = 1;

        LATB = display7Scodes[value_high] << 8 | (LATB & 0x00FF);
    } 
    else {
        LATDbits.LATD5 = 1;
        LATDbits.LATD6 = 0;

        LATB = display7Scodes[value_low] << 8 | (LATB & 0x00FF);
    }
 
    displayFlag = !displayFlag;
}

int main(void){
    TRISBbits.TRISB4 = 1; // RBx digital output disconnected
    AD1PCFGbits.PCFG4= 0; // RBx configured as analog input (AN4)
    AD1CON1bits.SSRC = 7; // Conversion trigger selection bits: in this mode an internal counter ends sampling and starts conversion
    AD1CON1bits.CLRASAM = 1; // Stop conversions when the 1st A/D converter interrupt is generated. At the same time, hardware clears the ASAM bit
    AD1CON3bits.SAMC = 16; // Sample time is 16 TAD (TAD = 100 ns)
    AD1CON2bits.SMPI = 4-1; // Interrupt is generated after XX samples (replace XX by the desired number of onsecutive samples)
    AD1CHSbits.CH0SA = 4; // replace x by the desired input analog channel (0 to 15)
    AD1CON1bits.ON = 1; // Enable A/D converter - This must the last command of the A/D configuration sequence

    LATD &= 0xFF9F;
    LATB &= 0x80FF;

    TRISD &= 0xFF9F;
    TRISB &= 0x80FF;

    while(1){
        int i;
        if(i++ % 25 == 0){
            AD1CON1bits.ASAM = 1; // Start conversion
            while( IFS1bits.AD1IF == 0 ); // Wait while conversion not done
            int *p = (int *)(&ADC1BUF0);
            int VAL_ADD = 0;
            for(; p < (int *)(&ADC1BUF4); p += 4) {
                VAL_ADD += *p;
            }
            int V = ((VAL_ADD / 4.0)*33+511)/1023;
            printInt(V, 10 | 2 << 10);
            putChar('\n');
            send2displays(toBcd(V));
            delay(10);
        }
    }
    return 0;
}