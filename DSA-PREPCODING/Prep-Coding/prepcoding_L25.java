import java.util.Scanner;
public class prepcoding_L25 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        int temp = n;
        int nod = 0; //nod -> number of digits
        while (temp>0){
            temp = temp/10;
            nod++;
        }

        k = k % nod; //k -> effective rotation
        if (k<0){
            k = k + nod; //k -> effective rotation
        }

        int div = 1;
        int mul = 1;
        for(int i = 1;i<=nod ; i++){
            if (i<=k){
                div = div * 10;
            } else {
                mul = mul * 10;
            }
        }

        int q = n / div; //q -> quotient
        int r = n % div; //r -> remainder

        int rot = r * mul + q; //rot -> rotated number
        System.out.println(rot);
    }
}