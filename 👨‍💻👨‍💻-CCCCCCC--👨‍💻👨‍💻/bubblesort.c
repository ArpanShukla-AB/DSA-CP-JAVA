#inlude<stdio.h>

void main(){
    int n,i,j,temp,a[100];
    printf("Enter the value of elements \n");
    scanf("%d",&n);
    printf("Enter the %d of elements",n);
    
    
    for(i=0;i<n;i++)
        scanf("%d",&a[i]);
    printf("the input array is \n");
    for(i=0;i<n;i++)
    printf("%d",a[i]);
    for(i=1;i<n;i++)
    {
        for(j=0;j<n-1;j++)
        {

    if (a[j]>a[j+1])
    {
        temp=a[j];
        a[j]=a[j+1];
        a[j+1]=temp;
    }
}
}
printf("The sorted array\n");
for (i=0;i<n;i++)
{
    printf("%d \n",a[i]);
}
}
