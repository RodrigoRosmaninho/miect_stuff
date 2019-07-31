#include <detpic32.h>

volatile unsigned char voltage = 0;

void delay(int ms){
    for(; ms > 0; ms--){
        resetCoreTimer();
        while(readCoreTimer() < PBCLK / 1000);
    }
}

unsigned char toBcd(unsigned char value){
    return ((value / 10) << 4) + (value % 10);
}

void send2displays(unsigned char value) {
    static const char display7Scodes[] = {0x3F, 0x06, 0x5B, 0x4F, 0x66, 0x6D, 0x7D, 0x07, 0x7F, 0x6F, 0x77, 0x7C, 0x39, 0x5E, 0x79, 0x71};
    static int displayFlag = 0;

    int value_high = value >> 4;
    int value_low = value & 0x0F;

    if(!displayFlag){
        LATDbits.LATD5 = 0;
        LATDbits.LATD6 = 1;

        LATB = display7Scodes[value_high] << 8 | (LATB & 0x00FF);
    }
    else {
        LATDbits.LATD5 = 1;
        LATDbits.LATD6 = 0;

        LATB = display7Scodes[value_low] << 8 | (LATB & 0x00FF);
    }

    displayFlag = !displayFlag;
}

void _int_(27) isr_adc(void){
    int* p = (int *)(&ADC1BUF0);
    int VAL_ADD = 0;
    for(; p < (int *)(&ADC1BUF8); p+= 4){
        VAL_ADD += *p;
    }
    voltage = (char) (((VAL_ADD / 8)*33+511) / 1023);
    printInt(voltage, 10);
    putChar('\n');
    IFS1bits.AD1IF = 0;
}

int main(void){
    TRISBbits.TRISB4 = 1; // RBx digital output disconnected
    AD1PCFGbits.PCFG4= 0; // RBx configured as analog input (AN4)
    AD1CON1bits.SSRC = 7; // Conversion trigger selection bits: in this mode an internal counter ends sampling and starts conversion
    AD1CON1bits.CLRASAM = 1; // Stop conversions when the 1st A/D converter interrupt is generated. At the same time, hardware clears the ASAM bit
    AD1CON3bits.SAMC = 16; // Sample time is 16 TAD (TAD = 100 ns)
    AD1CON2bits.SMPI = 8-1; // Interrupt is generated after XX samples (replace XX by the desired number of onsecutive samples)
    AD1CHSbits.CH0SA = 4; // replace x by the desired input analog channel (0 to 15)
    AD1CON1bits.ON = 1; // Enable A/D converter - This must the last command of the A/D configuration sequence

    IPC6bits.AD1IP = 2;
    IFS1bits.AD1IF = 0;
    IEC1bits.AD1IE = 1;

    EnableInterrupts();

    LATD &= 0xFF9F;
    LATB &= 0x80FF;

    TRISD &= 0xFF9F;
    TRISB &= 0x80FF;
    
    int cnt = 0;
    while(1){
        if(cnt++ % 25 == 0){
            AD1CON1bits.ASAM = 1; // Start conversion
        }
        send2displays(toBcd(voltage));
        delay(10);
    }

    return 0;
}
