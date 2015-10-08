package wbs.nim;

import java.util.Arrays;
import java.util.Random;

public class Nim {
	
	protected int[] reihen;
	protected int bitMuster;
	protected int restReihen;  // anzahl der nicht leeren reihen
	protected static Random random = new Random();
	public static final int ANZREIHEN = 5;
	public static final int MAXSTEINE = 10;
	// Nim nim1 = new Nim();
	// Nim nim2 = new Nim(5, 20);
	// int[] ia = {1,2,3,4,5,6,7};
	// Nim nim3 = new Nim(ia);
	public Nim() {
		this(ANZREIHEN, MAXSTEINE);
	}
	
	public Nim(int anzReihen, int maxSteine) throws NimException {
		if(anzReihen < 1 || maxSteine < 1) {
			throw new NimException("invalid ...");
		}
		reihen = new int[anzReihen];
		restReihen = anzReihen;
		for (int i = 0; i < reihen.length; i++) {
			reihen[i] = random.nextInt(maxSteine) + 1;
			bitMuster ^= reihen[i];
		}
	}
	
	public Nim(int[] reihen) throws NimException {
		if(reihen.length < 1) {
			throw new NimException("invalid ...");
		}
		this.reihen = new int[reihen.length];
		for (int i = 0; i < reihen.length; i++) {
			if (reihen[i] < 1) {
				throw new NimException("invalid ...");
			}
			this.reihen[i] = reihen[i];
			bitMuster ^= reihen[i];
		}
		restReihen = this.reihen.length;
	}

	// vorgabe: gibt es in einer stellung mehrere mögliche zugvorschläge,
	// soll nach dem zufallsprinzip aiusgewählt werden
	
	// vorgabe: in einer gewinnstellung wird immer ein optimaler
	// zug vorgeschlagen
	
	// WENN gewinnstellung // bitMuster != 0
	// DANN suche reihen, in der highestOneBit von bitMuster gesetzt ist
	// 		ermittle die neue anzahl in dieser reihe // reihe ^ bitMuster
	// SONST suche irgendeine noch nicht leere reihe und nimm steine raus
	public Nim ziehen(NimZug zug) throws NimException {
		if(! isLegalMove(zug)) {
			throw new NimException("not a legal move...");
		}
		// reihen[index] aktualisieren
		// ggf restReihen dekrementieren
		// bitMuster aktualisieren		
		int index = zug.getIndex();
		int anzahlSteine = zug.getAnzahlSteine();
		if(anzahlSteine == 0) {
			restReihen--;
		}
        // bit Muster aktualisieren
        // zwischenüberlegungen:
		// wie ändert sich bitMuster, wenn eine reihe komplett rausgenommen wird?
		bitMuster ^= reihen[index];
		// wie ändert sich bitMuster, wenn eine reihe hinzugefügt wird?
		bitMuster ^= anzahlSteine;
		
		reihen[index] = anzahlSteine;
		return this;
	}
	
	public NimZug zugVorschlag() throws NimException {
		if(isOver()) {
			throw new NimException("game over...");
		}
		NimZug nimZug = null;
		// wir beginnen mit der suche bei irgendeiner reihe
		// wenn wir bis zum ende nichts gefunden haben, setzen 
		// wir die suche am anfang fort
		int pos = random.nextInt(reihen.length);
		
		if(bitMuster != 0) {   //gewinnstellung
			int highestOneBit = Integer.highestOneBit(bitMuster);
			for(; (highestOneBit & reihen[pos]) == 0; pos = (pos + 1) % reihen.length)
				;
			nimZug = new NimZug(pos, reihen[pos] ^ bitMuster);
		}
		else { // verluststellung
			for (; reihen[pos] == 0; pos = (pos+1)% reihen.length)
				;
			nimZug = new NimZug(pos, random.nextInt(reihen[pos]));
		}
		return nimZug;
	}
	
	public boolean isOver() {
		return restReihen == 0;
	}
	
	public boolean isLegalMove(NimZug zug) {
		int index = zug.getIndex();
		int anzahlSteine = zug.getAnzahlSteine();
		return index >= 0 && index < reihen.length && anzahlSteine >=0 
				&& anzahlSteine < reihen[index];
	}

	@Override
	public String toString() {
		return Arrays.toString(reihen);
	}
	
	

}
