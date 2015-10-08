package wbs.schleifen;

public class ForDemo2 {

	public static void main(String[] args) {

		// wir geben alle zahlen zwischen 1 und 1000 aus, in denen genau
		// 7 bits auf 1 gesetzt sind, und die anzahl dieser zahlen
		
		
		int counter = 0;
		for (int zahl = 1; zahl <= 1000; zahl++) {
			if (Integer.bitCount(zahl) == 7) {
				System.out.printf("%d -> %s%n", zahl, Integer.toBinaryString(zahl));
				counter++;
			}

		}
		System.out.println("-------------------");
		System.out.println("counter: " + counter);

	}

}
