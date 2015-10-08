package wbs.nested_classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NestedClassesImJDKDemo {

	public static void main(String[] args) {
		
		List<Integer> iList = new ArrayList<>();
		System.out.println(iList.iterator().getClass().getName());
		
		Set<Integer> iSet = new HashSet<>();
		System.out.println(iSet.iterator().getClass().getName());

		System.out.println(Collections.unmodifiableList(iList).getClass().getName());
	}

}
