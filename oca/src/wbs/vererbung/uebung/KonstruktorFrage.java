package wbs.vererbung.uebung;

@SuppressWarnings("serial")
class E11 extends Exception {
}

@SuppressWarnings("serial")
class E12 extends E11 {
}

class B1 {
	B1() throws E11 {
		
	}
}

class B1sub extends B1 {
	B1sub() throws E11 {
		super();		// optional
	}
}

public class KonstruktorFrage {

	/*
	 * ist es möglich, dass der konstruktor einer abgeleiteten klasse
	 * eine allgemeinere exception deklariert als der konstruktor der
	 * basisklasse?
	 * konstruktoren dürfen mit bezug auf exception kontravariant sein
	 * im unterschied zu methoden, die kovariant sein müssen
	 */
	public static void main(String[] args) {

		

	}

}
