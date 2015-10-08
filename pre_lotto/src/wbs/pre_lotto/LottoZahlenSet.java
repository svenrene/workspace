package wbs.pre_lotto;

import java.util.Random;
import java.util.TreeSet;

/*
 * der standardkonstruktor erzeugt 6 verschiedene zahlen zwischen 1 und 49
 * 
 * ein weiterer konstruktor ermöglicht die übergabe von bis zu 6 zahlen
 * 
 * die klasse bekommt die methode treffer. dieser wird eine lottozahlenset als
 * argument übergeben, und sie liefert die anzahl der übereinstimmenden zahlen.
 * (mögliche werte: alles zwischen 0 und 6)
 * 
 * wir liefern eine passende überschreibung von toString().
 * 
 * wir liefern verschiedene implementierungen dieser klasse (unter verschiedenen namen)
 * 
 * mögliche implementierungen:
 * - HashSet
 * - BitSet
 * - TreeSet
 * - Array von int (byte,...)
 * - List
 * - ...
 */

public class LottoZahlenSet{

	public LottoZahlenSet() {

		TreeSet<Integer> ziehungsZahlen = new TreeSet<Integer>();

		Random rndm = new Random();

		for (; ziehungsZahlen.size() < 6;) {
			ziehungsZahlen.add(rndm.nextInt(49) + 1);
		}
	//	System.out.println(ziehungsZahlen.toString());
		
	}

}
