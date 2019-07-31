#include<detpic32.h>

void config(void){
    int baudrate = 115200;
    U1BRG = ((PBCLK + 8 * baudrate) / (16 * baudrate)) - 1;
    U1MODE &= 0xFFF0; // BRGH = 0 (16), PDSEL = 00 (8 data bits, no parity), STSEL = 0 (1 stop bit)
    U1STAbits.UTXEN = 1;
    U1STAbits.URXEN = 1;
    U1MODEbits.ON = 1;
}

int main(void){
    config();
    return 0;
}
