package wbs.arrays.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayListDemo {

	// wir illustrieren einige verwendungen des folgenden konstruktors
	
	// ArrayList(Collection<? extends E> c)
	
	public static void main(String[] args) {

		
		Collection<Integer> arrlist = new ArrayList<Integer> ();
		
		arrlist.add(1);
		arrlist.add(2);		
		arrlist.add(3);
		arrlist.add(4);
		arrlist.add(5);
		
		ArrayList<Integer> anotherList = new ArrayList<Integer>(arrlist);
		System.out.println(anotherList);
		
		
		// zaepernick version
		
		Set<Integer> iset = new HashSet<>();
		
		iset.add(1);
		iset.add(2);
		
		List<Double> dlist = Arrays.asList(3.0,4.0,5.0);
		
		ArrayList<Integer> al1 = new ArrayList<>(iset);
		ArrayList<Double> al2 = new ArrayList<>(dlist);
		
		ArrayList<Number> al3 = new ArrayList<>();
		
		al3.addAll(iset);
		al3.addAll(dlist);
		al3.addAll(al1);
		al3.addAll(al2);
		
		// ArrayList<? entends Number> al4 ? new ArrayList<>(iset);
		
	}

}
