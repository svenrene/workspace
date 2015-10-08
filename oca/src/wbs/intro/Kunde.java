package wbs.intro;

import java.util.List;
import java.util.ArrayList;

public class Kunde extends Object {

	private Adresse rechnungsAdresse;

	private List<Adresse> lieferAdressen = new ArrayList<>();

	private List<Ansprechpartner> ansprechpartners = new ArrayList<>();

	private double genrab_1;

	private double genrab_2;

	public Kunde(Adresse rechnungsAdresse, double genrab_1, double genrab_2) {

		this.rechnungsAdresse = rechnungsAdresse;

		this.genrab_1 = genrab_1;

		this.genrab_2 = genrab_2;

	}

	public Adresse getRechnungsAdresse() {
		return rechnungsAdresse;
	}

	public void setRechnungsAdresse(Adresse rechnungsAdresse) {
		this.rechnungsAdresse = rechnungsAdresse;
	}

	public double getGenrab_1() {
		return genrab_1;
	}

	public void setGenrab_1(double genrab_1) {
		this.genrab_1 = genrab_1;
	}

	public double getGenrab_2() {
		return genrab_2;
	}

	public void setGenrab_2(double genrab_2) {
		this.genrab_2 = genrab_2;
	}

	public boolean addAnsprechpartner(Ansprechpartner ansprechpartner) {
		return ansprechpartners.add(ansprechpartner);
	}

	public boolean removeAnsprechpartner(Object object) {
		return ansprechpartners.remove(object);
	}

	public boolean addLieferadresse(Adresse lieferAdresse) {
		return lieferAdressen.add(lieferAdresse);
	}

	public boolean removeLieferadresse(Object o) {
		return lieferAdressen.remove(o);
	}

	public List<Adresse> getLieferAdressen() {
		return lieferAdressen;
	}

	public List<Ansprechpartner> getAnsprechpartners() {
		return ansprechpartners;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(rechnungsAdresse);
		sb.append(System.lineSeparator());
		if (!ansprechpartners.isEmpty()) {
			sb.append("hauptansprechpartner: " + ansprechpartners.get(0));
			sb.append(System.lineSeparator());
		}
		sb.append("anzahl der ansprechpartner: " + ansprechpartners.size());
		sb.append(System.lineSeparator());
		sb.append("anzahl der lieferadressen: " + lieferAdressen.size());
		return sb.toString();
	}

	// @Override
	// public String toString() {
	// StringBuffer sb = new StringBuffer();
	// sb.append(rechnungsAdresse);
	// sb.append(System.lineSeparator());
	// if(!ansprechpartners.isEmpty()) {
	// sb.append("Hauptansprechpartner: " + ansprechpartners.get(0));
	// sb.append(System.lineSeparator());
	// }
	// for (int i = 0; i < ansprechpartners.size() ; i++ ) {
	// sb.append("Ansprechpartner " + i + ": " + ansprechpartners.get(i));
	// sb.append(System.lineSeparator());
	// }
	//
	// sb.append("Anzahl der Lieferadressen: " + lieferAdressen.size());
	//
	// for (int i = 0; i < lieferAdressen.size() ; i++ ) {
	// sb.append("Lieferadresse_: " + lieferAdressen.get(i));
	// sb.append(System.lineSeparator());
	// }
	// return sb.toString();
	// }

	// @Override
	// public String toString() {
	// return rechnungsAdresse + "\n" + "hauptansprechpartner: "
	// + ansprechpartners.get(0).getName() + "\n"
	// + "anzahl der ansprechpartner: " + ansprechpartners.size()
	// + "\n" + "anzahl der lieferadressen: " + lieferAdressen.size();
	// }

}
