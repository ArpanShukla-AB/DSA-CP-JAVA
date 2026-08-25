#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a[3][4], b[4][2], result[3][2];
    int sum;

    printf("Enter the elements of the first matrix (3x4):\n");
    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 4; j++)
        {
            printf("a[%d][%d]: ", i, j);
            scanf("%d", &a[i][j]);
        }
    }

    printf("Enter the elements of the second matrix (4x2):\n");
    for (int i = 0; i < 4; i++)
    {
        for (int j = 0; j < 2; j++)
        {
            printf("b[%d][%d]: ", i, j);
            scanf("%d", &b[i][j]);
        }
    }

    // Matrix multiplication
    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 2; j++)
        {
            sum = 0;
            for (int k = 0; k < 4; k++)
            {
                sum += a[i][k] * b[k][j];
            }
            result[i][j] = sum;
        }
    }

    // Print the resultant matrix
    printf("Resultant matrix (3x2):\n");
    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 2; j++)
        {
            printf("%d\t", result[i][j]);
        }
        printf("\n");
    }

    return 0;
}
