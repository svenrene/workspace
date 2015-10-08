package wbs.arrays.arraylist;

import java.util.Arrays;

import wbs.schleifen.NumberUtil;

// retoranalyse is fun...

public class MoreSortDemo {

	public static void main(String[] args) {

		Integer[] ia = new Integer[100];

		for (int i = 1; i <= 100; i++) {
			ia[i - 1] = i;
		}

		// sortiert aufsteigend nach der anzahl der primfaktoren
		// und bei gleicher anzahl von primfaktoren aufsteigend nach wert

		CountPrimfaktorenComparator cmp = new CountPrimfaktorenComparator();

		Arrays.sort(ia, cmp);
		for (Integer zahl : ia) {
			System.out.println(zahl + " -> " + NumberUtil.primfaktoren(zahl));
		}

	}

}
