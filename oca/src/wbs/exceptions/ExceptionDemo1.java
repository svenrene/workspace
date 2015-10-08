package wbs.exceptions;

public class ExceptionDemo1 {

	public static void m1() throws MyUncheckedException {

	}

	public static void m2() throws MyCheckedException {

	}

	// kein problem, da m1() eine unchecked exception wirft.
	// m3() könnte diese exception mit throws deklarieren, muss es aber nicht
	public static void m3() {
		m1();
	}

// compilerfehler, da m2() eine checked exception deklariert
//	public static void m4() {
//		m2();
//	}
	
	// ok
	// m41() könnte als exception auch Exception oder Throwable deklarieren
	// i.d.r. sollten deklarationen von exceptions spezifisch sein, also dem aufrufer
	// die art der möglichen fehler klar signalisieren
	public static void m41() throws MyCheckedException {
		m2();
	}
	
	// der catch-block könnte statt MyException auch Exception oder Throwable deklarieren
	public static void m42() {
		try {
			m2();
		} catch (MyCheckedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		m3();
//		m41();
		m42();		

	}

}
