import java.util.*;  
class TreeSet2{  
 public static void main(String args[]){  
 TreeSet<String> set=new TreeSet<String>();  
         set.add("Devil");  
         set.add("Princess");  
         set.add("Angel");  
         System.out.println("Traversing element through Iterator in descending order");  
         Iterator<String> i=set.descendingIterator();  
         while(i.hasNext())  
         {  
             System.out.println(i.next());  
         }  
           
 }  
}  