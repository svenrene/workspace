package wbs.basic_data_types;

public class DoubleDemo {

	public static void main(String[] args) {

		/*
		 * wir untersuchen, was beim datentyp double bei division durch 0
		 * passiert, und beim ausführen einer funktion, die für reelle zahlen
		 * und den gegebenen wert kein korrektes ergebnis liefern kann
		 */

		double x1 = 1.0;
		double x2 = -1.0;

		double erg1 = x1 / 0;
		double erg2 = x2 / 0;
		double erg3 = Math.sqrt(x2);

		System.out.println(erg1); // Infinity
		System.out.println(erg2); // -Infinity

		System.out.println(Double.isInfinite(erg1)); // true
		System.out.println(Double.isInfinite(erg2)); // true

		System.out.println(erg3); // NaN
		System.out.println(Double.isNaN(erg3)); // true

	}

}
