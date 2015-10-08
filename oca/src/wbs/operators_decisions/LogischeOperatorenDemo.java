package wbs.operators_decisions;

class C {
	public boolean c1() {
		System.out.println("in c1() von C");
		return true;
	}

	public boolean c2() {
		System.out.println("in c2() von C");
		return false;
	}

}

public class LogischeOperatorenDemo {

	public static void main(String[] args) {

		boolean b1 = false;
		boolean b2 = true;

		C c = new C();

		// keine ausgabe
		if (b1 && c.c1()) {
			System.out.println("done");
		}

		// in c1() von c
		if (b1 & c.c1()) {
			System.out.println("done");
		}

		// in c2() von C
		if (b1 || c.c2()) {
			System.out.println("done");
		}

		// done
		if (b2 || c.c2()) {
			System.out.println("done");
		}

		// in c2() von C
		// done
		if (b2 | c.c2()) {
			System.out.println("done");
		}
		
	}

}
