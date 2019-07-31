#include<stdio.h>
#include<math.h>

int main(void){
    printf("i | i*i | sqrt(i)\n");
    printf("--|-----|--------\n");

    for(int i = 0; i < 10; i++){
        printf("%d | %3d | %f \n", i, i*i, sqrt(i));
    }
    
}