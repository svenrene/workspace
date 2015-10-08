package wbs.enumeration;

public class PlatonischerKoerperDemo {

	public static void main(String[] args) {
		for(PlatonischerKoerper pk: PlatonischerKoerper.values()) {
			System.out.println(pk.name());
			System.out.println("flaechen: " + pk.flaechen());
			System.out.println("kanten: " + pk.kanten());
			System.out.println("ecken: " + pk.ecken());
			System.out.println("------------");
		}

	}

}
