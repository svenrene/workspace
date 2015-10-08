package wbs.enumeration;

public class PlatonischerKoerperDemo2 {

	public static void main(String[] args) {
		for(PlatonischerKoerper2 pk: PlatonischerKoerper2.values()) {
			System.out.println(pk.name());
			System.out.println("flaechen: " + pk.getFlaechen());
			System.out.println("kanten: " + pk.getKanten());
			System.out.println("ecken: " + pk.getEcken());
			System.out.println("------------");
		}

	}

}
