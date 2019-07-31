#include<detpic32.h>

volatile unsigned int duty = 0;
volatile unsigned long cnt = 0;

void config(void){
    // Timer 3
    T3CONbits.TCKPS = 7;
    PR3 = 39062;
    TMR3 = 0;
    T3CONbits.TON = 1;

    IPC3bits.T3IP = 2;
    IEC0bits.T3IE = 1;
    IFS0bits.T3IF = 0;

    // Timer 2
    T2CONbits.TCKPS = 1;
    PR2 = 39999;
    TMR2 = 0;
    T2CONbits.TON = 1;

    // OC1
    OC1CONbits.OCM = 6;
    OC1CONbits.OCTSEL = 0;
    OC1RS = 24000;
    OC1CONbits.ON = 1;

    EnableInterrupts();
}

void setPWM(unsigned int duty){
    if(duty > 100) return;
    OC1RS = ((PR2 + 1) * duty) / 100;
}

void _int_(12) isr_T3(void){
    if(cnt++ % 2 == 0){
        duty++;
    }
    IFS0bits.T3IF = 0;
}

int main(){
    config();
    while(1){
        setPWM(duty);
    }
    return 0;
}
