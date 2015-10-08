package wbs.util;

// wir definieren einige methoden, die zur validierung von werten
// für variablen oder felder verwendet werden können

// bei fehlgeschlagener validierung werfen die methoden eine exception
// und zwar eine IllegalArgumentException


public class ValidationUtil {

	// da es keinen sinn macht, instanzen der klasse ValidationUtil zu erzeugen,
	// machen wir es unmöglich und deklarieren den konstruktor als private
	
	private ValidationUtil() {
		
	}
	
	// wir schreiben die methode .
	// sie prüft, ob ein int-wert in einem gegebenen intervall liegt
	
	public static void validateIntRange(int value, int min, int max) {
		if (value < min || value > max) {
			throw new IllegalArgumentException("illegal range: " + value
					+ " not within " + min + " and " + max);
		}		
	}
	
	public static void validateMinLengt(String value, int minLength) {
		if (value.length() < minLength) {
			throw new IllegalArgumentException(value + "too short"
					+ ": minLength is " + minLength);
		}
	}
	
	public static void validateEmail(String email) {
		if (!email.contains("@")) {
			throw new IllegalArgumentException(
					email + " doesn't contain @");
		}
	}
	
	public static void validateTriangle(double x, double a, double b, double c){
		if (x <= 0) {
			throw new IllegalArgumentException(a + " and " + b + " and " + c + " is not a valid triangle");
		}
	}
		
}