package wbs.schleifen;

public class StringUtil_zae {

	/*
	 * wir schreiben die methode isPalindrom(). sie testet, ob ein gegebener
	 * string ein palindrom ost, also von links nach rechts gelesen dasselbe
	 * ergibt wie von rechts nach links gelesen (otto, retter, anna, ...)
	 */

	private StringUtil_zae() {

	}

	public static boolean isPalindrom(String s) {

		int i = 0;
		int j = s.length() - 1;
		for (; i < j && s.charAt(i) == s.charAt(j); i++, j--);
		// nothing to do
		return i >= j;

	}

}