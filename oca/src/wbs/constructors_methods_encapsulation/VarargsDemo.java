package wbs.constructors_methods_encapsulation;

public class VarargsDemo {

	/*
	 * wir schreiben die methode diffMinMax(); sie wird mit beliebig vielen
	 * argumenten vom typ int aufgerufen, und liefert die differenz zwischen dem groessten und
	 * dem kleinsten wert
	 */
	
	public static int diffMinMax(int zahl, int... zahlen) {
		int min = zahl;
		int max = zahl;
		for(int n : zahlen){
			if(n < min) {
				min = n;
			}
			if(n > max) {
				max = n;
			}
		}
		return max - min;
	}

// unter signatur einer methode versteht man anzahl / typ / reihenfolge der parameter
// gleichnamige methoden müssen verschiedene signaturen haben

// es ist nicht erlaubt, mehrere methoden mit demselben namen und derselben signatur
// zu schreiben, die sich nur im return-typ unterscheiden
	
//	public static int m1(int... ia) {
//		return 0;
//	}
//
//	public static int m1(int[] ia) {
//		return 0;
//	}
	
	public static void main(String[] args) {

		int[] ia = {3,1,7,16,44,9};
		
		int diff1 = diffMinMax(10, ia);
		int diff2 = diffMinMax(10, 3, 1, 7, 16, 44, 9);
		int diff3 = diffMinMax(10, new int[] {3, 1, 7, 16, 44, 9});
		int diff4 = diffMinMax(10);

		System.out.println(diff1);
		System.out.println(diff2);
		System.out.println(diff3);
		System.out.println(diff4);
		
	}

}
