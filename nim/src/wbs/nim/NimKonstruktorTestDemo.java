package wbs.nim;

public class NimKonstruktorTestDemo {

	public static void main(String[] args) {
		Nim nim1 = new Nim();
		Nim nim2 = new Nim(12, 50);
		Nim nim3 = new Nim(new int[] { 1, 2, 3, 4, 5, 6, 7 });
		System.out.println(nim1);
		System.out.println(nim2);
		System.out.println(nim3);

		try {
			Nim nim4 = new Nim(new int[] { 1, 2, 0, 4, 5, 6, 7 });
			System.out.println(nim4);
		} catch (NimException e) {
			System.out.println(e);
		}

		int[] ia = { 1, 2, 3, 4, 5 };
		Nim nim5 = new Nim(ia);
		System.out.println(nim5);
		ia[0] = -33;
		System.out.println(nim5);
	}
}
