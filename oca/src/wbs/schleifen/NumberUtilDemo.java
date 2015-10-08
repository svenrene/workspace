package wbs.schleifen;

public class NumberUtilDemo {

	public static void main(String[] args) {

		for(int zahl = 1; zahl <= 10000; zahl++){
			if(NumberUtil.isPerfect(zahl)) {
				System.out.println(zahl);
			}
		}
		
		
		System.out.println("Die Quersumme ist: " + NumberUtil.querSumme(123456789));
		
	//	System.out.println(NumberUtil.isPerfect(29));

	//	System.out.println(NumberUtil.collatz(111_111_1111));
		
	}
	

}
