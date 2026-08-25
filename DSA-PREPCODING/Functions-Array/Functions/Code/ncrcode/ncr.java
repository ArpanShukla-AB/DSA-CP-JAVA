import java.util.Scanner;

public class ncr{
    public static int fact(int x) {
        int returnValue = 1;
        for (int i = 1; i <= x ; i++){
            returnValue = returnValue * i;
        }
        return returnValue;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int r = scn.nextInt();

        int nfact = fact(n);
        int nmrfact = fact(n - r);

        int npr = nfact / nmrfact;
        System.out.println(n + "P" + r + " = " + npr);
    }
}