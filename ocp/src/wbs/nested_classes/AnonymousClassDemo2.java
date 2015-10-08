package wbs.nested_classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnonymousClassDemo2 {

	public static void main(String[] args) {
		// wir sortieren aufsteigend eine list von Integer nach der quersumme
		// 1234 -> 10, 23 -> 5
		// 2. sortierkriterium ist der wert der zahl

		// als comparator verwenden wie ein instanz einer anonymen klasse
		List<Integer> iList = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			iList.add(i);
		}

		Comparator<Integer> cmp = new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				int diff = querSumme(i1) - querSumme(i2);
				return diff != 0 ? diff : Integer.compare(i1, i2);
			}

			private int querSumme(int zahl) {
				int qs = 0;
				for (; zahl != 0; zahl /= 10) {
					qs += zahl % 10;
				}
				return qs;
			}

		};
		Collections.sort(iList, cmp);
		for (Integer i : iList) {
			System.out.println(i);
		}
	}

}
