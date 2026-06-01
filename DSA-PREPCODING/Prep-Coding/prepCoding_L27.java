import java.util.Scanner;
public class prepCoding_L27 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int on1 = n1; //on1 -> original n1
        int on2 = n2; //on2 -> original n2

        while(n1 % n2 != 0){
            int rem = n1 % n2; //rem -> remainder
            n1 = n2; //n1 -> n2
            n2 = rem; //n2 -> rem
        }

        int gcd = n2; //gcd -> greatest common divisor
        int lcm = (on1 * on2) / gcd; //lcm -> least common multiple

        System.out.println(gcd);
        System.out.println(lcm);
    }
}