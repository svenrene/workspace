class Z1 {
	 static int i1 = 5;
	 int i2 = 5;
	Z1() {};
	void Z1() {
		System.out.println("Methode von Z1() von Z1");
	}
}

class Z2 extends Z1 {
	static int i1 = 10;
	int i2 = 10;

	Z2() {};

//	 void Z1() {
//		System.out.println("Methode von Z1() von Z2");
//	}
	static void Z2() {
		System.out.println("Methode von Z2() von Z2");
	}
}

public class Vererbung {

	 public static void main(String[] args) {

		Z1 z1 = new Z1();
		Z2 z2 = new Z2();
		System.out.println(z1.i1);
		System.out.println(z1.i2);
		// z1.Z1();
		z1.Z1();
		z2.Z1();
		((Z1)z1).Z1();
	}

}
