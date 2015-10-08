package wbs.constructors_methods_encapsulation;

class C {
	void m() {
		MethodenAufrufDemo.m2();
	}
}

public class MethodenAufrufDemo {

	void m1() {
		m2();
		MethodenAufrufDemo.m2();
	}

	static void m2() {
		// m1(); compilerfehler
		new MethodenAufrufDemo().m1();
	}

	// statische methoden nicht über objektreferenzen aufrufen - schlechter stil

	public static void main(String[] args) {
		MethodenAufrufDemo mad = new MethodenAufrufDemo();
		mad.m1();
		mad.m2(); 	// erlaubt, aber irreführend
		m2(); 		// besser
	}

}
