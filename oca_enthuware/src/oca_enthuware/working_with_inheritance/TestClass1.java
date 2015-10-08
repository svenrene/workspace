package oca_enthuware.working_with_inheritance;

interface Flyer {
}

class Bird implements Flyer {
}

class Eagle extends Bird {
}

class Bat {
}

public class TestClass1 {

	public static void main(String[] args) {
		Flyer f = new Eagle();
		Eagle e = new Eagle();
		Bat b = new Bat();

		if (f instanceof Flyer)
			System.out.println("f is a Flyer");
		if (e instanceof Bird)
			System.out.println("e is a Bird");
		if (b instanceof Flyer)
			System.out.println("b is a Bird");
	}
}