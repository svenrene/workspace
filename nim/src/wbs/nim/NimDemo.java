package wbs.nim;

public class NimDemo {

	/* 
	 * wir erzeugen ein nimobjekt, und spielen bis zum ende,
	 * wobei bei jedem zug ein zugvorschlag ausgeführt wird
	 */
	public static void main(String[] args) {
		Nim nim = new Nim();
		System.out.println(nim);
		while(! nim.isOver()) {
			System.out.println(nim.ziehen(nim.zugVorschlag()));
		}
	}
}
