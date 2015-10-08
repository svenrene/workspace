package wbs.schleifen;

public class ForDemo1 {

	public static void main(String[] args) {

		// wir geben alle zahlen zwischen 1 und 1000 aus, in irgendwo
		// die ziffer 9 enthalten,

		int counter = 0;
		for (int zahl = 1; zahl <= 1000; zahl++) {
			if (Integer.toString(zahl).indexOf('9') >= 0) {
				System.out.printf("%d -> %s%n", zahl,
						Integer.toBinaryString(zahl));
				counter++;
			}

		}
		System.out.println("-------------------");
		System.out.println("counter: " + counter);

	}

}
