package wbs.misc;

class MySuper {
	public MySuper(int i) {
	}
}

abstract class MySub extends MySuper {
	public MySub(int i) {
		super(i);
	}

	public abstract void m1();
}

class MyTest {

	public static void main(String[] args) {
		MySub ms = new MySub() {
			public void m1() {
				System.out.println("In MySub.m1()");
			}
		};
		ms.m1();

	}

}
