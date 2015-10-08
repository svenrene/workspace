package wbs.arrays.die_klasse_arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AsListDemo {

	public static void main(String[] args) {

		String[] sa = { "eins", "zwei", "drei" };

		List<String> list1 = Arrays.asList(sa);
		List<String> list2 = Arrays.asList("eins", "zwei", "drei");
		
		// die gelieferte list kann in ihrer groesse nicht geändert werden
		try {
			list1.remove(0);
		}
		catch(UnsupportedOperationException e){
			System.out.println("die list hat eine fixe groesse");
		}
		
		// die gelieferte list referenziert dieselben objekte wie das übergebene array
		list1.set(0, "null");
		System.out.println(Arrays.toString(sa));
		
		// wir geben das kleinste element von list2 aus unter verwendung einer passenden
		// methode der klasse java.util.Collections
		String min = Collections.min(list2);
		System.out.println(min);
				
		}

}
