#include<detpic32.h>

volatile unsigned int duty = 0;
volatile unsigned int count = 0;

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

void putc(char byte2send){
    if(U1STAbits.OERR == 1) U1STAbits.OERR = 0;
    while (U1STAbits.UTXBF == 1);
    U1TXREG = byte2send;
}

void puts(char *str){
    for(;*str != '\0'; str++) putc(*str);
}

void setPWM(unsigned int duty){
    if(duty > 100) return;
    OC1RS = ((PR3 + 1) * duty) / 100;
}

void config(void){

    // *** UART1 Configuration ***
    unsigned int baudrate = 19200;
    U1BRG = ((PBCLK + 8 * baudrate) / (16 * baudrate)) - 1;
    U1MODEbits.BRGH = 0;
    U1MODEbits.PDSEL = 1;
    U1MODEbits.STSEL = 1;

    U1STAbits.UTXEN = 1;
    U1STAbits.URXEN = 1;

    U1MODEbits.ON = 1;

    // *** Timer 3 Configuration ***
    T3CONbits.TCKPS = 2;
    PR3 = 49999;
    TMR3 = 0;
    T3CONbits.TON = 1;

    // *** OC1 Configuration ***
    duty = 50;
    OC1CONbits.OCM = 6;
    OC1CONbits.OCTSEL = 1;
    setPWM(duty);
    OC1CONbits.ON = 1;

    // *** UART1 Interrupt Configuration ***
    IPC6bits.U1IP = 3;
    IEC0bits.U1RXIE = 1;
    IFS0bits.U1RXIF = 0;

    // *** Timer 3 Interrupt Configuration ***
    IPC3bits.T3IP = 2;
    IEC0bits.T3IE = 1;
    IFS0bits.T3IF = 0;

    // *** 7-Seg Display Configuration ***
    LATD &= 0xFF9F;
    LATB &= 0x80FF;
    TRISD &= 0xFF9F;
    TRISB &= 0x80FF;


    // *** Global Interrupt Enable ***
    EnableInterrupts();

    count = 0;
}

void _int_(12) isr_T3(void){
    send2displays(toBcd((char) duty));
    if(count++ == 100){
        puts("O valor atual do duty-cycle é ");
        char tens = '0' + (char)(duty / 10);
        char units = '0' + (char)(duty % 10);
        putc(tens);
        putc(units);
        puts("%\n");
        count = 0;
    }
    IFS0bits.T3IF = 0;
}

void _int_(24) isr_UART1(void){
    if(IFS0bits.U1RXIF) {
        char recv = U1RXREG;
        //putc(recv);
        if(recv == '+' && duty <= 95) {
            if(duty == 95) {
                puts("\nErro! O Duty Cycle apenas é válido no intervalo [5,95]\n");
                IFS0bits.U1RXIF = 0;
                return;
            }
            duty += 5;
        }
        if(recv == '-') {
            if(duty == 5) {
                puts("\nErro! O Duty Cycle apenas é válido no intervalo [5,95]\n");
                IFS0bits.U1RXIF = 0;
                return;
            }
            duty -= 5;
        }
        IFS0bits.U1RXIF = 0;
    }
}

int main(void){
    config();
    while(1){
        setPWM(duty);
    }
    return 0;
}
