package wbs.arrays.die_klasse_arrays;

import java.util.Comparator;

public class RandomDiffComparator implements Comparator<Integer> {

	int z1;

	public RandomDiffComparator(int z1) {
		this.z1 = z1;
	}

	@Override
	public int compare(Integer i1, Integer i2) {

		int diff1 = Math.abs(Integer.valueOf(z1) - Integer.valueOf(i1));
		int diff2 = Math.abs(Integer.valueOf(z1) - Integer.valueOf(i2));

		return Integer.compare(diff1, diff2);

	}

}
