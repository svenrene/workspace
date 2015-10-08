package wbs.mathtest;

import static org.junit.Assert.*;

import org.junit.Test;

import wbs.math.BigRational;
import wbs.math.BigRationalUtil;
import wbs.math.IN2Q;

public class BigRationalUtilTest {

	@Test
	public void testReihenSumme() {

		IN2Q in2q = new IN2Q() {
			@Override
			public BigRational map(int n) {
				return new BigRational(n + "/1");
			}
		};
		BigRational reihenSumme = BigRationalUtil.reihenSumme(5, in2q);
		BigRational expected = new BigRational("15/1");
		assertTrue(expected.equals(reihenSumme));

	}

}
