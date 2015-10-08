package wbs.arrays.die_klasse_arrays;

import java.util.BitSet;
import java.util.Comparator;

public class DiffDigitComparator implements Comparator<Integer> {

	public int countDiffDigits(Integer number) {
		BitSet bs = new BitSet();
		
		for (int i = 0; i < String.valueOf(number).length(); i++) {
			bs.set(String.valueOf(number).charAt(i));
		}
		
		return bs.cardinality();
	}

	@Override
	public int compare(Integer i1, Integer i2) {

		int diff = this.countDiffDigits(i1) - this.countDiffDigits(i2);
		return diff != 0 ? diff : Integer.compare(i1, i2);
	}

}
