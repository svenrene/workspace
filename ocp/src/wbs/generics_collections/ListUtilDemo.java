package wbs.generics_collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListUtilDemo {

	public static void main(String[] args) {
		
		List<Number> ln = new ArrayList<>();
		List<Integer> li = new ArrayList<>();
		
		// ListUtil.copy(li, ln); // ok
		// ListUtil.copy(ln, li) // compilerfehler
		
		List<String> sList = new ArrayList<>();
		
		sList.addAll(Arrays.asList("a","z", "b", "y", "c", "x"));
		
		String max = ListUtil.max(sList);
		
		System.out.println(max);
		
		max = ListUtil.max(sList, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				return s2.compareTo(s1);
			}
			
		});
		System.out.println(max);
		
		max = ListUtil.max(sList, Collections.reverseOrder());
		System.out.println(max);
		
	//	max = ListUtil.max(sList, Collections.reverseOrder());
	}
	


}
