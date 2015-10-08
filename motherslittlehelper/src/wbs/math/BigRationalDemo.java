package wbs.math;

public class BigRationalDemo {

	public static void main(String[] args) {

		BigRational b11 = new BigRational("2/3");
		BigRational b12 = new BigRational("3/4");

		System.out.println(b11 + " + " + b12 + " = " + b11.add(b12));
		System.out.println(b11 + " - " + b12 + " = " + b11.subtract(b12));
		System.out.println(b11 + " * " + b12 + " = " + b11.multiply(b12));
		System.out.println(b11 + " / " + b12 + " = " + b11.divide(b12));

		System.out.println(b11.compareTo(b12));

		BigRational b31 = new BigRational("-2/-3");
		BigRational b32 = new BigRational("4/6");
		System.out.println(b31.equals(b32));

		BigRational b41 = new BigRational("2/-3");
		BigRational b42 = new BigRational("-40/60");
		System.out.println(b41.equals(b42));

		System.out.println(b11.doubleValue());
	}
}
