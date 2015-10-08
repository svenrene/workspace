package wbs.pre_lotto;

import java.util.Arrays;
import java.util.Random;

// dieselbe fachliche logik wie die auf TreeSet basierende implementierung,
// aber die umsetzung basiert auf bits, die in einem long gesetzt werden
// (jedes der gesetzten 6 bits steht für eine zahl zwischen 1 und 49)

public class LottoZahlenSetBitsImpl {

	private static Random rnd = new Random();

	private long zahlenAsBits;

	public LottoZahlenSetBitsImpl(int... initZahlen) throws LottoException {

		boolean isOk = true;

		for (int zahl : initZahlen) {
			if (zahl < 1 || zahl > 49) {
				isOk = false;
				break;
			}
			zahlenAsBits = zahlenAsBits | (1L << zahl);
		//	zahlenAsBits |= (1L << zahl); // abgekürzte version von zeile 25

		}
		if (!isOk || Long.bitCount(zahlenAsBits) > 6) {
			throw new LottoException("invalid arguments: "
					+ Arrays.toString(initZahlen));
		}
		
		while (Long.bitCount(zahlenAsBits) != 6) {
			zahlenAsBits |= (1L << (rnd.nextInt(49) + 1));
		}
	}

	public int treffer(LottoZahlenSetBitsImpl lottoZahlenSet) {
		return Long.bitCount(lottoZahlenSet.zahlenAsBits & this.zahlenAsBits);
	}

	public long getZahlenAsBits() {
		return zahlenAsBits;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("[");
		for (int i = 1, counter = 0; counter < 6; i++) {
			if ((zahlenAsBits & (1L << i)) != 0) {
				counter++;
				sb.append(counter < 6 ? i + ", " : i);
			}
		}
		sb.append("]");
		return sb.toString();
	}
}
