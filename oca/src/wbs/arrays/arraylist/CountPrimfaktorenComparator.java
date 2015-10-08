package wbs.arrays.arraylist;

import java.util.Comparator;

import wbs.schleifen.NumberUtil;

public class CountPrimfaktorenComparator implements Comparator<Integer> {


	@Override
	public int compare(Integer i1, Integer i2) {
		int anz1 = NumberUtil.primfaktoren(i1).size();
		int anz2 = NumberUtil.primfaktoren(i2).size();
		int diff = anz1-anz2;
		
		
		return diff != 0 ? diff: Integer.compare(i1, i2);
	}
}
