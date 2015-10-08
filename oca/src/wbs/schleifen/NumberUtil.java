package wbs.schleifen;

import java.util.ArrayList;
import java.util.List;

public class NumberUtil {

	private NumberUtil() {

	}

	/*
	 * wir schreiben eine methode, die testet, ob eine zahl perfekt ist.
	 * 
	 * eine zahl ist perfekt, wenn sie gleich der summe ihrer echten teiler ist
	 * 
	 * bsp.: 6 = 1 + 2 + 3
	 * 
	 * bsp.: 28 = 1 + 2 + 4 + 7 + 14
	 * 
	 * bsp.: 8 != 1 + 2 + 4
	 * 
	 * methodenname: isPerfekt()
	 */

	public static boolean isPerfect(int zahl) {

		int teilerSumme = 0;
		for (int teiler = 1; teiler <= zahl / 2; teiler++) {
			if (zahl % teiler == 0) {
				teilerSumme += teiler;
			}
		}

		return teilerSumme == zahl;

	}

	/*
	 * man nimmt eine zahl man multipliziert mit 3 und addiert 1, wenn die zahl
	 * ungerade ist. man dividiert durch 2, wenn die zahl gerade ist. das macht
	 * man so lange, bis der endwert 1 erreicht ist.
	 * 
	 * 10: 5 16 8 4 2 1 11: 34 17 52 26 13 40 20 10 5 16 8 4 2 1
	 * 
	 * wir schreiben die methode collatz(), die für eine gegebene zahl
	 * ermittelt, nach wie vielen iterationen der endwert 1 erreicht ist
	 */

	public static int collatz(int zahl) {

		int count = 0;
		while (zahl != 1) {

			if (zahl % 2 != 0) {
				zahl *= 3;
				zahl++;
			} else {
				zahl /= 2;
			}
			count++;
		}

		return count;
	}

	// wir schreiben die methode querSummer(). sie berechnet die quersumme

	// bsp.: 81 -> 9
	// bsp.: 12345 -> 15
	// bsp.: 231 -> 6

	// public static int querSumme(int zahl) {
	//
	// int qs = 0;
	// for (; zahl != 0; zahl /= 10) {
	// qs += zahl % 10;
	// }
	//
	// return qs;
	// }

	public static int querSumme(int zahl) {

		int quersumme = 0;

		while (zahl > 0) {
			quersumme += zahl % 10;
			zahl = zahl / 10;
		}

		return quersumme;
	}

	public static List<Integer> primfaktoren(Integer zahl) {
		List<Integer> al = new ArrayList<>();
		for (int i = 2; zahl != 1; i++) {
			while (zahl % i == 0) {
				zahl = zahl / i;
				al.add(i);
			}
		}
		return al;
	}

}
