package wbs.exceptions;

public class RationaleZahlenUtil {

	// wir schreiben die methode String2Double, die zu einem als String
	// gegebenen bruch
	// einen double liefert

	// bsp.: "1/2" -> 0.5
	// bsp.: "3/4" -> 0.75
	// bsp.: "12a/4" -> NumberFormatException
	// bsp.: "5/0" -> ArithmeticException

	// bsp.: "4" -> NumberFormatException oder 4.0

	public static double string2Double(String s) throws NumberFormatException,
			ArithmeticException {
		int pos = s.indexOf('/');
		double zaehler;
		double nenner = 1.0;
		if (pos >= 0) {
			zaehler = Integer.parseInt(s.substring(0, pos));
			nenner = Integer.parseInt(s.substring(pos + 1));
			if (nenner == 0) {
				throw new ArithmeticException("nenner darf nicht 0 sein...");

			}
		} else {
			zaehler = Integer.parseInt(s);
		}
		return zaehler / nenner;
	}

}
