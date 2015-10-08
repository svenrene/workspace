package wbs.exceptions;

public class AddBruecheDemo1 {

	/*
	 * wir deklarieren ein string-array und initialisieren es mit einigen
	 * strings wir betrachten jeden der strings als bruch, und addieren alle
	 * diese brüche als double (mit string2Double()).
	 * 
	 * die anwendung gibt die summe aller brüche aus (als double), sowie die
	 * anzahl der ArithmeticExceptions und der NumberFormatExceptions
	 */

	public static void main(String[] args) {

		String[] sa = { "1/2", "1/3", "2/0", "2/5", "blabla", "gaga/3", "5/6",
				"7/0" };

		double summe = 0;
		int arithmeticExceptionsCounter = 0;
		int numberFormatExceptionsCounter = 0;

		for (String s : sa) {

			try {
				summe += RationaleZahlenUtil.string2Double(s);
			} catch (NumberFormatException e) {
				numberFormatExceptionsCounter++;
				System.out.println("formatfehler");
				System.out.println("fehlermeldung: " + e.getMessage());
			} catch (ArithmeticException e) {
				arithmeticExceptionsCounter++;
				System.out.println("formatfehler");
				System.out.println("fehlermeldung: " + e.getMessage());
			}

		}

		System.out.println("summe: " + summe);
		System.out.println("arithmeticExceptionsCounter: "
				+ arithmeticExceptionsCounter);
		System.out.println("numberFormatExceptionsCounter: "
				+ numberFormatExceptionsCounter);
	}

}
