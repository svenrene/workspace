package wbs.intro;

import wbs.util.ValidationUtil;

/*
 * wir stellen sicher, das die plz von adress-objekten immer zwischen 0
 * und 99999 liegt
 */

/*
 * der entwickler einer klasse sollte garantieren, dass die klasse ihre 
 * invarianten einhält (hier: plz)
 * 
 * 
 */

// Adresse ist implizit subklasse von Object
public class Adresse implements Comparable<Adresse>{

	// felder
	private String name;
	private String ort;
	private int plz;
	private String strasse;

	// counter gibt es nur e i n mal, anders als name,... , die es für j e d e s objekt gibt
	// man spricht von klassenvariable oder statischem feld
	private static int counter = 0;

	// konstruktoren
	public Adresse() {
		// bei jedem konstruktoraufruf wird counter inkrementiert
		counter++;
	}

	public Adresse(String name, String ort, int plz, String strasse) {
		// ruft den parameterlosen konstruktor der klasse auf
		this();
		// this ist in einem nicht statischen kontext eine referenz auf 
		// das aktuelle objekt
		this.name = name;
		this.ort = ort;
		// this.plz = plz;
		setPlz(plz);
		this.strasse = strasse;
	}

	public static int getCounter() {
		return counter;
	}

	// bitte die konventionen für getter- und setter- methoden beachten!
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		ValidationUtil.validateIntRange(plz, 0, 99999);
		this.plz = plz;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	@Override
	public String toString() {
		return "Adresse [name=" + name + ", ort=" + ort + ", plz=" + plz
				+ ", strasse=" + strasse + "]";
	}

	@Override
	public int compareTo(Adresse a) {
		return this.name.compareTo(a.name);
	}

}
