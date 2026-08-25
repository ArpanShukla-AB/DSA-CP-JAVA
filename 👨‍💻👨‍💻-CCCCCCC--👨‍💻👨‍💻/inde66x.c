#include<stdio.h>
#include<stdlib.h>
int main(){
int m,n,sum=0,i,j;
int a[3][4],b[4][2],result[3][3];
printf("enter the first matrix\n");
for(int i=0;i<3;i++)
{
for(int j=0;j<4;j++){
printf("enter te  %d %d elemnent of first matrix\n",i,j);
scanf("%d",&a[i][j]);
}
}
printf("enter the second matrix \n");
for(int i=0;i<4;i++)
{
for(int j=0;j<2;j++)
{
printf("enter te  %d %d elemnent of first matrix\n",i,j);
scanf("%d",&b[i][j]);
}
}

for(i=0; i<3; i++)
{
    for(j=0; j<2; j++)
    {
for(int k=0;k<4;k++)
{
sum +=a[i][j]*b[k][j];

}
result[i][j]=sum;
sum=0;
}
}

for(i=0; i<3; i++)
{
for(j=0; j<2; j++)
{
printf("%d\t",result[i][j]);
}
printf("\n");
}
printf("\n");
return 0;
}