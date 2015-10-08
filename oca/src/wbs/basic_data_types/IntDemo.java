package wbs.basic_data_types;

public class IntDemo {

	public static void main(String[] args) {
		
		/*
		 * wir untersuchen einige eigenschaften des datentyps int
		 * (division durch 0, überlaufprobleme, division mit rest,...) 
		 */
		
		int i1 = 1_234_567_890;
		int i2 = 1_234_567_890;
		int i3 = 0;
		int i4 = 4;
		int i5 = 5;
		
		int erg1 = i1 * i2;
		int erg2 = i4 / i5;
		int erg3;
		
		System.out.println(erg1); // 304084036 	überlauf...
		System.out.println(erg2); // 0			keine rundung...
		
		try{
			erg3 = i4 / i3;		  // division by zero liefert ArithmeticException
			System.out.println(erg3);
		}
		catch(ArithmeticException e) {
			System.out.println("arithmeticException: " + e.getMessage()); // ArithmeticException: / by zero
		}

	}

}
