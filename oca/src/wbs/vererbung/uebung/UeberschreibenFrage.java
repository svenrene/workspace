package wbs.vererbung.uebung;

/* was passiert, wenn im konstruktor einer basisklasse eine methode
 * aufgerufen wird, die in der subklasse überschrieben wird, und die subklasse
 * instanziert wird
 */

class Base3 {
	int n;
	void m() {
		System.out.println("m() von Base3");
		System.out.println(n);
	}
	Base3() {
		// im allgemeinen keine gute idee, im konstruktor einer basisklasse
		// eine methode aufzurufen, die in einer subklasse überschrieben wird
		m();
	}
}

class Sub3 extends Base3 {
	Sub3() {
		n = 1;
		m();
	}
	@Override
	void m() {
		System.out.println("m() von Sub3");
		System.out.println(n);
	}
}

public class UeberschreibenFrage {
	public static void main(String[] args) {
		Sub3 sub3 = new Sub3();
	}
}
