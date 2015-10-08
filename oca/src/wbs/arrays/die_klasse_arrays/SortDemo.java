package wbs.arrays.die_klasse_arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class SortDemo {

	public static void main(String[] args) {

		/*
		 * wir bestücken ein string-array mit einigen strings, sortieren es, und
		 * geben es aus.
		 * 
		 * wir bestücken ein stringbuffer-array mit enigen stringbuffern,
		 * sortieren es, und geben es aus.
		 */

		String[] sa = { "eins", "zwei", "drei" };
		Arrays.sort(sa);
		System.out.println(Arrays.toString(sa));

		StringBuffer[] sba = { new StringBuffer("eins"),
				new StringBuffer("zwei"), new StringBuffer("drei") };
		Comparator<StringBuffer> cmp = new StringBufferComparator();
		Arrays.sort(sba, cmp);
		System.out.println(Arrays.toString(sba));

		// wir bestücken ein Integer- Array mit den Zahlen von 1 bis 1000.
		// wir sortieren das array.
		// 1. sortierkriterium: aufsteigend nach anzahl der einserbits
		// 2. sortierkriterium: aufsteigend nach wert

		// 1,2,4,8,16,64,128,256,512,3,5,6,9,...,768,7,11,13,...,896,15,23,27,...,...
		Integer[] ia = new Integer[1000];
		for (int i = 1; i <= 1000; i++) {
			ia[i - 1] = i;

		}
		Comparator<Integer> cmp2 = new IntegerComparator();
		Arrays.sort(ia, cmp2);
		for (Integer i : ia) {
			System.out.println(i);
		}

		// wir sortieren das Integer-array nochmals, und zwar nach folgende
		// kriterien:
		// 1. sortiertkriterium: anzahl der verschiedene ziffern
		// 2. sortierkriterium: aufsteigend nach wert
		
		Arrays.sort(ia, new DiffDigitComparator());
		for (Integer i : ia) {
			System.out.println(i);
		}

		
		// wir bestücken ein 50-elementiges Integer-Array mit zufallszahlen zwischen 1 und 100
		// aus diesem array wählen wir irgendeine zahl aus (z1)
		// dann sortieren wir das array. eine zahl soll dabei umso kleiner sein.
		// je geringer ihr abstand zu z1 ist
		
		Integer[] ia_random = new Integer [50];
		Random rand = new Random();
		
		for(Integer i=0;i<ia_random.length; i++){

			ia_random[i] = rand.nextInt(100)+1;
			
		}
		
		int z1 = ia_random[rand.nextInt(ia_random.length)];
		
		System.out.println("--------------------------------");
		System.out.println("Zufallszahl : " + z1);
		System.out.println("unsortiert: " + Arrays.toString(ia_random));
		Arrays.sort(ia_random, new RandomDiffComparator(z1));
		System.out.println("sortiert: " + Arrays.toString(ia_random));
		}

}


