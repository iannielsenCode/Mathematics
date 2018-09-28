import java.util.ArrayList;
import java.util.Random;

public class LinearDiophantine{
  public static void main(String[] args){
    ArrayList<Integer> factors1 = new ArrayList<>();
    ArrayList<Integer> factors2 = new ArrayList<>();
    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[1]);
    int c = Integer.parseInt(args[2]);
    factors1 = findFactors(a);
    factors2 = findFactors(b);
    System.out.println(factors1);
    System.out.println(factors2);
    int gcd = greatestCommonDivisor(factors1,factors2);
    System.out.println(gcd);
    int[] solutions = new int[2];
    if((c%gcd) != 0){
      System.out.println("No solution.");
    }
    else{
      solutions = findSolution(a,b,c,gcd);
      System.out.println(solutions[0] + " " + solutions[1]);
      infiniteSolutions(a,b,c,gcd,solutions[0], solutions[1]);
    }
    
  }
  
  public static ArrayList<Integer> findFactors(int num){
    ArrayList<Integer> factors = new ArrayList<>();
    
    for(int i = 1; i <= num; i++){
      if((num%i) == 0){
        factors.add(i);
      }
    }
    
    return factors;
  }

  public static int greatestCommonDivisor(ArrayList<Integer> one, ArrayList<Integer> two){
    ArrayList<Integer> commonFactors = new ArrayList<>();
    for(int i = 0; i < one.size(); i++){
      for(int j = 0; j < two.size(); j++){
        if(one.get(i) == two.get(j)){
          commonFactors.add(one.get(i));
        }
      }  
    }
    int largest = 1;
    for(int k = 0; k < commonFactors.size(); k++){
      if(commonFactors.get(k) > largest){
        largest = commonFactors.get(k);
      }
    }
    
    return largest;

  }

  public static int[] findSolution(int a, int b, int c, int gcd){
    Random r = new Random();
    int[] array = new int[2];
    boolean flag = true;
    while(flag){
      int x = r.nextInt(100);
      int y = r.nextInt(100);
      if((a*x + b*y) != c){
        flag = true;
      }
      else{
        array[0] = x;
        array[1] = y; 
        break;
      }
    } 
    return array;
  }

  public static void infiniteSolutions(int a, int b, int c, int gcd, int x, int y){
    int X,Y;
    int t = 0;
    do{
      X = x + (t* (b/gcd));
      Y = y - (t* (a/gcd));
      System.out.println("x = " + X + " " + "y = " + Y);
      t++;
      try {
        Thread.sleep(30);                 
      } catch(InterruptedException ex) {
          Thread.currentThread().interrupt();
      }
    }while((a*X) + (b*Y) == c);
  }

}