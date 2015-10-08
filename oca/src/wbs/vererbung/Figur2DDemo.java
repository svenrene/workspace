package wbs.vererbung;

public class Figur2DDemo {

	public static void main(String[] args) {

		// wir erzeugen einen kreis und geben ihn aus

		// Kreis IS A Figur2D

		// reference-type von figur2d: (immer) Figur2D
		// object-type von figur2d: (jetzt) Kreis

		// kreis
		Figur2D figur2d = new Kreis(1.0);

		System.out.println(figur2d);
		
		// rechteck
		figur2d = new Rechteck(5.0, 5.0);

		System.out.println(figur2d);
		
//		Figur2D figur2d_new = new Kreis(5.0);
//
//		System.out.println(figur2d_new);
		
		
//		// rechteck
//		figur2d = new Dreieck(3.0, 4.0, 5.0);
//
//		System.out.println(figur2d);
		
//		// RETROANALYSE IS FUN !
		try {
			figur2d = new Dreieck(1, 2, 3); // die seiten a, b und c werden übergeben
			System.out.println(figur2d);	// s. wikipedia / dreieck (heron von alexandrien)
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		figur2d = new Dreieck(3, 4, 6);
		System.out.println(figur2d);
		}
	
//		figur2d = new Dreieck(1, 2, 3);
//		System.out.println(figur2d);
		


}
