package wbs.vererbung.uebung;

/*
 * was passiert, wenn eine statische methode in einer subklasse überschrieben 
 * wird, und die statische methode über eine referenzvariable aufgerufen wird
 * (und object-type und reference-type nicht übereinstimmen)
 */

class B2 {
	static void m() {
		System.out.println("m() von B2");
	}
}

class B2Sub extends B2 {
	// @ Override geht hier nicht...
	static void m() {
		System.out.println("m() von B2Sub");
	}
}


public class StaticMethodFrage {

	public static void main(String[] args) {
		B2 b2 = new B2Sub();
		b2.m();      // m() von B2				

	}

}
