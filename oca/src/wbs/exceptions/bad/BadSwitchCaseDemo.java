package wbs.exceptions.bad;

public class BadSwitchCaseDemo {

	public static void main(String[] args) {

		String zootier = "Elefant";

		switch (zootier) {

		case "Affe":

		case "Elefant":
		
		case "Zebra":

		default:
			throw new AssertionError("Ohne Break ist alles sinnlos!");
		}

		System.out.println("Hallo " + zootier + ". Willkommen im Zoo!");

	}

}