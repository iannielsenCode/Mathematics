/********************************************************
 * Team Members: Ian Nielsen, Ketty Lazama, Justin Jiang
 *          Phi Nguyen, Matt Aupperlee, and Sean Fiedler
 * Assignment #1 : List all of the subsets of a given set
 * Due Date: February 3rd 2015
 *******************************************************/
import java.util.ArrayList;
import java.util.Scanner;

public class findPowerSet {
  public static void main(String[] args){
    ArrayList<Character> set = new ArrayList<>(); //Represents the set.
    while(0==0){
      System.out.print("Enter the next element of the set:");
      Scanner input = new Scanner(System.in);
      String a = input.next();
      if("0".equals(a)){
        break; //The loop will terminate once the user enter a zero. Reason for 
      }        //infinite loop.
      char b = a.charAt(0); //Conversion of the given string to a character.
      set.add(b); 
    }
    ArrayList<ArrayList<Character>> collection = findAllSubsets(set); 
    //The power set is an arraylist of arraylists, or a set of sets. 
    for(ArrayList<Character> sub : collection){ 
      System.out.println(sub); 
    }
  }
  
   /* Algorithm to find power set: A power set is the set of all subsets of a 
   * given set including the null set. To find all subsets of a given set A
   * remove the first element to give you set B. Recursively find all of the
   * subsets of B. The subsets of B are subsets of A. Then add the first element
   * of A to each of the subsets of B, which are now all subsets of A as well.
   * The method will return this power set.
   */
  public static ArrayList<ArrayList<Character>> findAllSubsets(ArrayList<Character> arr){
    ArrayList<ArrayList<Character>> collection = new ArrayList<ArrayList<Character>>();
    if(arr.isEmpty()){                            //Add the null set to the 
      collection.add(new ArrayList<Character>()); //power set once all other
    }                                             //subsets have been found.
    else{                                         
      ArrayList<Character> subset = new ArrayList<>();
      ArrayList<ArrayList<Character>> subset2 = new ArrayList<ArrayList<Character>>();
      subset.addAll(arr);
      char first = subset.remove(0); //Remove the first element of A to give you set B.
      subset2 = findAllSubsets(subset); //Recursively find all subsets of B.
      collection.addAll(subset2); //The subsets of B are now subsets of A.
      subset2 = findAllSubsets(subset);
      for(ArrayList<Character> sub : subset2){
        sub.add(0,first); //Add the first element of A to each of the subsets of B.
      }
      collection.addAll(subset2); //Those are now all subsets of A.
    }
    return collection;
  }
  
}
