//
// Created by rrosmaninho on 12-02-2019.
//

#include <stdio.h>

int main(void){
    puts("Hello World");
    char name[50];
    fgets(name, 50, stdin);
    puts(name);

    return 0;
}