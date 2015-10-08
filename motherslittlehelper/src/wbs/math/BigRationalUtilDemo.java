package wbs.math;

import java.math.BigInteger;
import java.util.Arrays;

class HarmonischeReiheMapper implements IN2Q {
	
	@Override
	public BigRational map(int n) {
		return new BigRational(BigInteger.ONE, new BigInteger(
				Integer.toString(n))); // besser: valueOf() von BigInteger
	}
}

class EulerscheReiheMapper implements IN2Q {

	public BigInteger fakultaet(int n) {
		BigInteger result = BigInteger.ONE;
		for(;n>1;n--) {
			result = result.multiply(new BigInteger(Integer.toString(n)));
		}
		return result;
	}

	@Override
	public BigRational map(int n) {
		return new BigRational(BigInteger.ONE,fakultaet(n - 1));
	}
}


public class BigRationalUtilDemo {

	public static void main(String[] args) {
		// wir geben die ersten 10 elemente der nachstehenden folgen aus
		
		// bsp.: 1/1 	1/2 	1/3 	1/4 	1/5 	1/6 ...
		// bsp.: 1/1	1/1		1/2		1/6		1/24	1/120 ...
		
		// 1/0!		1/1!	1/2!	1/4! ...
		
		// wir verwenden dazu die methode createBigRationalFolge() und verwenden
		// geeignete hilfsklassen
		IN2Q in2q = new HarmonischeReiheMapper();
		System.out.println(Arrays.toString(BigRationalUtil.createBigRationalFolge(10, in2q)));
		
		in2q = new EulerscheReiheMapper();
		System.out.println(Arrays.toString(BigRationalUtil.createBigRationalFolge(10, in2q)));
		
		BigRational br;
		for(int n= 1;n<=20;n++) {
			br = BigRationalUtil.reihenSumme(n, in2q);	
			System.out.println(br + " -> "+ br.doubleValue());
		}
		System.out.println("---------------");
		in2q = new HarmonischeReiheMapper();
		for(int n= 1;n<=20;n++) {
			br = BigRationalUtil.reihenSumme(n, in2q);	
			System.out.println(br + " -> "+ br.doubleValue());
	}
	}
}
