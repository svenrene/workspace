package wbs.mathtest;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

import wbs.math.BigRational;

public class BigRationalTest {

	@Test
	public void testBigRationalBigIntegerBigInteger() {
		boolean isOK = false;
		BigInteger zaehler = BigInteger.ONE;
		BigInteger nenner = BigInteger.ZERO;
		try {
			new BigRational(zaehler, nenner);
		}
		catch(ArithmeticException e) {
			isOK = true;
		}
		assertTrue(isOK);
	}

	@Test
	public void testBigRationalString() {
		boolean isOK_1 = false;
		boolean isOK_2 = false;
		try {
			new BigRational("2/0");
		}
		catch(ArithmeticException e) {
			isOK_1 = true;
		}
		try {
			new BigRational("blabla/gaga");
		}
		catch(NumberFormatException e) {
			isOK_2 = true;
		}
		assertTrue(isOK_1 && isOK_2);
	}

	@Test
	public void testAdd() {
		BigRational r1 = new BigRational("1/2");
		BigRational r2 = new BigRational("1/3");
		BigRational result = r1.add(r2);
		BigRational expected = new BigRational("5/6");
		assertTrue(result.equals(expected));
	}

	@Test
	public void testSubtract() {
		BigRational r1 = new BigRational("1/2");
		BigRational r2 = new BigRational("1/3");
		BigRational result = r1.subtract(r2);
		BigRational expected = new BigRational("1/6");
		assertTrue(result.equals(expected));
	}

	@Test
	public void testMultiply() {
		BigRational r1 = new BigRational("1/2");
		BigRational r2 = new BigRational("1/3");
		BigRational result = r1.multiply(r2);
		BigRational expected = new BigRational("1/6");
		assertTrue(result.equals(expected));
	}

	@Test
	public void testDivide() {
		boolean isOK = false;
		BigRational r1 = new BigRational("2/3");
		BigRational r2 = new BigRational("0/1");
		try {
			r1.divide(r2);
		}
		catch(ArithmeticException e) {
			isOK = true;
		}
		assertTrue(isOK);
	}

	@Test
	public void testEquals() {
		BigRational r1 = new BigRational("2/3");
		BigRational r2 = new BigRational("4/6");
		BigRational r3 = new BigRational("-8/-12");
		boolean isOK = r1.equals(r2) && r1.equals(r3) && r2.equals(r3);
		assertTrue(isOK);
	}

}
