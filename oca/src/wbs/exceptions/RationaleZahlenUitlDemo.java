package wbs.exceptions;

public class RationaleZahlenUitlDemo {

	public static void main(String[] args) {

		double x1 = RationaleZahlenUtil.string2Double("1/2");
		double x2 = RationaleZahlenUtil.string2Double("3/4");
		double x3 = RationaleZahlenUtil.string2Double("4");
		System.out.println(x1);
		System.out.println(x2);
		System.out.println(x3);
		try {
			System.out.println(RationaleZahlenUtil.string2Double("1/0"));
		} catch (ArithmeticException e) {
			System.out.println(e);
		}

		try {
			System.out.println(RationaleZahlenUtil.string2Double("1a/2b"));
		} catch (NumberFormatException e) {
			System.out.println(e);

		}
		try {
			System.out.println(RationaleZahlenUtil.string2Double("1/"));
		} catch (NumberFormatException e) {
			System.out.println(e);

		}
	}

}
