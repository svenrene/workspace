package wbs.exceptions.bad;

public class SystemExitDemo {

	public static void main(String[] args) {

		Integer laenge_plz = 12459;

		try {

			if (laenge_plz.toString().length() != 5) {
				throw new IllegalArgumentException();
			}

		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			System.out.println("Wenn Sie diesen Text in der Ausgabe lesen können, wurde keine IllegalArgumentException geworfen!");
		}
	}

}