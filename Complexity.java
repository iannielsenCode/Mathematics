
import java.util.Scanner;

public class Complexity {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = 0;
    for(int i = n;i>0;i/=2){
      for(int j = 0;j<i;j++){
        System.out.println(n);
        k++;
      }
    }
    System.out.println(k);
  }
}
