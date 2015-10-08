package wbs.exceptions_assertions;

public class AssertionDemo {

	public static void main(String[] args) {
		System.out.println("vor assertion...");

		// int i = -10;
		int i = Integer.MIN_VALUE;
		if (i < 0) {
			i = -i;
		}

		System.out.println("Der Wert von i ist: " + i);
		// i sollte also immer positiv sein
		assert (i >= 0) : "unmöglich: i ist negativ!";
		System.out.println("nach assertion...");
		System.out.println("Der Wert von i ist: " + i);
	}

}
