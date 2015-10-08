package wbs.exceptions.bad;

public class BadCatchBlocksDemo {

	public static void main(String[] args) {

		try {
			int dividend = Integer.parseInt(args[0]);
			int divisor = Integer.parseInt(args[1]);
			int ergebnis = dividend / divisor;

			System.out.println("Das Ergebnis lautet: " + ergebnis);

		} catch (Throwable e) {
			
		} catch (Exception e) {
		
		} catch (RuntimeException e) {
		
		} catch (IndexOutOfBoundsException e) {
		
		} catch (ArrayIndexOutOfBoundsException e) {

		}
	}

}