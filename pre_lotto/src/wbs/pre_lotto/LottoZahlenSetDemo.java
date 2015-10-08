package wbs.pre_lotto;

public class LottoZahlenSetDemo {

	public static void main(String[] args) {

		LottoZahlenSetTreeSetImpl meinTipp = new LottoZahlenSetTreeSetImpl(7, 34, 35, 39, 41, 43);
		
		LottoZahlenSetTreeSetImpl ziehungsZahlen = new LottoZahlenSetTreeSetImpl();

		int trefferZahl = meinTipp.treffer(ziehungsZahlen);
		
		System.out.println("meinTipp: " + meinTipp);
		System.out.println("ziehungsZahlen: " + ziehungsZahlen);
		System.out.println("trefferZahl: " + trefferZahl); // ergebnis: ein wert zwischen 0 und 6
		
		
		try{
			System.out.println(new LottoZahlenSetTreeSetImpl(1,2,3,4,5,6,7));
		}
		catch(LottoException e) {
			System.out.println(e);
		}
		try{
			System.out.println(new LottoZahlenSetTreeSetImpl(1,2,3,4,5,50));
		}
		catch(LottoException e) {
			System.out.println(e);
		}
		try{
			System.out.println(new LottoZahlenSetTreeSetImpl(0,2,3,4,5,6));
		}
		catch(LottoException e) {
			System.out.println(e);
		}
		try{
			System.out.println(new LottoZahlenSetTreeSetImpl(1,2,3,3,3,3,3,3,3));
		}
		catch(LottoException e) {
			System.out.println(e);
		}
		
		System.out.println(meinTipp); // z.B. [7, 34, 35, 39, 41, 43]
		try{
			meinTipp.getZahlen().add(1);
		}
		catch(UnsupportedOperationException e) {
			System.out.println(e);
		}
		System.out.println(meinTipp); // [7, 34, 35, 39, 41, 43] puh...
		
	}

}
