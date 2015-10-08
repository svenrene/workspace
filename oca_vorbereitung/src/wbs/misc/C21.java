package wbs.misc;

class C21 {
	public int m = 21;

	public void m() {
		System.out.println("m() von C21");
	}

	public void m2() {
		System.out.println("m2() von C21");
	}
}

class C22 extends C21 {
	public int m = 22;

	public void m() {
		System.out.println("m() von C22");
	}

	@Override
	public void m2() {
		System.out.println("m2() von C22");
		super.m2();
	}

	@Override
	public String toString() {
		return "m: " + m + "\n" + "super.m: " + super.m;
	}
}