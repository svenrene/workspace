package wbs.arrays;

public class ArraysDemo1 {

	public static void main(String[] args) {
		/*
		 * wir bestücken ein int-array mit den ersten 10 quadratzahlen
		 * (1,4,9,...,100) und geben es aus
		 * 
		 * 1. variante: initialisierungsliste und foreach- schleife
		 * 
		 * 2. variante: bestückung und ausgabe der array mit for- schleife
		 */

		// 1. variante
		int[] ia1 = { 1, 4, 9, 16, 25, 36, 49, 64, 81, 100 };

		for (int zahl : ia1) {
			System.out.println(zahl);

		}
		System.out.println("--------------");
		// 2. variante
		int[] ia2 = new int[10];
		for (int i = 0; i < 10; i++) {
			ia2[i] = (i + 1) * (i + 1);
		}
		for (int i = 0; i < ia2.length; i++) {
			System.out.println(ia2[i]);
		}

	}

}