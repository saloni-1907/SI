import java.util.*;  
class TreeSet3{  
 public static void main(String args[]){  
 TreeSet<Integer> set=new TreeSet<Integer>();  
         set.add(1200);  
         set.add(1);  
         set.add(34);  
         set.add(345);  
         System.out.println("Highest Value: "+set.pollFirst());  
         System.out.println("Lowest Value: "+set.pollLast());  
 }  
} 