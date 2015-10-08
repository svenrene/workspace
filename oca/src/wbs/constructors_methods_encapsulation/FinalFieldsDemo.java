package wbs.constructors_methods_encapsulation;

// die verwendung von final kann dioe selbstdokumentation erheblich verbessern
// auch parameter von methoden oder konstruktoren können als final deklariert werden
// final kann dem compiler ermöglichen, effizienteren code zu generieren
// final ist ebenfalls nützlich mit blick auf multithreading

// im kontext von nested classes sind viele konstruktionen nur möglich mit geeigneten
// final- deklarationen

public class FinalFieldsDemo {

	int f1;

	final int f2 = 2;

	final int f3;

	static final int f4;

	static final int f5 = 5;

	// die initialisierung von static fields kann sofort erfolgen,
	// oder spätestens in einem statischen initialisierer
	static {
		f4 = 4;
	}

	public FinalFieldsDemo() {
		f3 = 3; // ok
	}

	public FinalFieldsDemo(int f3) {
		this.f3 = 3; // ok
	}

	int getF3() {
		return f3;
	}

	// void setF3(int f3) {
	// this.f3 = f3;
	// }

	void m(final int n) {
		// n = 3;
		
	}

	void m2(final StringBuffer sb) {
		// sb = new StringBuffer("abc");
		sb.append("blabla");
	}
	
}
