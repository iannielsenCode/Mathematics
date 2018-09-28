public class SetTest {
  
  public static void main(String[] args){
      Set one = new Set();
      Set two = new Set();
      one.insert("Hello");
      one.insert("how");
      one.insert("are");
      two.insert("you");
      two.insert("today?");
      Set three = Set.union(one,two);
      three.print();
  }
  
}
