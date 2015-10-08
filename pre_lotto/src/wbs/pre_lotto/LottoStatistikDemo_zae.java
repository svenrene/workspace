package wbs.pre_lotto;

import java.util.Arrays;

public class LottoStatistikDemo_zae {

	public static void main(String[] args) {

		double time_11 = System.currentTimeMillis();

		int[] statistik1 = new int[7];
		int treffer;
		LottoZahlenSetTreeSetImpl ziehungsZahlen1 = new LottoZahlenSetTreeSetImpl(
				1, 2, 3, 4, 5, 6);
		for (int n = 0; n < 1_000_000; n++) {
			treffer = new LottoZahlenSetTreeSetImpl().treffer(ziehungsZahlen1);
			statistik1[treffer]++;
		}

		double time_12 = System.currentTimeMillis();

		double time_21 = System.currentTimeMillis();

		int[] statistik2 = new int[7];

		LottoZahlenSetBitsImpl ziehungsZahlen2 = new LottoZahlenSetBitsImpl(1,
				2, 3, 4, 5, 6);
		for (int n = 0; n < 1_000_000; n++) {
			treffer = new LottoZahlenSetBitsImpl().treffer(ziehungsZahlen2);
			statistik2[treffer]++;
		}

		double time_22 = System.currentTimeMillis();

		double diff1 = time_12 - time_11;
		double diff2 = time_22 - time_21;

		System.out.println("statistiken und laufzeitquotient:");
		System.out.println(Arrays.toString(statistik1));
		System.out.println(Arrays.toString(statistik2));
		System.out.println("laufzeit TreeSetImpl / laufzeit BitsImpl: " + (diff1 / diff2));
		
	}

}
