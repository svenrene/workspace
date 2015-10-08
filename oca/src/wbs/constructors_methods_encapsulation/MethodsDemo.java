package wbs.constructors_methods_encapsulation;

public class MethodsDemo {

	public static void m1(int n) {
		n++; // übergabe per wert, primitive zahl
	}

	public static void m2(StringBuffer sb) {
		sb.append("abc"); // übergabe per referenz
	}

	public static void m3(StringBuffer sb) {
		sb = new StringBuffer("12345"); 
	}

	public static void m4(Integer i) {
		i++; // Wrapper-instanzen sind iummutable!
	}
	
	public static void m5(String s) {
		s += "xyz"; // Strings sind iummutable!
	}
	
	public static void m6(StringBuffer sb) {
		sb.reverse();
	}
	
	
	public static void main(String[] args) {

		int zahl = 10;
		m1(zahl);
		System.out.println(zahl); // 10

		StringBuffer sb = new StringBuffer("xyz");
		m2(sb);
		System.out.println(sb); // xyzabc

		m3(sb);
		System.out.println(sb); // xyzabc

		Integer zahl2 = 12345;
		m4(zahl2);
		System.out.println(zahl2); // 12345
		
		String s = "abc";
		m5(s);
		System.out.println(s);
		
		m6(sb);
		System.out.println(sb); //
	}

}
