#include<detpic32.h>

#define baudrate 38400

volatile int adc_value = 0;
volatile int display_value = 0;

unsigned char toBCD(unsigned char val){
    return ((val / 10) << 4) + (val % 10);
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

void setPWM(unsigned int duty){
    if(duty > 100) return;
    OC1RS = ((PR2 + 1) * duty)/100;
}

void config(void){
    /* UART1 Config */
    U1BRG = ((PBCLK + 8 * baudrate) / (16 * baudrate)) - 1;
    U1MODEbits.BRGH = 0;
    U1MODEbits.PDSEL = 2;
    U1MODEbits.STSEL = 0;
    U1STAbits.UTXEN = 1;
    U1STAbits.URXEN = 1;
    U1MODEbits.ON = 1;

    /* UART1 Interrupt Config */
    U1STAbits.URXISEL = 0;
    IPC6bits.U1IP = 3;
    IEC0bits.U1RXIE = 1;
    IFS0bits.U1RXIF = 0;

    /* AD1 Config */
    TRISBbits.TRISB4 = 1;
    AD1PCFGbits.PCFG4= 0;
    AD1CON1bits.SSRC = 7;
    AD1CON1bits.CLRASAM = 1;
    AD1CON3bits.SAMC = 16;
    AD1CON2bits.SMPI = 4-1;
    AD1CHSbits.CH0SA = 4;
    AD1CON1bits.ON = 1;

    /* AD1 Interrupt Config */
    IPC6bits.AD1IP = 2;
    IEC1bits.AD1IE = 1;
    IFS1bits.AD1IF = 0;

    /* Timer 4 Config */
    // 145 Hz
    T4CONbits.TCKPS = 2;
    PR4 = 34482;
    TMR4 = 0;
    T4CONbits.TON = 1; 

    /* Timer 4 Interrupt Config */
    IPC4bits.T4IP = 2;
    IEC0bits.T4IE = 0;
    IFS0bits.T4IF = 0;

    /* Timer 2 Config */
    // 100 Hz
    T2CONbits.TCKPS = 2;
    PR2 = 49999;
    TMR2 = 0;
    T2CONbits.TON = 1; 

    /* OC1 Config */
    OC1CONbits.OCM = 6;
    OC1CONbits.OCTSEL = 0;
    setPWM(50);
    OC1CONbits.ON = 1;

    /* 7-Seg Display Config */
    LATD &= 0xFF9F;
    LATB &= 0x80FF;
    TRISD &= 0xFF9F;
    TRISB &= 0x80FF;

    /* Global Interrupt Config */
    EnableInterrupts();
}

void _int_(16) isr_T4(void){
    send2displays(toBCD((unsigned char) display_value));
    IFS0bits.T4IF = 0;
}

void _int_(27) isr_AD1(void){
    int sum = 0;
    int* ptr = (int*) &ADC1BUF0;
    for(; ptr <= (int*) &ADC1BUF4; ptr+=4){
        sum += *ptr;
    }
    adc_value = ((double) sum / 4.0) * 100 / 1023;
    IFS1bits.AD1IF = 0;
}

void putc(char c){
    while(U1STAbits.UTXBF);
    U1TXREG = c;
}

void putStr(char* str){
    for(; *str != '\0'; str++) putc(*str);
}

void _int_(24) isr_UART1(void){
    if(IFS0bits.U1RXIF){
        char recv = U1RXREG;
        switch(recv){
            case 'A':
                AD1CON1bits.ASAM = 1;
                break;
            case 'D':
                IEC0bits.T4IE = 1;
                display_value = adc_value;
                break;
            case 'E':
                putStr("Valor convertido: ");
                putc('0' + (adc_value / 10));
                putc('0' + (adc_value % 10));
                putc('\n');
                break;
            case 'P':
                setPWM(adc_value);
                break;
            default:
                break;
        }
        IFS0bits.U1RXIF = 0;
    }
}

int main(void){
    config();
    while(1);
    return 0;
}
