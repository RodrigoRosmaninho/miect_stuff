#include<detpic32.h>

volatile int syscallFlag = 1;

int main(void){
    T1CONbits.TCKPS = 3; 
    PR1 = 39062; 
    TMR1 = 0;               // Reset timer T1 count register

    IPC1bits.T1IP = 2;      // Interrupt priority (must be in range [1..6])
    IEC0bits.T1IE = 1;      // Enable timer T1 interrupts
    IFS0bits.T1IF = 0;      // Reset timer T1 interrupt flag

    T3CONbits.TCKPS = 5; 
    PR3 = 62499; 
    TMR3 = 0;               // Reset timer T3 count register

    IPC3bits.T3IP = 2;      // Interrupt priority (must be in range [1..6])
    IEC0bits.T3IE = 1;      // Enable timer T3 interrupts
    IFS0bits.T3IF = 0;      // Reset timer T3 interrupt flag

    EnableInterrupts();

    T1CONbits.TON = 1;      // Enable timer T1 (must be the last command of the timer configuration sequence)
    T3CONbits.TON = 1;      // Enable timer T3 (must be the last command of the timer configuration sequence)

    while(1);
    return 0;  
}

void _int_(4) isr_T1(void) {
    putChar('1');
    IFS0bits.T1IF = 0;      // Reset timer T1 interrupt flag
} 

void _int_(12) isr_T3(void) {
    putChar('3');
    IFS0bits.T3IF = 0;      // Reset timer T3 interrupt flag
} 
