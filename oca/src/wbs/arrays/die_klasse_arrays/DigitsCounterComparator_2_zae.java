package wbs.arrays.die_klasse_arrays;

import java.util.Comparator;

// 45
// bits1: 00110000
// filtert folgende zahlen raus 445, 455, weil im bitcount das gleiche wie 45

public class DigitsCounterComparator_2_zae implements Comparator<Integer> {

	@Override
	public int compare(Integer i1, Integer i2) {
		int bits1 = 0;
		int bits2 = 0;
		int diff;
		for (int z1 = i1; z1 != 0; z1 /= 10) {
			bits1 |= (1 << (z1 % 10)); // liefert 5
		}
		for (int z2 = i2; z2 != 0; z2 /= 10) {
			bits2 |= (1 << (z2 % 10));
		}
		diff = Integer.bitCount(bits1) - Integer.bitCount(bits2);
		return diff != 0 ? diff : Integer.compare(i1, i2);
	}
}
