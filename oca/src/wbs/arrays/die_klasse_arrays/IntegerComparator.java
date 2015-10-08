package wbs.arrays.die_klasse_arrays;

import java.util.Comparator;

public class IntegerComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer i1, Integer i2) {
		int diff = Integer.bitCount(i1) - Integer.bitCount(i2);
		return diff != 0 ? diff : Integer.compare(i1, i2);
	}
}
