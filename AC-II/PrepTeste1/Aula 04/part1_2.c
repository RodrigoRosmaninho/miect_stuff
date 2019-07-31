#include <detpic32.h>

void delay(int ms){
    for(;ms > 0; ms--){
        resetCoreTimer();
        while(readCoreTimer() < 20000);
    }
}

int main(void) {
    LATE &= 0xFFF0;
    TRISE &= 0xFFF0;

    int counter = 0;
    while(1){
        delay(125);
        LATE &= 0xFFF0;
        LATE |= counter & 0x000F; //....
        counter++;
    }
    return 0;
}