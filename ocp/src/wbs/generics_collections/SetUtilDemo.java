package wbs.generics_collections;

import java.util.HashSet;
import java.util.Set;

public class SetUtilDemo {

	public static void main(String[] args) {
		/*
		 * aus einem set mit integern filtern wir alle durch 3 teilbaren zahlen
		 * aus (unter verwendung von select() aus SetUtil)
		 */
		Set<Integer> zahlen = new HashSet<>();
		zahlen.add(3);
		zahlen.add(4);
		zahlen.add(5);
		zahlen.add(6);

		Filter<Integer> filter = new Filter<Integer>() {

			@Override
			public boolean accepts(Integer i) {
				return i % 3 == 0;
			}

		};
		
		Set<Integer> durchDreiTeilbar = SetUtil.select(zahlen, filter);
		for(Integer zahl : durchDreiTeilbar) {
			System.out.println(zahl);
		}
	}

}
