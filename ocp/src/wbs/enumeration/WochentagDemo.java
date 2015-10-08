package wbs.enumeration;

enum Wochentag {
	MO, DI, MI, DO, FR, SA, SO
}

// die konstanten des enums sind hier vom typ des enum selbst...
// in komplexeren enums können sie auch ein subtyp sein...

public class WochentagDemo {

	public static void main(String[] args) {
		// die methoden values(), name() und ordinal generiert der compiler
		// values() ist static, name() und ordinal() sind nicht static
		Wochentag[] values = Wochentag.values();
		for (Wochentag tag : values) {
			System.out.println(tag.name() + " " + tag.ordinal() + " -> "
				+ tag.getClass().getName());
		}
	}
}
