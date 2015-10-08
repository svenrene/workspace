package wbs.intro;

public class ValidateAdresseDemo {

	/*
	 * die anwendung wird mit 4 argumenten aufgerufen name, ort, plz, strasse
	 * 
	 * dann wird ein adress-objekt erzeugt und ausgegeben
	 * 
	 * wir behandeln gezielt alle möglichen fehler
	 */

	/*
	 * es ist häufig so, dass man in einem catch- block eine von einer niedrigen layer
	 * geworfene exception auffangt, und dem aufrufer eine exception einer höheren layer
	 * weiterreicht, die ihrerseits die exception der niedrigen layer als "cause" transportiert
	 */
	public static void main(String[] args) {
		try {
			String name = args[0];
			String ort = args[1];
			int plz = Integer.parseInt(args[2]);
			String strasse = args[3];
			Adresse adresse = new Adresse(name, ort, plz, strasse);
			System.out.println(adresse);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("zu wenig argumente...");
			System.out.println(e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println("formatfehler...");
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println("illegal argument...");
			System.out.println(e.getMessage());
		} finally {
			System.out.println("in finally...");
		}
	}

}
