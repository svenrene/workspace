package wbs.math;

public class BigRationalUtil {

	// wir schreiben die methode createBigRationalFolge()

	// die methode liefert ein array mit einer folge von BigRational- objekten
	// die anzahl der folgenglieder und das bildungsgesetz der folge wird beim
	// aufruf als argument mitgegeben

	// wir haben hier ein abbildung von N (natürliche zahlen) nach Q (rationale
	// zahlen)

	// bsp.: 1/1 1/2 1/3 1/4 1/5 1/6...
	// bsp.: 1/1 1/1 1/2 1/6 1/24 1/120...

	public static BigRational[] createBigRationalFolge(int anzahl, IN2Q in2q) {
		BigRational[] result = new BigRational[anzahl];
		for (int i = 0; i < anzahl; i++) {
			result[i] = in2q.map(i + 1);
		}
		return result;
	}

	// wir schreiben die methode reihenSumme().
	// sie berechnet die summer der elemente einer folge von BigRational- objekte.
	// die anzahl der folgenelemente und da bildungsgesetz wird wiederum
	// beim aufruf übergeben
	
	public static BigRational reihenSumme(int n, IN2Q in2q) {
		BigRational result = new BigRational("0/1");
		for(;n>1;n--) {
			result = result.add(in2q.map(n));
		}
		return result;
	}
	
}
