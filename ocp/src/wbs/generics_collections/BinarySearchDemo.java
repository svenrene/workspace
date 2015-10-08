package wbs.generics_collections;

class BSBase implements Comparable<BSBase>{

	@Override
	public int compareTo(BSBase o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

class BSSub extends BSBase{
	
}

public class BinarySearchDemo {

	public static void main(String[] args) {
		// wir bestücken eine List mit einigen referenzen auf BSSub- objekte
		// und rufen dann die binarySearch- methode auf, die ein natural 
		// ordering der listenelemente voraussetzt
		
		// wir untersuchen was wir als ergebnis bekommen, wenn
		// - der gesuchte schlüssel gefunden wird
		// - der gesuchte schlüssel nicht gefunden wird

	}

}
