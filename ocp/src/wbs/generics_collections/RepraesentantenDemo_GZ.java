package wbs.generics_collections;

import java.util.HashSet;
import java.util.Set;

class Klasse_GZ { // property-type: P

	private String bezeichnung;
	private String klassenLehrer;

	public Klasse_GZ(String bezeichnung, String klassenLehrer) {
		this.bezeichnung = bezeichnung;
		this.klassenLehrer = klassenLehrer;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public String getKlassenLehrer() {
		return klassenLehrer;
	}

}

// die klasse schüler sollte eine eigenschaft haben,
// die den vergleich von schülern ermöglicht (im sinne von grösser / kleiner)
// z.b. notendurchschnitt
class Schueler_GZ { // object-type: O
	private String name;
	private double notenDurchschnitt;
	private Klasse_GZ klasse;

	public Schueler_GZ(String name, Klasse_GZ klasse, double notenDurchschnitt) {
		this.name = name;
		this.klasse = klasse;
		this.notenDurchschnitt = notenDurchschnitt;
	}

	@Override
	public String toString() {
		return name + "(" + notenDurchschnitt + ")" + " ist in klasse "
				+ klasse.getBezeichnung();
	}

	public String getName() {
		return name;
	}

	public double getNotenDurchschnitt() {
		return notenDurchschnitt;
	}

	public Klasse_GZ getKlasse() {
		return klasse;
	}

}

class SchuelerMapper_GZ implements Mapper<Schueler_GZ, Klasse_GZ> {

	@Override
	public Klasse_GZ map(Schueler_GZ schueler) {
		return schueler.getKlasse();
	}

}

public class RepraesentantenDemo_GZ {

	public static void main(String[] args) {
		Klasse_GZ k1 = new Klasse_GZ("k1", "abermann");
		Klasse_GZ k2 = new Klasse_GZ("k2", "bebel");
		Klasse_GZ k3 = new Klasse_GZ("k3", "schumacher");

		Schueler_GZ anton = new Schueler_GZ("anton", k1, 3.5);
		Schueler_GZ agathe = new Schueler_GZ("agathe", k2, 2.0);
		Schueler_GZ antoinette = new Schueler_GZ("antoinette", k3, 1.4);

		Schueler_GZ amelie = new Schueler_GZ("amelie", k1, 2.7);
		Schueler_GZ zoroaster = new Schueler_GZ("zoroaster", k2, 1.0);
		Schueler_GZ zarathustra = new Schueler_GZ("zarathustra", k3, 1.2);

		Set<Schueler_GZ> grundMenge = new HashSet<>();

		grundMenge.add(anton);
		grundMenge.add(agathe);
		grundMenge.add(antoinette);
		grundMenge.add(amelie);
		grundMenge.add(zoroaster);
		grundMenge.add(zarathustra);

		Mapper<Schueler_GZ, Klasse_GZ> mapper = new SchuelerMapper_GZ();

		Set<Schueler_GZ> repraesentanten = SetUtil.repraesentanten(grundMenge,
				mapper);

		for (Schueler_GZ schueler : repraesentanten) {
			System.out.println(schueler);
		}
	}
}
