public class Set {
  private static int cap = 1024;
  private String[] data;
  private int top;
  
  public Set(){
    data = new String[cap];
    top = 0;
  }
  
  public int getSize(){
    return top;
  }
  
  public boolean isElement(String target){
        for(int i = 0;i< top;i++){
            if(target.equals(data[i])){
                return true;
            }
        }
        return false;
    }
  
  public void insert(String target){
    if(isElement(target)){
      return;
    }
    
    data[top++] = target;
  }
  
  public void print(){
        for(int i = 0; i< top; i++){
            System.out.print(data[i] + " ");
        }
        System.out.println();
  }
  
  public void remove(String target){
        if(position(target) == -1){
            return;
        }
        data[position(target)] = data[--top];
  }
  
  private int position(String target){
        for(int i = 0;i< top;i++){
            if(target.equals(data[i])){
                return i;
            }
        }
        return -1;
    }
  
  public static Set union(Set s1, Set s2){
        Set s = new Set();
        for(int i = 0; i < s1.top;i++){
            s.insert(s1.data[i]);
        }
        for(int j = 0; j < s2.top;j++){
            s.insert(s2.data[j]);
        }
        return s;
    }
  
  public static Set diff(Set s1, Set s2){
        Set s = new Set();
        for(int i = 0; i < s1.top;i++){
            s.insert(s1.data[i]);
        }
        for(int j = 0; j < s2.top;j++){
            s.remove(s2.data[j]);
        }
        return s;
    }
  
  public static Set intersection(Set s1, Set s2){
        return diff(s1,diff(s1,s2));
    }
    
  public static boolean equals(Set s1, Set s2){
        return diff(s1,s2).getSize() == 0 && diff(s2,s1).getSize() == 0;
  }
}
