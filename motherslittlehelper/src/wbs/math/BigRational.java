package wbs.math;

import java.math.BigInteger;

/*
 * wir schreiben eine klasse, die die 4 grundrechenarten implementiert,
 * und zwar für bruchzahlen (rationale zahlen), bei denen zähler und nenner
 * beliebig grosse ganze zahlen sein können (s. BigInteger aus java.math) 
 */

// entscheidungen, die wir treffen müssen:

// - sollen instanzen der klasse BigRational immutable sein oder nicht?
// - soll die klasse ein natural ordering haben?
// - überschreiben wir equals()? falls ja: wie definieren wir wertmässige gleichheit für bruch-objekte?
// - machen wir BigRational zu einer subklasse von Number?

public class BigRational extends Number implements Comparable<BigRational> {

	private static final long serialVersionUID = 1L;

	private final BigInteger zaehler;
	private final BigInteger nenner;

	// konstruktor

	public BigRational(BigInteger zaehler, BigInteger nenner)
			throws ArithmeticException {
		if(nenner.equals(BigInteger.ZERO)) {
			throw new ArithmeticException("division by zero");
		}
		if (!zaehler.equals(BigInteger.ZERO)) {
			BigInteger ggt = zaehler.gcd(nenner);
			zaehler = zaehler.divide(ggt);
			nenner = nenner.divide(ggt);
			if (nenner.compareTo(BigInteger.ZERO) < 0) {
				zaehler = zaehler.negate();
				nenner = nenner.negate();
			}
		} else {
			nenner = BigInteger.ONE;
		}
		this.zaehler = zaehler;
		this.nenner = nenner;
	}

	public BigRational(String s) throws ArithmeticException,
			NumberFormatException {
		this(new BigInteger(s.substring(0, s.indexOf('/'))), new BigInteger(
				s.substring(s.indexOf('/') + 1)));
	}

	// methoden

	public BigRational add(BigRational bigRational) {
		BigInteger s1 = this.zaehler.multiply(bigRational.nenner);
		BigInteger s2 = this.nenner.multiply(bigRational.zaehler);
		BigInteger z = s1.add(s2);
		BigInteger n = this.nenner.multiply(bigRational.nenner);
		return new BigRational(z, n);

	}

	public BigRational subtract(BigRational bigRational) {
		BigInteger s1 = this.zaehler.multiply(bigRational.nenner);
		BigInteger s2 = this.nenner.multiply(bigRational.zaehler);
		BigInteger z = s1.subtract(s2);
		BigInteger n = this.nenner.multiply(bigRational.nenner);
		return new BigRational(z, n);
	}

	public BigRational multiply(BigRational bigRational) {
		BigInteger z = zaehler.multiply(bigRational.zaehler);
		BigInteger n = nenner.multiply(bigRational.nenner);
		return new BigRational(z, n);
	}

	public BigRational divide(BigRational bigRational)
			throws ArithmeticException {
		if (bigRational.zaehler.equals(BigInteger.ZERO)) {
			throw new ArithmeticException(
					"divison durch 0 ist nicht erlaubt...");
		}
		BigInteger z = zaehler.multiply(bigRational.nenner);
		BigInteger n = nenner.multiply(bigRational.zaehler);
		return new BigRational(z, n);

	}

	@Override
	public int compareTo(BigRational bigRational) {
		BigInteger t1 = this.zaehler.multiply(bigRational.nenner);
		BigInteger t2 = this.nenner.multiply(bigRational.zaehler);
		return t1.subtract(t2).signum();
	}

	@Override
	public int intValue() {
		return zaehler.intValue() / nenner.intValue();
	}

	@Override
	public long longValue() {
		return zaehler.longValue() / nenner.longValue();
	}

	@Override
	public float floatValue() {
		return zaehler.floatValue() / nenner.floatValue();
	}

	@Override
	public double doubleValue() {
		return zaehler.doubleValue() / nenner.doubleValue();
	}

	public BigInteger getZaehler() {
		return zaehler;
	}

	public BigInteger getNenner() {
		return nenner;
	}

	@Override
	public int hashCode() {
		return zaehler.hashCode() + nenner.hashCode();
	}

	@Override
	public boolean equals(Object other) {
		boolean result = false;
		if (other != null && other instanceof BigRational) {
			if (other == this) {
				result = true;
			} else {
				BigRational br = (BigRational) other;
				result = this.zaehler.equals(br.zaehler)
						&& this.nenner.equals(br.nenner);
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return zaehler + "/" + nenner;
	}

}
