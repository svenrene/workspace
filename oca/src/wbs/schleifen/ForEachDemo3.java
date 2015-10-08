package wbs.schleifen;

import java.util.Random;
import java.util.TreeSet;

public class ForEachDemo3 {

	public static void main(String[] args) {

		/*
		 * wir erzeugen 6 verschiedene zufallszahlen zwischen 1 und 49
		 * und geben sie aufsteigend sortiert aus (mit foreach)
		 * 
		 * hinweise:
		 * nützlich sein könnten java.util.TreeSet und java.util.Random
		 */
		
		TreeSet<Integer> lottozahlen = new TreeSet<Integer>();
		
		Random zufallszahl = new Random();
		for(int i = 0; i < 6; ){
			int randomInt = (zufallszahl.nextInt(49)+1);
			if(!lottozahlen.contains(randomInt)) {
			lottozahlen.add(randomInt);
			i++;
			}
		}
		
		// Ausgabe des TreeSets mit ForEach-Schleife
		for(Integer i : lottozahlen) {
			System.out.println(i);
		}

	}

}
