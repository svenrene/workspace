package wbs.constructors_methods_encapsulation;

class C1{
	
	/*
	 * was passiert, wenn konstruktoren einer klasse sich gegenseitig aufrufen?
	 * compilerfehler
	 */
	
	C1() {
		this(715);
	}
	
	C1(C1 c1) {
		System.out.println("C1(C1)");
	}
	
	C1(Object o) {
		System.out.println("C1(Object)");
	}
	
	C1(int n) {
	    // this();
	}
	
	void C1() { // erlaubt. schlecht...
		
	}

	C1(CharSequence cs) {
		
	}
	
	
}


public class ConstructorDemo {

	public static void main(String[] args) {
		
		Integer i = new Integer(1234);
		C1 c11 = new C1(i);
		
		C1 c12 = new C1("lalla");
		C1 c13 = new C1(new StringBuffer("gaga"));
		C1 c14 = new C1(new StringBuilder("nana"));
		// wir schreiben einen passenden konstruktor
		C1 c15 = new C1(c14);
		
		
		
	}

}
