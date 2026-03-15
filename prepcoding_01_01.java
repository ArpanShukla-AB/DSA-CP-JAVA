//better algorithm for checking prime number 
//algorithm, says if a number is not prime, then it must have a divisor less than or equal to sqrt(n)
//so we can check for divisibility only up to sqrt(n) instead of n, which reduces the number of iterations significantly for larger numbers

import java.util.Scanner;

    public class prepcoding_01_01 {
    public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int t = scn.nextInt();

    for(int i = 0; i < t ; i++){
        int n = scn.nextInt();


        int count = 0;

        for (int div = 2; div * div <= n; div++){
            if (n % div == 0){
                count++;
            }
        }

        if (count == 0){
            System.out.println("Prime");
        } else {
            System.out.println(" Not Prime");
        }
    }
    }
}

