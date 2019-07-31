#include <detpic32.h>

void delay(int ms) {
    for(; ms > 0; ms--) {
        resetCoreTimer();
        while(readCoreTimer() < 20000);
    }
} 

int main(void) {
    LATE = LATE & 0xFFF0; // The initial value should be set before configuring the port as output
    TRISE = TRISE & 0xFFF0; // Configured as output

    int counter = 0;
    while(1) {
        delay(500); // half period = 0.5s
        LATE = counter & 0x000F; //....
        counter++;
    }
    return 0;
}
