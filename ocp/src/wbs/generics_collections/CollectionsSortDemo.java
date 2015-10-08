package wbs.generics_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class C1 implements Comparable<Object>{

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

class C2 implements Comparable<Integer>{

	@Override
	public int compareTo(Integer o) {
		// TODO Auto-generated method stub
		return 0;
	}

}

public class CollectionsSortDemo {

	public static void main(String[] args) {
		/*
		 * wir versuchen, eine List von StringBuffer / StringBuilder / String u
		 * unter verwendung einer methode sort() der klasse Collections zu sortieren
		 */

		List<StringBuffer> list_1 = new ArrayList<>();
		List<StringBuilder> list_2 = new ArrayList<>();
		List<String> list_3 = new ArrayList<>();
		
		// compilerfehler
		// StringBuffer implementiert das interface Comparable nicht
		// (weder für den typ StringBuffer, noch für den basistyp davon)
		// Collections.sort(list_1);

		// compilerfehler
		// StringBuilder implementiert das interface Comparable nicht
		// (weder für den typ StringBuilder, noch für den basistyp davon)
		// Collections.sort(list_2);
		
		// ok, die klasse String implementiert das interface Comparable<String>
		Collections.sort(list_3);
		
		// wir versuchen, eine List von C1 zu sortieren
		
		List<C1> list_4 = new ArrayList<>();
		Collections.sort(list_4);
		
		List<C2> list_5 = new ArrayList<>();
		// Collections.sort(list_5);
		
		// wir sortieren eine List von StringBuffer unter verwendung eines 
		// Comparators. die StringBuffer- objekte sollen dabei wie strings 
		// sortiert werden.wir führen also das sortieren der stringbuff
		// auf das natural ordering der klasse string zurück. der comparator
		// soll als instanz einer anonymen klasse implementiert werden.
		Comparator<StringBuffer> cmp = new Comparator<StringBuffer>() {

			@Override
			public int compare(StringBuffer sb1, StringBuffer sb2) {
				return sb1.toString().compareTo(sb2.toString());
			}
			
		};
		list_1.add(new StringBuffer("a"));
		list_1.add(new StringBuffer("z"));
		list_1.add(new StringBuffer("u"));
		Collections.sort(list_1, cmp);
		System.out.println(list_1);
	}

}
