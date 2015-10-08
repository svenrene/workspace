package wbs.operators_decisions;

public class DiverseOperatorenDemo {
	public static void main(String[] args) {
		int n1 = 3;
		System.out.println(n1++); // 3
		System.out.println(++n1); // 5
		
		// bitweises xor
		// 0101
		// 0101
		System.out.println(n1 ^ n1); // 0
		
		int n2 = 5;
		// ein left-shift um n stellen entspricht einer multiplikation mit 2 hoch n
		// 00000000000000000000000000000101		   vor dem left-shift um 4 stellen
		// 00000000000000000000000001010000        nach dem left-shift um 4 stellen
		// von rechts gesehen: 64 32 16 8 4 2 1
		System.out.println(n2 <<= 4); // 80
		
		// bei negativen zahlen ist das vorzeichenbit immer 1
		// das vorzeichenbit ist das bit an der höchsten bitposition
		// 10000000000000000000000000000000
		System.out.println(1 << 31); // -2147483648
		
		// wir invertieren alle bits der zahl 0
		// 11111111111111111111111111111111
		System.out.println(~0); // -1
		
		// bei einem right-shift mit >>> wird links immer mit 0 aufgefüllt
		// 01111111111111111111111111111111
		System.out.println(~0 >>> 1); // 2147483647
		
		// bie einem right-shift´mit >> bleibt ein eventuelles vorzeichenbit erhalten
		System.out.println(~0 >> 1); // -1
		System.out.println(~0 >> 2); // -1
		
		String s = (n2 == 5) ? "gleich" : "ungleich";
		System.out.println(s); // ungleich
		boolean b1 = false;
		System.out.println(b1 == true); // false
		System.out.println(b1 = true); // true
		boolean b21 = true;
		boolean b22 = false;
		System.out.println(b21 || (b22 = true)); // true
		System.out.println(b22); // false
		boolean b31 = true;
		boolean b32 = false;
		System.out.println(b31 | (b32 = true)); // true
		System.out.println(b32); // true
	}
}
