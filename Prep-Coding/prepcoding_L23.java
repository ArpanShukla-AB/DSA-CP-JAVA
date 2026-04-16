import java.util.Scanner;
public class prepcoding_L23 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int inv = 0;
        int op = 1; //op -> original place
        
        while (n!=0){
            int od = n % 10;
            int id = op;  //-> inverse place id -> inverse digit
            int ip = od;  ////-> inverse place


            inv = inv + id * (int)Math.pow(10, ip-1);

            n = n/10;
            op++;
        }
        System.out.println(inv);    
    }
}


