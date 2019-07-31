#include<stdio.h>
#include "stack.h"
#include "queue.h"

void stringRev(char* str) {
    PtStack s = StackCreate(sizeof(char));
    while(*str != '\0'){
        StackPush(s,str);
        str+=sizeof(char);
    }
    while(!StackIsEmpty(s)){
        char c;
        StackPop(s, &c);
        printf("%c", c);
    }
    printf("\n");
}

int main(void)
{
    char string[20];
    stringRev(string);
    return 0;
}