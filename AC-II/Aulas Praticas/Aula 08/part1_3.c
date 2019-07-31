#include<detpic32.h>

void config(void){
    int baudrate = 115200;
    U1BRG = ((PBCLK + 8 * baudrate) / (16 * baudrate)) - 1;
    U1MODE &= 0xFFF0; // BRGH = 0 (16), PDSEL = 00 (8 data bits, no parity), STSEL = 0 (1 stop bit)
    U1STAbits.UTXEN = 1;
    U1STAbits.URXEN = 1;
    U1MODEbits.ON = 1;
}

void delay(int ms) {
    for(; ms > 0; ms--) {
        resetCoreTimer();
        while(readCoreTimer() < 20000);
    }
}

void putc(char byte2send){
    if(U1STAbits.OERR == 1) U1STAbits.OERR = 0;
    while (U1STAbits.UTXBF == 1);
    U1TXREG = byte2send;
}

void puts(char *str){
    for(;*str != '\0'; str++) putc(*str);
}

int main(void){
    config();
    while(1){
        puts("String de teste\n");
        delay(1000);
    }
    return 0;
}
