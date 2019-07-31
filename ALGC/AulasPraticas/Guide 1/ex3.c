#include<stdio.h>

long fat[11];
int mult;

long fatorial(int i){
    if(fat[i] != 0) return fat[i];
    fat[i] = i * fatorial(i - 1);
    mult++;
    return fat[i];
}

int main(void){
    mult = 0;
    fat[0] = 1;
    fat[1] = 1;

    int count = 0;

    for(int i = 1; i <= 100000; i++){
        int copy = i;
        int sum = fatorial(copy % 10);
        copy = copy / 10;
        while(copy > 0){
            sum += fatorial(copy % 10);
            copy = copy / 10;
        }

        if(sum == i){
            printf("%d is factorian\n", i);
            count++;
        }
    }

    printf("\nFound %d factorians from 1 to 100000, with %d multiplications\n", count, mult);

    return 0;
}