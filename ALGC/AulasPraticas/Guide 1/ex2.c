#include<stdio.h>
#include<math.h>

long pw[11];
int mult;

long power(int i){
    if(pw[i] != 0 || i == 0) return pw[i];
    mult += 2;
    pw[i] = pow(i,3);
    return pw[i];
}

int main(void){
    mult = 0;
    int count = 0;
    pw[0] = 0;
    pw[1] = 1;

    for(int i = 100; i <= 999; i++){
        int copy = i;
        int sum = power(copy % 10);
        copy = copy / 10;
        while(copy > 0){
            sum += power(copy % 10);
            copy = copy / 10;
        }

        if(sum == i){
            printf("%d is an Armstrong number\n", i);
            count++;
        }
    }

    printf("\nFound %d Armstrong numbers from 100 to 999, with %d multiplications\n", count, mult);

    return 0;
}