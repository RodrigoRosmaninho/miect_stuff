#include<stdio.h>
#include "elapsed_time.h"

typedef unsigned long long u64;

int numOp;

int main(void){
    // Montes de código repetido porque não há lambdas em C      :-(
    int last = 0;
    int lastNumOp = 0;
    printf("\n");

    // phi = golden number = 1.618

    // RECURSIVE - O(phi^n)
    printf(" ************************* RECURSIVE *************************\n");
    printf(" _____________________________________________________________ \n");
    printf("| n  | F(n) | F(n)/F(n-1) | numOp | A(n)/A(n-1) | elapsedTime |\n");
    printf("|-------------------------------------------------------------|\n");
    for(int i = 0; i < 10; i++){
        (void) elapsed_time();
        int res = recursive(i);
        printf("| %2d | %4d | %11f | %5d | %11f |%12.9f |\n", i, res, ((double) res / (double) last), numOp, ((double) numOp / (double) lastNumOp), elapsed_time());
        last = res;
        lastNumOp = numOp;
        numOp = 0;
    }
    printf("|_____________________________________________________________|\n\n");

    // REPETITIVE
    printf(" ************************ REPETITIVE *************************\n");
    printf(" _____________________________________________________________ \n");
    printf("| n  | F(n) | F(n)/F(n-1) | numOp | A(n)/A(n-1) | elapsedTime |\n");
    printf("|-------------------------------------------------------------|\n");
    for(int i = 0; i < 10; i++){
        (void) elapsed_time();
        int res = repetitive(i);
        printf("| %2d | %4d | %11f | %5d | %11f |%12.9f |\n", i, res, ((double) res / (double) last), numOp, ((double) numOp / (double) lastNumOp), elapsed_time());
        last = res;
        lastNumOp = numOp;
        numOp = 0;
    }
    printf("|_____________________________________________________________|\n\n");

    // CLOSED1
    printf(" ************************** CLOSED1 **************************\n");
    printf(" _____________________________________________________________ \n");
    printf("| n  | F(n) | F(n)/F(n-1) | numOp | A(n)/A(n-1) | elapsedTime |\n");
    printf("|-------------------------------------------------------------|\n");
    for(int i = 0; i < 10; i++){
        (void) elapsed_time();
        int res = closed1(i);
        printf("| %2d | %4d | %11f | %5d | %11f |%12.9f |\n", i, res, ((double) res / (double) last), numOp, ((double) numOp / (double) lastNumOp), elapsed_time());
        last = res;
        lastNumOp = numOp;
        numOp = 0;
    }
    printf("|_____________________________________________________________|\n\n");

    // CLOSED2
    printf(" ************************** CLOSED2 **************************\n");
    printf(" _____________________________________________________________ \n");
    printf("| n  | F(n) | F(n)/F(n-1) | numOp | A(n)/A(n-1) | elapsedTime |\n");
    printf("|-------------------------------------------------------------|\n");
    for(int i = 0; i < 10; i++){
        (void) elapsed_time();
        int res = closed2(i);
        printf("| %2d | %4d | %11f | %5d | %11f |%12.9f |\n", i, res, ((double) res / (double) last), numOp, ((double) numOp / (double) lastNumOp), elapsed_time());
        last = res;
        lastNumOp = numOp;
        numOp = 0;
    }
    printf("|_____________________________________________________________|\n\n");

    // CLOSED3
    printf(" ************************** CLOSED3 **************************\n");
    printf(" _____________________________________________________________ \n");
    printf("| n  | F(n) | F(n)/F(n-1) | numOp | A(n)/A(n-1) | elapsedTime |\n");
    printf("|-------------------------------------------------------------|\n");
    for(int i = 0; i < 10; i++){
        (void) elapsed_time();
        int res = closed3(i);
        printf("| %2d | %4d | %11f | %5d | %11f |%12.9f |\n", i, res, ((double) res / (double) last), numOp, ((double) numOp / (double) lastNumOp), elapsed_time());
        last = res;
        lastNumOp = numOp;
        numOp = 0;
    }
    printf("|_____________________________________________________________|\n\n");
}

/*
int main(void){
    printf(" _________________________________________________________________________________________ \n");
    printf("| n  | rec(n) | numOp | rep(n) | numOp | cl1(n) | numOp | cl2(n) | numOp | cl3(n) | numOp |\n");
    printf("|-----------------------------------------------------------------------------------------|\n");
    for(int i = 0; i < 10; i++){
        printf("| %2d |", i);
        int res[5] = {recursive(i), repetitive(i), closed1(i), closed2(i), closed3(i)};
        for(int j = 0; j < 5; j++) printf(" %6d | %5d |", res[j], numOp[j]);
        printf("\n");
    }
    printf("|_________________________________________________________________________________________|\n");
}
*/

int recursive(int num) {
    if(num == 0) return 0;
    if(num == 1) return 1;
    numOp++;
    return recursive(num - 1) + recursive(num - 2);
}

int repetitive(int num) {
    int actual;
    int prev1 = 1;
    int prev2 = 0;

    if(num == 0) return 0;
    if(num == 1) return 1;
    for(int i = 2; i <= num; i++){
        numOp++;
        actual = prev1 + prev2;
        prev2 = prev1;
        prev1 = actual;
    }

    return actual;
}

int closed1(int num){
    numOp++;
    double theta = (1 + sqrt(5)) / 2;
    return (pow(theta, num) - pow(1 - theta, num))/(sqrt(5));
}

int closed2(int num){
    numOp++;
    double theta = (1 + sqrt(5)) / 2;
    return round(pow(theta, num) / sqrt(5));
}

int closed3(int num){
    numOp++;
    double c1 = 0.44721357549995793928;
    double c2 = 0.48121182505960344750;
    return round(c1 * exp(num * c2));
}