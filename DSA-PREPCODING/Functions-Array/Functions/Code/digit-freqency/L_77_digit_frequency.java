import java.util.Scanner;

public class L_77_digit_frequency {
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt(); // number
        int d = scn.nextInt(); // digit to find

        int ans = digitFrequency(n, d);

        System.out.println(ans);
    }

    public static int digitFrequency(int n, int d) {
        int count = 0;

        while (n > 0) {
            int rem = n % 10; // last digit

            if (rem == d) {
                count++;
            }

            n = n / 10; // remove last digit
        }

        return count;
    }
}