package wbs.basic_data_types;

public class IntegerToStringDemo {

	// bei einer statischen methode ist der geliefert wert nur von den argumenten abhängig,
	// mit denen die methode aufgerufen wurde.
	
	// bei nicht statischen methoden ist der gelieferte wert nicht nur von den argumenten abhängig,
	// mit denen die methode aufgerufen wurde, sondern auch von dem objekt, für das
	// die methode aufgerufen wurde
	
	public static void main(String[] args) {
		
		Integer i1 = Integer.valueOf(1000);
		Integer i2 = Integer.valueOf(2000);
		
		String s1;
		String s2;
		
		char c1;
		char c2;
		
		s1 = i1.toString();		// "1000"
		s2 = i2.toString();		// "2000"
		
		c1 = s1.charAt(0);  	// '1'
		c2 = s2.charAt(0);  	// '2'
		
		s1 = Integer.toString(1234); 	// "1234"
		
		s1 = Integer.toString(32, 2); 	// "10000"
		
		System.out.println(c1);
		System.out.println(c2);
			
	}

}
