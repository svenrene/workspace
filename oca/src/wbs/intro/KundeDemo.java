package wbs.intro;

import java.util.List;

public class KundeDemo {

	public static void main(String[] args) {

		/*
		 * wir erzeugen einen kunden
		 * 
		 * der kunde bekommt eine rechnungsadresse und 2 lieferadressen
		 * 
		 * der kunde bekommt 2 ansprechpartner (SUPPORT und ENTWICKLUNG)
		 * 
		 * der kunde wird ausgegeben
		 */

		Adresse rechnungsAdresse = new Adresse("abermann", "esslingen", 73000,
				"berliner str. 12");

		Adresse lieferAdresse_1 = new Adresse("abermann", "winnenden", 71000,
				"frankfurter str. 24");

		Adresse lieferAdresse_2 = new Adresse("abermann", "winnenden", 72000,
				"wiesenweg 36");

		Ansprechpartner supporter = new Ansprechpartner("lampe", "012",
				Position.SUPPORT, "lampe@gmx.de");

		Ansprechpartner entwickler = new Ansprechpartner("lempe", "013",
				Position.ENTWICKLUNG, "lempe@gmx.de");

		Kunde kunde = new Kunde(rechnungsAdresse, 10.0, 15.0);

		kunde.addLieferadresse(lieferAdresse_1);
		kunde.addLieferadresse(lieferAdresse_2);

		kunde.addAnsprechpartner(supporter);
		kunde.addAnsprechpartner(entwickler);

		System.out.println(kunde);
		
		/*
		 * wir geben für jeden ansprechpartner des kunden die position, den namen und die durchwahl aus
		 */
		List<Ansprechpartner> ansprechpartners = kunde.getAnsprechpartners();
		
		// foreach- schleife
		for(Ansprechpartner ansprechpartner : ansprechpartners) {
			System.out.println(ansprechpartner.getPosition());
			System.out.println(ansprechpartner.getName());
			System.out.println(ansprechpartner.getDurchwahl());
			System.out.println("-----------");
		}
		
	}

}
