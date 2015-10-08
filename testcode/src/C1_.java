

/*
 * was passiert, wenn eine klasse mehrere interface implementiert,
 * die dieselben konstanten definieren, aber mit unterschiedlichen werten.
 * was passiert, wenn die klasse selbst felder definiert, die gleichnamig
 * sind zu fehlern in interfaces, die die klasse selbst implementiert.
 */

interface I11{
	int n = 10;
}

interface I12{
	int n = 20;
}

interface I13{
	int m = 100;
	int k = 300;
}

public class C1_ implements I11, I12, I13{

	int n = 30;
	static int m = 200;
	
	public static void main(String[] args) {
		int n = 40;
		System.out.println(n); 			// 40
		System.out.println(new C1_().n); // 30
		System.out.println(m); 			// 200
		System.out.println(I13.m); 		// 100
		System.out.println(I11.n); 		// 10
		System.out.println(I12.n);		// 20
		System.out.println(k);			// 300
	}
	
	
}
