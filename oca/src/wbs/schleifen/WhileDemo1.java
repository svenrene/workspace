package wbs.schleifen;

public class WhileDemo1 {

	public static void main(String[] args) {

		// wir geben alle zahlen zwischen 1 und 1000 aus, in irgendwo
		// die ziffer 9 enthalten,
		
		
		int zahl = 1;
		int counter = 0;
		while (zahl <= 1000) {
			if (Integer.toString(zahl).indexOf('9') >= 0) {
				System.out.printf("%d -> %s%n", zahl, Integer.toBinaryString(zahl));
				counter++;
			}
			zahl++;
		}
		System.out.println("-------------------");
		System.out.println("counter: " + counter);

	}

}
