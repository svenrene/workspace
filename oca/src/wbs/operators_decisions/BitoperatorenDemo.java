package wbs.operators_decisions;


// 10000000000000000000000000000000
// 01000000000000000000000000000000
// 00100000000000000000000000000000
// ...
// 00000000000000000000000000000001
// 00000000000000000000000000000000
public class BitoperatorenDemo {

	public static String toBinaryString(int zahl) {
		StringBuffer sb = new StringBuffer(32);
		for (int n = (1 << 31); n != 0; n >>>= 1) {
			sb.append((zahl & n) != 0 ? 1 : 0);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		int n1 = 10;
		int n2 = 29;
		int n3 = -1;
		System.out.println(toBinaryString(n1));
		System.out.println(toBinaryString(n2));
		System.out.println(toBinaryString(n1 & n2) + " & ");
		System.out.println();
		System.out.println(toBinaryString(n1));
		System.out.println(toBinaryString(n2));
		System.out.println(toBinaryString(n1 | n2) + " | ");
		System.out.println();
		System.out.println(toBinaryString(n1));
		System.out.println(toBinaryString(n2));
		System.out.println(toBinaryString(n1 ^ n2) + " ^ ");
		System.out.println();
		System.out.println(toBinaryString(n1 << 3) + " << ");
		System.out.println();
		
		System.out.println(toBinaryString(-100) + " Wert -100 "); // 11111111111111111111111110011100
		System.out.println();
		System.out.println(toBinaryString(-100 << 3) + " << bei Wert -100 "); // 11111111111111111111110011100000
		System.out.println();
		
		System.out.println(toBinaryString(-100) + " Wert -100 "); // 11111111111111111111111110011100
		System.out.println();
		System.out.println(toBinaryString(-100 >>> 2) + " >>> bei Wert -100 "); // 00111111111111111111111111100111
		System.out.println();
		
		System.out.println(toBinaryString(n3 >> 1) + " >> ");
		System.out.println();
		System.out.println(toBinaryString(n3 >>> 1) + " >>> ");
		System.out.println();
		
		// interne darstellung von Positiven und negativen ganzen Zahlen
		System.out.println("-------------------");
		int zahl1 = 10;
		System.out.println(toBinaryString(zahl1));
		int zahl2 = -10;
		System.out.println(toBinaryString(zahl2));
		
		// wie kommt man über bitoperationen von einer positiven zahl
		// zu ihrer negative zahl (zweier-komplement)
		
		// zahl invertiert alle bits und addiert 1
		zahl1 = ~zahl1;
		zahl1++;
		System.out.println(toBinaryString(zahl1));
		
		// right-shift mit vorzeichen
		System.out.println("-----------------");
		System.out.println(toBinaryString(zahl2));
		System.out.println(toBinaryString(zahl2 >> 1));
		System.out.println(toBinaryString(zahl2 >>> 1));
		
		System.out.println(toBinaryString(2147483647)); // int maximaler wert positiv
		System.out.println(toBinaryString(-2147483648)); // int maximaler wert negativ
		
		System.out.println(toBinaryString(~1));
	}
}