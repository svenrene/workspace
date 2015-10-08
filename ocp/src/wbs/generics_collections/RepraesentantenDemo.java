package wbs.generics_collections;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

class Klasse { // property-type: P
	private String bezeichnung;
	private String klassenLehrer;

	public Klasse(String bezeichnung, String klassenLehrer) {
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
// die den vergleich von schülern ermöglicht (im sinne von grösser / kleiner
// z.b. notendurchschnitt

class Schueler { // object-type: O
	private String name;
	private double notenDurchschnitt;
	private Klasse klasse;

	public Schueler(String name, Klasse klasse, double notenDurchschnitt) {
		this.name = name;
		this.klasse = klasse;
		this.notenDurchschnitt = notenDurchschnitt;
	}

	@Override
	public String toString() {
		return name + "(" + notenDurchschnitt + ")" + " ist in klasse ";
	}

	public String getName() {
		return name;
	}

	public double getNotenDurchschnitt() {
		return notenDurchschnitt;
	}

	public Klasse getKlasse() {
		return klasse;
	}
}

class SchuelerMapper implements Mapper<Schueler, Klasse> {

	@Override
	public Klasse map(Schueler schueler) {
		return schueler.getKlasse();
	}
}

class SchuelerNotenComparator implements Comparator<Schueler> {

	@Override
	public int compare(Schueler s1, Schueler s2) {
		return Double.compare(s2.getNotenDurchschnitt(),
				s1.getNotenDurchschnitt());
	}
}

public class RepraesentantenDemo {

	public static void main(String[] args) {
		Klasse k1 = new Klasse("k1", "abermann");
		Klasse k2 = new Klasse("k2", "bebel");
		Klasse k3 = new Klasse("k3", "schumacher");

		Schueler anton = new Schueler("anton", k1, 3.5);
		Schueler agathe = new Schueler("agathe", k2, 2.0);
		Schueler antoinette = new Schueler("antoinette", k3, 1.4);

		Schueler amelie = new Schueler("amelie", k1, 2.7);
		Schueler zoraster = new Schueler("zoraster", k2, 1.0);
		Schueler zarathustra = new Schueler("zarathustra", k3, 1.2);

		Set<Schueler> grundMenge = new HashSet<>();

		grundMenge.add(anton);
		grundMenge.add(agathe);
		grundMenge.add(antoinette);
		grundMenge.add(amelie);
		grundMenge.add(zoraster);
		grundMenge.add(zarathustra);

		Mapper<Schueler, Klasse> mapper = new SchuelerMapper();

		Set<Schueler> repraesentanten = SetUtil.repraesentanten(grundMenge,
				mapper);

		for (Schueler schueler : repraesentanten) {
			System.out.println(schueler);
		}

		System.out.println("-----------------");

		SchuelerNotenComparator cmp = new SchuelerNotenComparator();

		repraesentanten = SetUtil.repraesentanten(grundMenge, mapper, cmp);

		for (Schueler schueler : repraesentanten) {
			System.out.println(schueler);
		}
	}
}
