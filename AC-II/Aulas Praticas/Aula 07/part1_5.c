#include <detpic32.h>

volatile unsigned char voltage = 0; // Global variable

unsigned char toBcd(unsigned char value) {
    return ((value / 10) << 4) + (value % 10);
}

void send2displays(unsigned char value) {
    static const char display7Scodes[] = {0x3F, 0x06, 0x5B, 0x4F, 0x66, 0x6D, 0x7D, 0x07, 0x7F, 0x6F, 0x77, 0x7C, 0x39, 0x5E, 0x79, 0x71};
    static char displayFlag = 1;
    unsigned char dh = display7Scodes[value >> 4];
    unsigned char dl = display7Scodes[value & 0x0F];

    if(displayFlag) {
        // send digit_high (dh) to display_high: dh = value >> 4
        LATDbits.LATD6 = 1;
        LATDbits.LATD5 = 0;
        LATB = (dh << 8) | (LATB & 0x00FF);
    }

    else {
        // send digit_low (dl) to display_low: dl = value & 0x0F
        LATDbits.LATD6 = 0;
        LATDbits.LATD5 = 1;
        LATB = (dl << 8) | (LATB & 0x00FF);
    }

    displayFlag = !displayFlag;
}

void _int_(27)  isr_adc(void) {
    int soma = 0;
    int *p = (int *)(&ADC1BUF0);
    for(; p < (int *)(&ADC1BUF8); p+=4) soma += *p;
    double media = (double) soma / 8.0;
    voltage = (char) ((media*33)/1023);
    IFS1bits.AD1IF = 0;         // Reset
}

void _int_(4) isr_T1(void) {
    AD1CON1bits.ASAM = 1;       // Start conversion
    IFS0bits.T1IF = 0;
} 

void _int_(12) isr_T3(void) {
    send2displays(toBcd(voltage & 0xFF));
    IFS0bits.T3IF = 0;          // Reset timer T3 interrupt flag
} 

void config(void) {
    TRISBbits.TRISB4 = 1;       // RBx digital output disconnected
    AD1PCFGbits.PCFG4= 0;       // RBx configured as analog input (AN4)
    AD1CON1bits.SSRC = 7;       // Conversion trigger selection bits: in this
                                // mode an internal counter ends sampling and
                                // starts conversion
    AD1CON1bits.CLRASAM = 1;    // Stop conversions when the 1st A/D converter
                                // interrupt is generated. At the same time,
                                // hardware clears the ASAM bit
    AD1CON3bits.SAMC = 16;      // Sample time is 16 TAD (TAD = 100 ns)
    AD1CON2bits.SMPI = 8-1;     // Interrupt is generated after XX samples
                                // (replace XX by the desired number of
                                // consecutive samples)
    AD1CHSbits.CH0SA = 4;       // replace x by the desired input
                                // analog channel (0 to 15)
    AD1CON1bits.ON = 1;         // Enable A/D converter
                                // This must the last command of the A/D
                                // configuration sequence

    IPC6bits.AD1IP = 2;         // configure priority of A/D interrupts
    IFS1bits.AD1IF = 0;         // clear A/D interrupt flag
    IEC1bits.AD1IE = 1;         // enable A/D interrupts 
    

    T1CONbits.TCKPS = 3; 
    PR1 = 19530; 
    TMR1 = 0;                   // Reset timer T1 count register

    IPC1bits.T1IP = 2;          // Interrupt priority (must be in range [1..6])
    IEC0bits.T1IE = 1;          // Enable timer T1 interrupts
    IFS0bits.T1IF = 0;          // Reset timer T1 interrupt flag

    T3CONbits.TCKPS = 2; 
    PR3 = 49999; 
    TMR3 = 0;                   // Reset timer T3 count register

    IPC3bits.T3IP = 2;          // Interrupt priority (must be in range [1..6])
    IEC0bits.T3IE = 1;          // Enable timer T3 interrupts
    IFS0bits.T3IF = 0;          // Reset timer T3 interrupt flag

    EnableInterrupts();         // Global Interrupt Enable

    T1CONbits.TON = 1;          // Enable timer T1 (must be the last command of the timer configuration sequence)
    T3CONbits.TON = 1;          // Enable timer T3 (must be the last command of the timer configuration sequence)
}

int main(void){
    config();
    
    TRISD = TRISD & 0xFF9F;
    LATD = LATD & 0xF9FF;

    TRISB = TRISB & 0x80FF;
    LATB = LATB & 0x80FF;

    while(1);
    return 0;
}

