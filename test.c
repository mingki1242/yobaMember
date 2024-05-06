#include <stdio.h>
int main ()
{
    int t1 = 3;
    int t2 = 4;
    int t3 = 5;
    printf("%d" , t1&&t2 + t1||t2 + !t3);
}