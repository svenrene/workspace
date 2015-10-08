package wbs.exceptions_assertions;

public class BadAssertionDemo {

	// wir verletzen die regeln und schreiben eine assertion mit nebeneffekt
	public static void main(String[] args) {

		int i = 0;

		assert (i++ >= 0);

		System.out.println("Der Wert von i ist: " + i);

		// wir verletzen die regeln und schreiben eine assertion mit recovery
		try {
			assert (i < 0);
		} catch (AssertionError e) {
			System.out.println("do not recover from assertion error...");
		}

	}

}
