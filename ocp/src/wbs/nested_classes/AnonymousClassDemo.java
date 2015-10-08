package wbs.nested_classes;

class C1 {
	public void m() {
		System.out.println("m() von C1");
	}
}

abstract class C2 {
	public abstract void m();
}

interface I {
	public abstract void m();
}

class C3 {
	C3(int n) {

	}

	public void m() {
		System.out.println("m() von C3");
	}
}

// anonyme klasse dürfen auf parameter und lokale variablen des umgebenden
// blocks nur zugreifen, wenn sie als final deklariert werden

public class AnonymousClassDemo {

	public static void main(String[] args) {
		int notFinalInt = 3;
		final int finalInt = 3;
		
		C1 c1 = new C1() {

			@Override
			public void m() {
				System.out.println("m() von anonymous subclass von C1");
				// System.out.println(notFinalInt);
				System.out.println(finalInt);
			}

		};
		System.out.println(c1.getClass().getName());
		c1.m();
		
		C2 c2 = new C2() {

			@Override
			public void m() {
				System.out.println("m() von anonymous subclass von C2");
			}

		};
		System.out.println(c2.getClass().getName());
		c2.m();
		
		C3 c3 = new C3(100) {

			@Override
			public void m() {
				System.out.println("m() von anonymous subclass von C3");
			}

		};
		System.out.println(c3.getClass().getName());
		c3.m();
		
		I i = new I() {

			@Override
			public void m() {
				System.out.println("m() von anonymous I- implementierung class");
			}

		};
		System.out.println(i.getClass().getName());
		i.m();
		
	}

}
