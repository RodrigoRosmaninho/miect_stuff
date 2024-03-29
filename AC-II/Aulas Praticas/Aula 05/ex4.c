#include <detpic32.h>

void delay(int ms) {
    for(; ms > 0; ms--) {
        resetCoreTimer();
        while(readCoreTimer() < 20000);
    }
} 

int main(void) {
    TRISBbits.TRISB4 = 1;       // RBx digital output disconnected
    AD1PCFGbits.PCFG4= 0;       // RBx configured as analog input (AN4)
    AD1CON1bits.SSRC = 7;       // Conversion trigger selection bits: in this
                                // mode an internal counter ends sampling and
                                // starts conversion
    AD1CON1bits.CLRASAM = 1;    // Stop conversions when the 1st A/D converter
                                // interrupt is generated. At the same time,
                                // hardware clears the ASAM bit
    AD1CON3bits.SAMC = 16;      // Sample time is 16 TAD (TAD = 100 ns)
    AD1CON2bits.SMPI = 4-1;     // Interrupt is generated after XX samples
                                // (replace XX by the desired number of
                                // consecutive samples)
    AD1CHSbits.CH0SA = 4;       // replace x by the desired input
                                // analog channel (0 to 15)
    AD1CON1bits.ON = 1;         // Enable A/D converter
                                // This must the last command of the A/D
                                // configuration sequence


    while(1){
        AD1CON1bits.ASAM = 1;               // Start conversion
        while( IFS1bits.AD1IF == 0 );       // Wait while conversion not done
        printStr("\nValores:  ");
        int soma = 0;
        int *p = (int *)(&ADC1BUF0);
        for(; p < (int *)(&ADC1BUF4); p+=4) {
            printInt(*p, 10 | 4 << 10);     // Print values
            putChar('\t');
            soma += *p;
        }
        double media = (double) soma / 4.0;
        printStr("\nMedia: ");
        printInt((int) media, 10 | 4 << 10);
        int v = (media*33)/1023;
        printStr("\nVoltagem: V");
        printInt(v, 10 | 2 << 10);
        delay(600);                         // Wait 0.6s
        putChar('\n');                      // Print newline
        IFS1bits.AD1IF = 0;                 // Reset
    }
}
