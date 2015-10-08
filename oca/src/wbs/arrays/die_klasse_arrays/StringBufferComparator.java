package wbs.arrays.die_klasse_arrays;

import java.util.Comparator;

public class StringBufferComparator implements Comparator<StringBuffer> {

	@Override
	public int compare(StringBuffer sb1, StringBuffer sb2) {

		return sb1.toString().compareTo(sb2.toString());
		
	}

}
