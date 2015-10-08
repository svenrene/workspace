package wbs.exceptions;

public class AddBruecheDemo2 {

	// ähnlich wie AddBruecheDemo1
	// wir zählen nur die anzahl der nicht korrekten strings
	// (der konkrete fehler interessiert nicht)
	public static void main(String[] args) {

		String[] sa = { "1/2", "1/3", "2/0", "2/5", "blabla", "gaga/3", "5/6",
				"7/0" };

		double summe = 0;
		int exceptionsCounter = 0;

		for (String s : sa) {

			try {
				summe += RationaleZahlenUtil.string2Double(s);
			} catch (RuntimeException e) {
				exceptionsCounter++;
				System.out.println("fehler: " + s);
				System.out.println("fehlermeldung: " + e.getMessage());
			}

		}

		System.out.println("summe: " + summe);
		System.out.println("exceptionsCounter: "
				+ exceptionsCounter);
	}		
		

}
