package wbs.pre_lotto;

public class LottoZahlenSetBitsImplDemo {

	public static void main(String[] args) {

		LottoZahlenSetBitsImpl meinTipp = new LottoZahlenSetBitsImpl(1,2,3,4,5,6);

		LottoZahlenSetBitsImpl ziehungsZahlen = new LottoZahlenSetBitsImpl(1,
				2, 3, 4, 31, 44);

		int trefferZahl = meinTipp.treffer(ziehungsZahlen);

		System.out.println("meinTipp: " + meinTipp);
		System.out.println("ziehungsZahlen: " + ziehungsZahlen);
		System.out.println("trefferZahl: " + trefferZahl); // ergebnis: 1 wert
															// zwischen 0 und 6
		try {
			System.out.println(new LottoZahlenSetBitsImpl(1, 2, 3, 4, 5, 6,
					7));
		} catch (LottoException e) {
			System.out.println(e);
		}
		try {
			System.out
					.println(new LottoZahlenSetBitsImpl(1, 3, 4, 5, 6, 50));
		} catch (LottoException e) {
			System.out.println(e);
		}
		try {
			System.out
					.println(new LottoZahlenSetBitsImpl(0, 2, 4, 5, 6, 49));
		} catch (LottoException e) {
			System.out.println(e);
		}
		try {
			System.out.println(new LottoZahlenSetBitsImpl(1, 2, 3, 3, 3, 3,
					3, 3, 3));
		} catch (LottoException e) {
			System.out.println(e);
		}
	}

}
