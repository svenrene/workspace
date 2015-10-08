package wbs.arrays;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class IntArraysUtil {

	private IntArraysUtil() {

	}

	// wir schreiben die methode min(). sie findet in einem int-array
	// das kleinste element.

	public static int min(int[] ia) {
		int min = ia[0];
		for (int zahl : ia) {
			if (zahl < min) {
				min = zahl;
			}
		}
		return min;
	}

	public static int max(int[] ia) {
		int max = ia[0];
		for (int zahl : ia) {
			if (zahl > max) {
				max = zahl;
			}
		}
		return max;
	}

	// wir schreiben die methode hasDups(). sie prüft, ob in einem array von inz
	// mehrmals derselbe wert vorkommt

	public static boolean hasDups(int[] ia) {

		Set<Integer> zahlen = new HashSet<>();
		for (int zahl : ia) {
			if (!zahlen.add(zahl)) {
				break;
			}
		}
		return zahlen.size() != ia.length;

	}

	// wir schreiben dei methode toString(). sie liefert zu einem int-array
	// eine brauchbare String-repräsentation, ähnlich der toString- methode der
	// klasse Arrays
	// [wert1, wert2, ... , wertn]

	public static String toString(int[] ia) {
		StringBuffer sb = new StringBuffer("[");
		for (int i = 0; i < ia.length; i++) {
			sb.append(ia[i]);
			if (i < ia.length - 1) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();

	}

	// wir schreiben die methode fibonacci(); sie liefert die ersten n
	// fibonacci-zahlen.
	// bildungsgesetz:
	// 1. zahl: 1
	// 2. zahl: 2
	// jede folgende zahl ist die summe der beiden vorhergehenden zahlen
	// bsp: 1,2,3,5,8,13,21,34,55,...

	// wir fordern, dass n mindestens den wert 1 haben muss, und werfen ggf eine
	// exception
	public static int[] fibonacci(int n) {

		if (n < 1) {
			throw new IllegalArgumentException("n muss >=1 sein");
		}

		int[] ia = new int[n];

		ia[0] = 1;
		if (n > 1) {
			ia[1] = 1;

			for (int i = 2; i < n; i++) {

				ia[i] = ia[i - 2] + ia[i - 1];

			}
		}
		// rückgabe des fibonacci-arrays
		return ia;
	}

	/*
	 * zu allen elementen eines int- array soll ein konstanter wert addiert
	 * werden
	 * 
	 * jedes element eines arrays soll mit einem konstanten wert multipliziert
	 * werden
	 * 
	 * alle elemente eines arrays sollen mit sich selbst multipliziert werden
	 * 
	 * methodenname: operateOnIntArray()
	 */

	public static int[] operateOnIntArray(int[] ia, String operator, int operand) {

		for (int i = 0; i < ia.length; i++) {
			if (operator == "+") {
				ia[i] = ia[i] + operand;
			} else if (operator == "*") {
				ia[i] = ia[i] * operand;
			} else {
				ia[i] += ia[i];
			}
		}

		return ia;
	}

	public static void operateOnIntArray(int[] ia, IntFunction function) {
		for (int i = 0; i < ia.length; i++) {
			ia[i] = function.f(ia[i]);
		}
	}

	// ein stack funktioniert nach dem lifo- prinzip: last in, first out
	// (bild: tellerwäscher in den weniger guten alten zeiten:
	// der teller, der als letzter auf dem tellerstapel landet, wird als erster
	// gespült)
	// auf unserem stack sind allerdings keine teller, sondern funktionen von
	// int nach int
	public static void operateOnIntArray(int[] ia, Stack<IntFunction> functions) {
		IntFunction function;
		// iteriere über alle funktionen
		while (!functions.empty()) {
			// hole die nächste funktion vom stack
			function = functions.pop();
			// wende die aktuelle funktion auf alle array-elemente an
			for (int i = 0; i < ia.length; i++) {
				ia[i] = function.f(ia[i]);
			}
		}
	}
}
