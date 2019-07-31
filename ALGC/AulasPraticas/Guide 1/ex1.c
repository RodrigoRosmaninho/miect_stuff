#include<stdio.h>

int adicoes[3];

int f1 (int n) {
    adicoes[0] = 0;
    int i, j, r = 0;
    for (i = 1; i <= n; i++){
        for (j = 1; j <= n; j++){
            adicoes[0]++;
            r += 1;
        }
    }
    return r;
}

int f2 (int n) {
    adicoes[1] = 0;
    int i, j, r = 0;
    for (i = 1; i <= n; i++) {
        for (j = 1; j <= i; j++) {
            adicoes[1]++;
            r += 1;
        }
    }
    return r;
}

int f3 (int n) {
    adicoes[2] = 0;
    int i, j, r = 0;
    for (i = 1; i <= n; i++) {
        for (j = i; j <= n; j++) {
            adicoes[2]++;
            r += j;
        }
    }
    return r;
}

int main(void) {
    printf("N  | f1(N) | N adicoes | f2(N) | N adicoes | f3(N) | N adicoes\n");
    for(int i = 1; i <= 10; i++){
        int res[3] = {f1(i), f2(i), f3(i)};
        printf("%2d | %3d   | %3d       | %3d   | %3d       | %3d   | %3d\n", i, res[0], adicoes[0], res[1], adicoes[1], res[2], adicoes[2]);
    }
}