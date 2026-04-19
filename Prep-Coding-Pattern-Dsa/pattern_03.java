import java.util.Scanner;
public class pattern_03 {
    public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int space = n-1;
      int star = 1;
      for(int i = 1 ; i <=n ; i++){
        System.out.print(space + " " + star);
        space--;    
        star++;
        System.out.println();
      }
    }
}
