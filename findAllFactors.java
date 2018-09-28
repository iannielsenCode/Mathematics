
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class findAllFactors {
  public static ArrayList<Integer> factors;
  
  public static void findFactors(){
    Scanner in = new Scanner(System.in);
    int value = in.nextInt();
    factors = new ArrayList<>();
    for(int i = 1, j = 0; i <= value; i++){
      if(value%i==0){
        factors.add(i);
        j++;
      }
    }
    System.out.print("The factors are: ");
    for(int i = 0; i < factors.size(); i++){
      System.out.print(factors.get(i) + " ");
    }
    System.out.println();
  }
  
  public static void isPrime(){
   if(factors.size() == 2){
     System.out.println("The number is prime.");
   }
   else{
     System.out.println("The number is not prime.");
   }
  }
  
  public static void main(String[] args){
    findFactors();
    isPrime();
  }  
}
