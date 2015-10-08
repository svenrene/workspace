package wbs.nested_classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class ListComparator<T extends Comparable<? super T>> implements
Comparator<List<T>> {
	@Override
	public int compare(List<T> list1, List<T> list2) {
		int diff = list1.size() - list2.size();
		return diff != 0 ? diff : Collections.max(list1).compareTo(Collections.max(list2));
	}
}

public class SortlistOfListsDemo {
	
	// wir sortieren eine list von lists
	// 1. kriterium: dioe anzahl der elemente einer aublist
	// 2. kriterium: das groesste element in einer sublist
	public static void main(String[] args) {
		MyList<Integer> myList = new MyList<>(Arrays.asList(1, 2, 3, 4));
		List<List<Integer>> listOfLists = new ArrayList<>();
		for(List<Integer> subList : myList) {
			listOfLists.add(subList);
		}
		ListComparator<Integer> cmp = new ListComparator<>();
		Collections.sort(listOfLists, cmp);
		for(List<Integer> subList : listOfLists) {
			System.out.println(subList);
		}
	}
}
