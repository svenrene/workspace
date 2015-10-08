package wbs.exceptions;

public class FinallyDemo1 {

	@SuppressWarnings("finally")
	public static int m1(String s) {
		try {
			return Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return 10;
		} finally {
			return 20;
		}
	}

	public static void main(String[] args) {
		int zahl = m1("gaga");
		System.out.println(zahl); // 20
		zahl = m1("123");
		System.out.println(zahl); // 20
	}

}
