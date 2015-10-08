package wbs.generics_uebungen_1;

class A91 {
}

interface I91 {
}

class A92 extends A91 implements I91 {
}

public class A9<T extends A91 & I91> {
	public static void main(String[] args) {
		A9<A92> a9 = new A9<>();
		System.out.println(a9);
	}
}