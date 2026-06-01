import java.util.Scanner;

    public class prepcoding_01_02 {
    public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int t = scn.nextInt();

    for(int i = 0; i < t ; i++){
        int n = scn.nextInt();


        int count = 0;

        for (int div = 2; div * div <= n; div++){
            if (n % div == 0){
                count++;
                break; // we can break the loop as soon as we find a divisor, since we only need to know if there is at least one divisor or not
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

