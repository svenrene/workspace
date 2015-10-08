package wbs.exceptions;

public class AddBruecheDemo3 {

	// wie AddBruecheDemo2, aber mit verwendung von multi-catch
	public static void main(String[] args) {

		String[] sa = { "1/2", "1/3", "2/0", "2/5", "blabla", "gaga/3", "5/6",
				"7/0" };

		double summe = 0;
		int exceptionsCounter = 0;

		for (String s : sa) {

			try {
				summe += RationaleZahlenUtil.string2Double(s);
				// multi-catch
			} catch (NumberFormatException | ArithmeticException e) {
				exceptionsCounter++;
				System.out.println("fehler: " + s);
				System.out.println("fehlermeldung: " + e.getMessage());
				
				// e ist final, eien erneute zuweisung im catch-block ist nicht
				// erlaubt
				// e = new RuntimeException();
			}

		}

		System.out.println("summe: " + summe);
		System.out.println("exceptionsCounter: " + exceptionsCounter);
	}	

}
