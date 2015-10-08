package wbs.generics_collections;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

// die klasse SimpleBruch bekommt kein natural ordering
class SimpleBruch {
	int zaehler;
	int nenner;
	// konstruktoren
	// toString()
	public SimpleBruch(int zaehler, int nenner){
		this.zaehler = zaehler;
		this.nenner = nenner;
	}
	@Override
	public String toString(){
		return zaehler + "/" + nenner;
	}
}

class SimpleBruchComparator implements Comparator<SimpleBruch> {
	
	@Override
	public int compare(SimpleBruch b1, SimpleBruch b2) {
		double d1 = (double) b1.zaehler / b1.nenner;
		double d2  = (double) b2.zaehler / b2.nenner;
		double diff = d1-d2;
		return diff < 0 ? -1 : diff > 0 ? 1:0;
	
	}
}

public class SortSimpleBruchDemo {

	// wir bestücken eine List mit einigen SimpleBruch- objekten
	// wir sortieren die list aufsteigend unter verwendung eines comparators
	// und geben die list dann aus.
	public static void main(String[] args) {
		List<SimpleBruch> brueche = new ArrayList<>();
		brueche.add(new SimpleBruch(1, 2));
		brueche.add(new SimpleBruch(1, 3));
		brueche.add(new SimpleBruch(1, 4));
		Collections.sort(brueche, new SimpleBruchComparator());
		System.out.println(brueche);
	}

}
