public class Gleich_Versus_Equals {

	public static void main(String[] args) {
		Integer i = 100;
		Integer i2 = 100;

		System.out.println("GLEICH: " + (i == i2));
		System.out.println("EQUALS: " + i.equals(i2));
		System.out.println("******");

		Byte b = 100;

		// System.out.println("GLEICH: " + (b == i2)); // Compilerfehler
		System.out.println("EQUALS: " + b.equals(i2));
		System.out.println("******");
		
		Long l = 100l;

		// System.out.println("GLEICH: " + (l == i2)); // Compilerfehler
		System.out.println("EQUALS: " + l.equals(i2));
		System.out.println("******");
		
		i = 150;
		i2 = 150;

		System.out.println("GLEICH: " + (i == i2));
		System.out.println("EQUALS: " + i.equals(i2));
		System.out.println("******");
		

	}

}
