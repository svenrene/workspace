package wbs.intro;

public class IntegerDemo {

	public static void main(String[] args) {

		// wir geben aus:

		// den groessten möglichen int-wert

		System.out.println(Integer.MAX_VALUE);

		// den kleinsten möglichen int-wert

		System.out.println(Integer.MIN_VALUE);

		// die zahl 100 als dualzahl

		System.out.println(Integer.toBinaryString(100));

		// die zahl 100 als hexadezimalzahl

		System.out.println(Integer.toHexString(100));

		// die zahl 100 als oktalzahl

		System.out.println(Integer.toOctalString(100));

		// welche dezimalzahl entspricht der dualzahl 100010001000 ?
		System.out.println(Integer.parseInt("100010001000", 2));

		// welche dezimalzahl entspricht der oktalzahl 1234567 ?

		System.out.println(Integer.parseInt("1234567", 8));

		// welche dezimalzahl entspricht der hexadezimal ABCDEF ?

		System.out.println(Integer.parseInt("ABCDEF", 16));

		// wie viele einserbits enthält die duale darstellung der zahl 12345 ?

		System.out.println(Integer.bitCount(12345));

		// welchen stellenwert hat das höchste einserbit der zahl 1234567890 ?

		System.out.println(Integer.highestOneBit(1234567890));
		
		
		System.out.println(Integer.parseInt("221", 9));
		// 1 * 9 hoch 0 + 2 * 9 hoch 1 + 2 *9 hoch 2
		
		// radix: die basis des stellenwertsystems
	}

}
