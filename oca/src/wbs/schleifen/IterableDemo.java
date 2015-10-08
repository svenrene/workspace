package wbs.schleifen;

import java.util.ArrayList;
import java.util.Iterator;

public class IterableDemo {

	public static void main(String[] args) {

		// wir legen einige strings in einer ArrayList ab
		
		ArrayList<String> al = new ArrayList<>();
		al.add("a");
		al.add("b");
		al.add("c");
		// wir geben alle elemente mit foreach aus
		for(String s : al){
			System.out.println(s);
		
	}
	// ausgabe mit einem Iterator
	Iterator<String> itr = al.iterator();
	while(itr.hasNext()) {
		System.out.println(itr.next());
	}
	
	//System.out.println(itr.getClass().getName());
	
}
}