package wbs.intro;

import java.util.Arrays;

public class SortAdresseDemo {

	
	/*
	 * die anwendung erzeugt einige adress- objekte
	 * 
	 * die referenzen auf die adress- objekte legt sie in einem array ab
	 * 
	 * sie sortiert das array aufsteigend nach dem feld name
	 * 
	 * dann gibt sie jede adresse aus
	 * 
	 * die klasse adresse bekommt nachträglich ein natural ordering (implementiert also Comparable<Adresse>)
	 * 
	 * wir nutzen aus, dass das feld name den typ String hat, und die klasse String ein natural ordering hat
	 */
	
	public static void main(String[] args) {

		Adresse a1 = new Adresse("emil", "apfelstadt", 13162, "herbertstr. 12");
		Adresse a2 = new Adresse("dieter", "berlin", 83162, "waldweg 100");
		Adresse a3 = new Adresse("christian", "coburg", 23162, "weihnachtsallee 24");
		Adresse a4 = new Adresse("berta", "duisburg", 43162, "t�binger str. 12");
		Adresse a5 = new Adresse("achim", "altenburg", 71162, "am kaisersteg 66");
		
		Adresse[] adressen = {a1, a2, a3, a4, a5};
		
		Arrays.sort(adressen);
		
		for(Adresse adresse : adressen){
		System.out.println(adresse);
		}
	}

}
