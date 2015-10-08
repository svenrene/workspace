

class Base {
	int ibase = 5;
	void m() {
		System.out.println("in m() von Base");
	}
}

class Sub_1 extends Base {
	int ibase = 101;
	@Override
	void m() {
		System.out.println("in m() von Sub_1");
	}
}

class Sub_2 extends Base {
	int ibase = 10;
	@Override
	void m() {
		System.out.println("in m() von Sub_2");
	}
}

public class PolymorphismusDemo {
	public static void main(String[] args) {
		Base b = Math.random() < 0.5 ? new Sub_1() : new Sub_2();
		b.m();
		System.out.println(b.ibase);
		Base A = new Base();
		A.m();
		System.out.println(A.ibase);
		
	}
}