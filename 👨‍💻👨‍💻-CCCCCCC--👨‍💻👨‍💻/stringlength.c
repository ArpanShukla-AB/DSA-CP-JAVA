#include<stdio.h>
#include<string.h>
void main(){
    char str[20];
    int i;
    gets(str);
    for(i=0; str[i]!='\0';i++);
    printf("%d",i);
    return 0;
}