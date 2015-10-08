package wbs.exceptions;

public class FinallyDemo2 {

	// illustriert die spezialregel für finally
	// mit System.exit()


	public static int m1(String s) {
		try {
			return Integer.parseInt(s);
		} 
		catch (NumberFormatException e) {
			System.exit(0);
			return 10;
		} finally {
			System.out.println("aha...");
		}
	}

	public static void main(String[] args) {
		System.out.println(m1("12345"));
		System.out.println(m1("blabla"));
	}

}
	