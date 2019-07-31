#include<stdio.h>
#include "pqueue.h"
#include "pqueue.c"

int main(){
    int list[] = {-3, 4, 5, 10, -1, 90, 2, 34, -100};

    PtPQueue pqueue = PQueueCreate(9);

    for(int i = 0; i < 9; i++) {
        PQueueInsert(pqueue, list[i]);
    }

    int arr[9];
    for(int i = 1; i <= 9; i++){
        int pelem;
        PQueueDeleteMax(pqueue, &pelem);
        arr[9-i] = pelem;
    }

    for(int i = 0; i < 9; i++){
        printf("%d\n", arr[i]);
    }

}
