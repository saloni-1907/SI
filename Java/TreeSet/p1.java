import java.util.Iterator;
import java.util.TreeSet;

public class TreeSet1 {

	public static void main(String[] args) {
		TreeSet <String> ts=new TreeSet<String>();
		ts.add("One");
		ts.add("Two");
		ts.add("Three");
		ts.add("Four");
		
		Iterator<String>itr=ts.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}

	}

}