package wbs.schleifen;

import java.math.BigInteger;
import java.util.Iterator;

class PrimzahlenIterator implements Iterator<BigInteger> {

	private BigInteger startwert;
	private int anzahl;
	private int count;

	public PrimzahlenIterator(BigInteger startwert, int anzahl) {

		this.startwert = startwert;
		this.anzahl = anzahl;
	}

	@Override
	public boolean hasNext() {

		return count < anzahl;
	}

	@Override
	public BigInteger next() {
		BigInteger zahl = startwert.nextProbablePrime();
		count++;
		return (startwert = zahl);
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

}

class PrimzahlenGenerator implements Iterable<BigInteger> {

	private BigInteger startwert;
	private int anzahl;

	public PrimzahlenGenerator(BigInteger startwert, int anzahl) {

		this.startwert = startwert;
		this.anzahl = anzahl;

	}

	@Override
	public Iterator<BigInteger> iterator() {
		// TODO Auto-generated method stub
		return new PrimzahlenIterator(startwert, anzahl);
	}
}

public class PrimzahlenGeneratorDemo {

	public static void main(String[] args) {

		BigInteger startWert = new BigInteger("1000");
		int anzahl = 5;
		PrimzahlenGenerator generator = new PrimzahlenGenerator(startWert,
				anzahl);
		for (BigInteger primzahl : generator) {
			System.out.println(primzahl);
		}

	}
}
