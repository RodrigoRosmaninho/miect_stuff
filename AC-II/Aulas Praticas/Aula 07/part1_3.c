#include<detpic32.h>

volatile int syscallFlag = 1;

int main(void){
    T3CONbits.TCKPS = 7; 
    PR3 = 39062; 
    TMR3 = 0;               // Reset timer T3 count register

    IPC3bits.T3IP = 2;      // Interrupt priority (must be in range [1..6])
    IEC0bits.T3IE = 1;      // Enable timer T3 interrupts
    IFS0bits.T3IF = 0;      // Reset timer T3 interrupt flag

    EnableInterrupts();

    T3CONbits.TON = 1;      // Enable timer T3 (must be the last command of the timer configuration sequence)

    while(1);
    return 0;  
}

void _int_(12) isr_T3(void) {
    if(syscallFlag) putChar('.');
    syscallFlag = !syscallFlag;
    IFS0bits.T3IF = 0;      // Reset timer T3 interrupt flag
 } 
