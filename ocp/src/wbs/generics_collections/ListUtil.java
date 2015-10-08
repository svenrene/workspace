package wbs.generics_collections;

import java.util.Comparator;
import java.util.List;

public class ListUtil {
	public static <T> void copy(List<? extends T> from, List<? super T> to) {
		to.clear();
		for (T t : from) {
			to.add(t);
		}
	}
	
	// wir schreiben die methode max() mit 2 überladungen. beide versionen
	// liefern das groesste element einer list
	
	// die 1. variante setzt ein natural ordering der list-elemente voraus
	// die 2. variante verwendet einen comparator
	public static <T extends Comparable<? super T>> T max(List<? extends T> list) {
		T max = list.get(0);
		for(T t : list) {
			if(t.compareTo(max) > 0) {
				max = t;
			}
		}
		return max;
	}
	
	public static <T> T max (List<? extends T> list, Comparator<? super T> cmp) {
		T max = list.get(0);
		for(T t : list) {
			if(cmp.compare(t, max) > 0) {
				max = t;
			}
		}
		return max;
	}
	
	public static <T> Comparator<T> reverseOrder() {
		return new Comparator<T>() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public int compare(T t1, T t2) {
				Comparable o = (Comparable) t2;
				return o.compareTo(t1);
			}
		};
	}
}