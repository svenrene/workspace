package wbs.schleifen;

public class WhileDemo2 {

	public static void main(String[] args) {

		// wir geben alle zahlen zwischen 1 und 1000 aus, in denen genau
		// 7 bits auf 1 gesetzt sind, und die anzahl dieser zahlen
		
		
		int zahl = 1;
		int counter = 0;
		while (zahl <= 1000) {
			if (Integer.bitCount(zahl) == 7) {
				System.out.printf("%d -> %s%n", zahl, Integer.toBinaryString(zahl));
				counter++;
			}
			zahl++;
		}
		System.out.println("-------------------");
		System.out.println("counter: " + counter);

	}

}
