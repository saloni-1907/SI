import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkedListDemo {
	public static void main(String[] args)
	{
		List list1=new ArrayList();
		List<String> list2=new ArrayList<>();
		
		//generic list demo
		list1.add(1);
		list1.add("String 1");
		Object obj=list1.get(0);
		System.out.println(obj);
		
		//non-generic
		list2.add("Hello");
		//list2.add(1);//error since its meant for Strings only
		System.out.println(list2.get(0));
		
		List<Integer> list3=new ArrayList<>(Arrays.asList(1,2,3));
		System.out.println(list3);
		
		for(Integer i: list3)
		{
			System.out.println(i);
		}
		list2.clear();
		System.out.println(list2);
		
	}
	
}
