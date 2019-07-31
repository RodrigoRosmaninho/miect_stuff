#include<detpic32.h>

#define DisableUart1RxInterrupt() IEC0bits.U1RXIE = 0
#define EnableUart1RxInterrupt() IEC0bits.U1RXIE = 1
#define DisableUart1TxInterrupt() IEC0bits.U1TXIE = 0
#define EnableUart1TxInterrupt() IEC0bits.U1TXIE = 1

#define BUF_SIZE 8
#define INDEX_MASK (BUF_SIZE - 1)

typedef struct {
    unsigned char data[BUF_SIZE];
    unsigned int head;
    unsigned int tail;
    unsigned int count;
} circularBuffer;

volatile circularBuffer txb; // Transmission buffer
volatile circularBuffer rxb; // Reception buffer

void comDrv_config(unsigned int baudrate, char parity, unsigned int stopbits){
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

    IPC6bits.U1IP = 2;
    IEC0bits.U1RXIE = 1;
    IFS0bits.U1RXIF = 0;
    IEC0bits.U1TXIE = 1;
    IFS0bits.U1TXIF = 0;

}

void comDrv_flushRx(void) {
    // Initialize variables of the reception buffer
    rxb.head = 0;
    rxb.tail = 0;
    rxb.count = 0;
}

void comDrv_flushTx(void) {
    // Initialize variables of the transmission buffer
    txb.head = 0;
    txb.tail = 0;
    txb.count = 0;
} 

void comDrv_putc(char ch) {
    while(txb.count == BUF_SIZE){}                      // Wait while buffer is full
    txb.data[txb.tail] = ch;                            // Copy character to the transmission
                                                        // buffer at position "tail"
    txb.tail = (txb.tail+1) & INDEX_MASK;               // Increment "tail" index
    // (mod. BUF_SIZE)
    DisableUart1TxInterrupt();                          // Begin of critical section
    txb.count++;                                        // Increment "count" variable
    EnableUart1TxInterrupt();                           // End of critical section
}

void comDrv_puts(char *s) {
    while( *s != '\0'){
        comDrv_putc(*s);
        s++;
    }
}

char comDrv_getc(char *pchar) {
    if(rxb.count == 0) return 0;                        // Test "count" variable (reception buffer) and return FALSE if it is zero
    DisableUart1RxInterrupt();                          // Begin of critical section
    *pchar = rxb.data[rxb.head];                        // Copy character pointed by "head" to *pchar
    rxb.count--;                                        // Decrement "count" variable
    rxb.head = (rxb.head+1) & INDEX_MASK;               // Increment "head" variable (mod BUF_SIZE)
    EnableUart1RxInterrupt();                           // End of critical section
    return 1;
} 

void _int_(24)  isr_uart1(void) {
    if(IFS0bits.U1TXIF){                                // if U1TXIF is set
        if(txb.count > 0) {                             // if "count" variable (transmission buffer, txb) is greater than 0
            U1TXREG = txb.data[txb.head];               // Copy character pointed by "head" to U1TXREG register
            txb.head = (txb.head+1) & INDEX_MASK;       // Increment "head" variable (mod BUF_SIZE)
            txb.count--;                                // Decrement "count" variable
        }
        if(txb.count == 0) {                            // if "count" variable is 0 then
            DisableUart1TxInterrupt();
        }
        IFS0bits.U1TXIF = 0;                            // Reset UART1 TX interrupt flag
    } 
    if(IFS0bits.U1RXIF){
        rxb.data[rxb.tail] = U1RXREG;                   // Read character from UART and write it to the "tail" position of the reception buffer
        rxb.tail = (rxb.tail+1) & INDEX_MASK;           // Increment "tail" variable (mod BUF_SIZE)
        if(rxb.count < BUF_SIZE) {                      // If reception buffer is not full (e.g. count < BUF_SIZE) then
            rxb.count++;                                // increment "count" variable
        }                              
        else {
            rxb.head = (rxb.head+1) & INDEX_MASK;       // increment "head" variable (discard oldest character)
        }
        IFS0bits.U1RXIF = 0;                            // reset UART1 RX interrupt flag
    }
}

int main(void) {
    comDrv_config(115200,'N',1);                        // default "pterm" parameters
                                                        // with TX and RX interrupts disabled
    comDrv_flushRx();
    comDrv_flushTx();
    EnableInterrupts();

    comDrv_puts("PIC32 UART Device-driver\n"); 
    char rec;
    while(1) {
        if(comDrv_getc(&rec)){
            if(rec == 'S') comDrv_puts("Altera a função anterior de modo a transmitir uma string com, pelo menos, 30 carateres (à sua escolha) sempre que seja recebido o carater 'S'");
            else comDrv_putc(rec);
        }
    }
    return 0;
}