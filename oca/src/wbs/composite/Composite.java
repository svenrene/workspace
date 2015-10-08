package wbs.composite;

class A {
	public void a() {
		System.out.println("a() von A");
	}
}

class ASub extends A {
	public void a() {
		System.out.println("a() von ASub");
	}
}

class B {
	public void b() {
	}
}

class C {
	public void c() {
	}
}

interface I {
	public void i();
}

class CI1 implements I {

	@Override
	public void i() {
		System.out.println("i() von CI1");

	}

}

class CI2 implements I {

	@Override
	public void i() {
		System.out.println("i() von CI2");

	}

}

public class Composite implements I {
	private A a;
	private B b;
	private C c;

	private I i;

	public Composite(A a) {
		this.a = a;
	}

	// delegation
	public void a() {
		a.a();
	}

	// delegation
	public void b() {
		b.b();
	}

	// delegation
	public void c() {
		c.c();
	}

	public void setA(A a) {
		this.a = a;
	}

	public void setI(I i) {
		this.i = i;
	}

	@Override
	public void i() {
		i.i();
		
	}

}
