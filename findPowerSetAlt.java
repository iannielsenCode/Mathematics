public class findPowerSetAlt {
  public static void altMethod(){
    int n;
    int[] bin = new int[4];
    char[] symbol = {'a', 'p', 't', 'x'};
    
    for(n = 0; n < (1 << 4); n++){
      convert(n,bin);
      print(bin, symbol);
    }
  }
  
  public static void convert(int x, int[] a){
    for(int i = 0; i < a.length; i++){
      a[i] = x%2;
      x/=2;
    }
  }
  
  public static void print(int[] b, char[] s){
    System.out.print("{");
    for(int i = 0; i < b.length; i++){
      if(b[i] == 1){
        System.out.print(s[i] + ",");
      }
    }
    System.out.println("}");
  }
}
}
