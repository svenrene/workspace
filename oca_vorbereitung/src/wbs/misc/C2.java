package wbs.misc;

public class C2 {
	public static void main(String[] args) {
		
		C22 c22 = new C22();
		System.out.println(c22.m); // 22 - entscheidet der referenz-type der variablen
		
		C21 c21 = c22;
		System.out.println(c21.m); // 21 - entscheidet der referenz-type der variablen
		
		c21.m();   // m() von C22 - entscheidet der objekt-type der variablen
		
		c22.m2();  // m2() von C22 - entscheidet der objekt-type der variablen
		
	//	c21.m2();  // m2() von C22 - entscheidet der objekt-type der variablen
		
	//	new C21().m2(); // m2() von C21
		
		
	//	System.out.println(c22); // toString() von C22 
		
	//	System.out.println(c21); // toString() von C22
		
	//	System.out.println(new C21()); 	// toString() von Object
	
	}
}