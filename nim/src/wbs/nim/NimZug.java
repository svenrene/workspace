package wbs.nim;

public class NimZug {

	// wir beginnen indizierung der reihen mit 0
	private int index;

	// anzahl steine ist die anzahl von steinen, die nach dem zug in der reihe
	// bleiben
	private int anzahlSteine;

	public NimZug(int index, int anzahlSteine) {
		this.index = index;
		this.anzahlSteine = anzahlSteine;
	}

	public int getIndex() {
		return index;
	}

	public int getAnzahlSteine() {
		return anzahlSteine;
	}

}
