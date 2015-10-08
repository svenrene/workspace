package wbs.pre_lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class LottoZahlenSetTreeSetImpl {

	private SortedSet<Integer> zahlen = new TreeSet<>();

	private static Random rnd = new Random(); // ein rnd objekt reicht aus - so
												// muss nicht für jedes
												// zahlenset ein neues objekt
												// erzeugt werden

	// ggf die anzahl der beim aufruf übergebenen zahlen in einem weiteren feld
	// übergeben

	// varargs-parameter
	// der aufruf kann mit beliebig vielen argumenten vom typ int erfolgen (oder
	// einem int-array)
	// innerhalb der methode kann der varargs-parameter wie ein array behandelt
	// werden

	// wir müssen den fall abfangen, dass zu viele zahlen übergeben wurden, oder
	// zahlen, die nicht zwischen
	// 1 und 49 liegen
	// wir müssen überlegen, was wir machen, wenn initZahlen duplikate enthält

	// der entwickler einer klasse ist verantwortlich für die einhaltung ihrer
	// inhärenten logik
	// (ihrer fachlichen konsistenzbedingungen, ihrer invarianten)

	// hinweis: die klasse java.util.Collections könnte nützlich sein für die
	// validierung

	/**
	 * @param initialisierungszahlen
	 *            , duplikate werden ignoriert.
	 * @throws LottoException
	 *             falls nach eliminierung von duplikaten mehr als 6 zahlen
	 *             vorhanden sind, oder falls zahlen < 1 oder zahlen > 49
	 *             vorhanden sind.
	 */

	public LottoZahlenSetTreeSetImpl(int... initZahlen) throws LottoException {
		for (int zahl : initZahlen) {
			zahlen.add(zahl);
		}
		
		if (zahlen.size() > 6) {
			throw new LottoException("invalid arguments: "+ Arrays.toString(initZahlen));
		}

		if(zahlen.size() > 0 && (Collections.min(zahlen) < 1 || Collections.max(zahlen) > 49)) {
			throw new LottoException("invalid arguments: "+ Arrays.toString(initZahlen));
		}
		
		while (zahlen.size() < 6) {
			zahlen.add(rnd.nextInt(49) + 1);
		}

	}

	
	// wir müssen sicherstellen, dass nicht nur nach der erzeugung, sondern während
	// der gesamten lebensdauer des objektes die fachlichen
	public SortedSet<Integer> getZahlen() {
		// wie liefern dem aufrufer ein immutable set
		// unter verwendung einer passenden methode von java.util.Collections
		return Collections.unmodifiableSortedSet(zahlen);
	}

	public int treffer(LottoZahlenSetTreeSetImpl ziehungsZahlen) {
		int counter = 0;

		for (int zahl : ziehungsZahlen.getZahlen()) {
			if (zahlen.contains(zahl)) {
				counter++;
			}
		}
		return counter;
	}

	@Override
	public String toString() {
		return zahlen.toString();
	}

}
