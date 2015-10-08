package wbs.basic_data_types;

import java.util.BitSet;

public class BitSetDemo {

	public static void main(String[] args) {

		String s = "135";

		System.out.println(s.charAt(0));
		System.out.println(s.charAt(0) + 0);

		BitSet bs = new BitSet();
		System.out.println(bs);

		bs.set(s.charAt(0));
		bs.set(s.charAt(1));
		bs.set(s.charAt(2));
		System.out.println(bs);

	}

}
