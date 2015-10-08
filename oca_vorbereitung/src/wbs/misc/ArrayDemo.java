package wbs.misc;

public class ArrayDemo {


	int[] ia1;
	int[] ia2 = new int[10];
	String[] sa1;
	String[] sa2 = {};
	String[] sa3 = new String[10];
	
	void m1() {
		
		int[] ia3;
		int[] ia4 = new int[10];		

		System.out.println(ia1.length);		// NullPointerException
		System.out.println(ia2.length); 	// 10
	//	System.out.println(ia3.length); 	// Compilerfehler
		System.out.println(ia4.length); 	// 10
		
		System.out.println(ia1[0]);			// NullPointerException
		System.out.println(ia1[10]);		// ArrayIndexOutOfBoundsException
		
		System.out.println(sa1.length);			// NullPointerException
		System.out.println(sa2[0].charAt(0));	// ArrayIndexOutOfBoundsException
		System.out.println(sa3[0].length());	// NullPointerException
		System.out.println(sa3[0]);				// null
		
		System.out.println(ia4[4]);				// 0
		// System.out.println(ia4[4].length());	// Compilerfehler

	}
	
	
}
