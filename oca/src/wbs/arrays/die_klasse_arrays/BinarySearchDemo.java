package wbs.arrays.die_klasse_arrays;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Random;

public class BinarySearchDemo {

	public static void main(String[] args) {
		/*
		 * wir bestücken zwei int- arrays mit zufallszahlen
		 * 
		 * das erste der beiden arrays sortieren wir
		 * 
		 * wir ermitteln, wieviele zahlen aus dem 2. array nicht im ersten array
		 * vorkommen
		 * 
		 * wir stellen sicher, das keines der beiden arrays duplikate enthält
		 */
		int[] ia1 = new int[20];
		int[] ia2 = new int[10];
		Random rnd = new Random();
		BitSet bs = new BitSet();
		int zahl;
		int i = 0;
		int counter = 0;

		while (bs.cardinality() < 20) {
			zahl = rnd.nextInt(50) + 1;
			if (!bs.get(zahl)) {
				bs.set(zahl);
				ia1[i] = zahl;
				i++;
			}
		}

		bs.clear();
		i = 0;
		while (bs.cardinality() < 10) {
			zahl = rnd.nextInt(50) + 1;
			if (!bs.get(zahl)) {
				bs.set(zahl);
				ia2[i] = zahl;
				i++;
			}
		}

		Arrays.sort(ia1);
		System.out.println(Arrays.toString(ia1));
		System.out.println(Arrays.toString(ia2));
		for (i = 0; i < ia2.length; i++) {
			if (Arrays.binarySearch(ia1, ia2[i]) < 0) {
				counter++;
			}
		}
		System.out.println(counter); // s e h r umständlich...
	}

}
