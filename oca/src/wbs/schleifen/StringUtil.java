package wbs.schleifen;

import java.util.HashMap;
import java.util.Map;

public class StringUtil {

	/*
	 * wir schreiben die methode isPalindrom(). sie testet, ob ein gegebener
	 * string ein palindrom ost, also von links nach rechts gelesen dasselbe
	 * ergibt wie von rechts nach links gelesen (otto, retter, anna, ...)
	 */

	public static boolean isPalindrom(String text) {

		boolean result = false;

		int j = text.length() - 1;

		for (int i = 0; i < text.length(); i++) {

			if (text.charAt(i) == text.charAt(j)) {
				j--;

			} else {
				return (false);
			}
			result = true;
		}
		return (result);
	}

	// wir schreiben eine methode, die die anzahl der verschiedenen zeichen
	// in einem string ermittelt
	// bsp.: anna -> 2
	// bsp.: mutti -> 4
	// bsp.: BLABLA -> 3

	// hinweise:
	// die klasse BitSet aus java.util. könnte nützlich sein
	// die klasse HashSet aus java.util könnte ebenfalls nützlich sein

	public static String countDifferentChars(String str) {
		// int anzahleinzelnerzeichen = 0;
		StringBuffer sb = new StringBuffer();
		Map<String, Integer> Map = new HashMap<String, Integer>();
		for (int i = 0; i < str.length(); i++) {
			
			String s = str.substring(i, i + 1);

			if (Map.containsKey(s)) {
				Map.put(s, (Integer) Map.get(s) + 1);

			} else {
				Map.put(s, 1);
				sb.append(s);
			}
		}
	//	return sb.toString();
		return Map.toString();
		// return sb.length();
	}
	
	// wir schreiben eine methode, die testet, ob alle zeichen in einem string
	// streng aufsteigend aufeinander folgen. methodenname: isStrictAscending()
	
	// bsp.: "aber" -> true
	// bsp.: "1469" -> true
	// bsp.: "turmfalke" -> false
//	public static boolean isStrictAscending(String str) {
//
//		int textlänge = str.length();
//
//		if (textlänge == 0) {
//
//		} else {
//			for (int i = 0;  i >= textlänge-1 ; i++) {
//				if (! (str.charAt(i) < str.charAt(i + 1))) {
//					return false;
//				}
//			}
//		}
//		System.out.println(str.charAt(2));
//		return true;
//	}
	
	public static boolean isStrictAscending(String s) {
		int i = 1;
		for(; i<s.length() && s.charAt(i) > s.charAt(i-1);i++) {
			// nothing to do
		}

		return i >= s.length();
	}
}
