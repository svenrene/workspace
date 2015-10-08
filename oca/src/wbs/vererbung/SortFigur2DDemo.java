package wbs.vererbung;

import java.util.Arrays;

public class SortFigur2DDemo {

	public static void main(String[] args) {

		Kreis k1 = new Kreis(2.0);
		Kreis k2 = new Kreis(4.0);
		Kreis k3 = new Kreis(1.0);
		
		Rechteck r1 = new Rechteck(2, 3);
		Rechteck r2 = new Rechteck(1, 3);
		
		Dreieck d1 = new Dreieck(3, 4, 5);
	
		// wir legen die referenzen auf die Figur2D- objekte in einem array ab
		
		Figur2D[] figuren = { k1, k2, k3, r1, r2, d1 };
		
		// wir sortieren das array
		Arrays.sort(figuren);
		
		// wir geben element für element aus
		for(Figur2D figur2d : figuren) {
			System.out.println(figur2d);
		}
	}

}
