#include<detpic32.h>

void configUART(unsigned int baudrate, char parity, unsigned int stopbits){
    if(baudrate < 600 || baudrate > 115200) baudrate = 115200;
    U1BRG = ((PBCLK + 8 * baudrate) / (16 * baudrate)) - 1;
    U1MODEbits.BRGH = 0; // 16

    switch (parity){
        case 'E':
            U1MODEbits.PDSEL = 1;
            break;
        
        case 'O':
            U1MODEbits.PDSEL = 2;
            break;
    
        default:
            U1MODEbits.PDSEL = 0;
            break;
    }

    switch(stopbits){
        case 2:
            U1MODEbits.STSEL = 1;
            break;
        
        default:
            U1MODEbits.STSEL = 0;
            break;
    }

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
    configUART(600, 'N', 1);
    while(1){
        puts("String de teste\n");
        delay(1000);
    }
    return 0;
}
