class C31 {
	 static int m = 31;
}

public class C3 extends C31 {
	 int m = 3;

	public static void main(String[] args) {
		int m = 100;
		System.out.println(m);
		System.out.println(new C31().m);
		System.out.println(((C31) new C3()).m);
		System.out.println((new C3()).m);
	}
}