package wbs.nim;

// RETROANALYSE IS FUN :)
// wir verwenden einen Stack für die spielzüge
// UndoableNim ist subklasse von Nim
// die subklasse definiert 2 neue methoden: undo() und reset()
// die subklasse überschreibt die methode ziehen()
public class UndoableNimDemo {

	public static void main(String[] args) {
		UndoableNim nim = new UndoableNim(new int[] { 1, 2, 3, 4, 5 });
		System.out.println(nim + " ausgangsstellung");
		System.out.println(nim.ziehen(nim.zugVorschlag()) + " nach dem 1. zug");
		System.out.println(nim.ziehen(nim.zugVorschlag()) + " nach dem 2. zug");
		System.out.println(nim.ziehen(nim.zugVorschlag()) + " nach dem 3. zug");
		System.out.println(nim.ziehen(nim.zugVorschlag()) + " nach dem 4. zug");
		// wir nehmen die letzten beiden zuege zurück
		nim.undo(3);
		// ... und sind wieder bei der ausgangsstellung :)
		System.out.println(nim + " nach der rücknahme der letzten beiden züge");

		// wir spielen bis zum ende
		while (!nim.isOver()) {
			System.out.println(nim + " spielend");
			nim.ziehen(nim.zugVorschlag());
		}
		System.out.println(nim + " spielende");
		// ... und nehmen alle züge zurück
		nim.reset();
		// ... und sind wieder bei der ausgangsstellung :)
		System.out.println(nim + " nach reset()");
	}
}
