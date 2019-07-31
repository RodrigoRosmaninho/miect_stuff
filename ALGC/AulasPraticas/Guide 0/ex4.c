#include<stdio.h>
#include<math.h>

int main(void){
    printf("    | sin() | cos() | sin² + cos²\n");
    printf("----|-------|-------|------------\n");

    for(int i = 0; i <= 180; i+=30){
        printf("%3d | %4.2f | %4.2f | %1.1f\n", i, sin(i), cos(i), pow(sin(i), 2) + pow(cos(i), 2));
    }
    
}