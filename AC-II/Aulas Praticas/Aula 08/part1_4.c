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

int main(void){
    configUART(115200, 'N', 1);
    return 0;
}
