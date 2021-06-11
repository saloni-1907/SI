//Counting nodes of a linked list

import java.util.*;
class Node{
 int data;
 Node next;
 
 Node(int a){
     data = a;
     next = null;
 }
 
}


class Count
{
 //Function to count nodes of a linked list.
 public static int getCount(Node head)
 {
    int count=0;
    while(head.next!=null)
    {
        count++;
        head=head.next;
    }
    return count+1;
 }
}
 


class CountNodes{
 
 public static void main(String[] args){
     Scanner sc=new Scanner(System.in);
     int t=sc.nextInt();
     while(t-->0)
     {
         int n=sc.nextInt();
         Node head = new Node(sc.nextInt());
         Node tail = head;
         for(int i=0; i<n-1; i++)
         {
             tail.next = new Node(sc.nextInt());
             tail = tail.next;
         }
         
         Count ob = new Count();
         System.out.println(Count.getCount(head));
     }
 }

 
 
 
}

