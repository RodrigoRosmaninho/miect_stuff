#include <detpic32.h>

void _int_(27) isr_adc(void){
    printInt(ADC1BUF0, 16 | 3 << 16);
    putChar('\n');
    AD1CON1bits.ASAM = 1; // Start conversion
    IFS1bits.AD1IF = 0;
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

    IPC6bits.AD1IP = 2;
    IFS1bits.AD1IF = 0;
    IEC1bits.AD1IE = 1;

    EnableInterrupts();

    AD1CON1bits.ASAM = 1; // Start conversion
    while(1){
        // all activity is done by the ISR
    }

    return 0;
}