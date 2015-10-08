package wbs.operators_decisions;

public class SwitchCaseDemo_zae {

	// aufruf mit 2 argumenten

	// das 1. argument muss 2, 8, 10 oder 16 sein
	// das 2. argument eine dezimal codierte zahl

	// die zahl wird entsprechend dem 1. argument dual, oktal,... dargestellt

	// im fehlerfall geben wir brauchbare fehlermeldungen aus

	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println("usage: SwitchCaseDemo base zahl");
		} else {
			try {
				int basis = Integer.parseInt(args[0]);
				int zahl = Integer.parseInt(args[1]);
				switch (basis) {
				case 2:
					System.out.println(zahl + " als dualzahl: "
							+ Integer.toBinaryString(zahl));
					break;
				case 8:
					System.out.println(zahl + " als oktalzahl: "
							+ Integer.toOctalString(zahl));
					break;
				case 10:
					System.out.println(zahl + " als dezimalzahl: " + zahl);
					break;
				case 16:
					System.out.println(zahl + " als hexadezimalzahl: "
							+ Integer.toHexString(zahl));
					break;
				default:
					System.out
							.println("basis muss 2 oder 8 oder 10 oder 16 sein");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("formatfehler...");
				System.out.println(e);
			}
		}
	}
}