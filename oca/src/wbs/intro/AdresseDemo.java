package wbs.intro;

public class AdresseDemo {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		// wir erzeugen eine instanz der klasse Adresse unter verwendung des
		// parameterlosen konstruktors dieser klasse und legen die referenz auf das
		// neu erzeugte objekt in der lokalen variablen a1 (objekt vom typ Adresse) 
		// der methode main() ab
		
		Adresse a1 = new Adresse();

		// wir setzen die feldwerte
		
		a1.setName("meier");
		a1.setOrt("mannheim");
		a1.setPlz(73000);
		a1.setStrasse("waldweg 3");
		
		// wir geben die feldwerte aus
		
		System.out.println(a1.getName());
		System.out.println(a1.getOrt());
		System.out.println(a1.getPlz());
		System.out.println(a1.getStrasse());
		
		
		// aufgerufen wird hier die println()- methode, die als parametertyp
		// Object deklariert
		
		// implizit wird hier die methode toString() für a1 aufgerufen
		// die klasse Adresse hat diese methode von der klasse Object geerbt
		System.out.println(a1);
	
		// wir erzeugen mit dem 2. konstruktor der klasse adresse ein weiteres
		// Adress- object und geben es aus
		
		Adresse a2 = new Adresse("bartel", "bebenhausen", 73162, "t�binger str. 12");
		System.out.println(a2);
		
		// a1 und a2 referenzieren jetzt beide dasselbe objekt
		// das ursprünglich durch a1 referenzierte objekt ist unerreichbar geworden
		// und kandidat für garbage collection
		a1 = a2;
		System.out.println(a1);
		System.out.println(a2);
		
		// hr. bartel heiratet und nimmt den namen seiner frau (fleiner) an
		a1.setName("fleiner");
		System.out.println(a2.getName());
		
		a1.setPlz(-32);
	}

}
