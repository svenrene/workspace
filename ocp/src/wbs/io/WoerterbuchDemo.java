package wbs.io;

import java.io.IOException;

public class WoerterbuchDemo {

	public static void main(String[] args) throws IOException {
		String path = "resources/io/characterdata/wb_de_en_pejorativ.txt";
		String pathInverted = "resources/io/characterdata/wb_de_en_pejorativ_inverted.txt";
		Woerterbuch wb = new Woerterbuch("deutsch", "englisch");
		wb.updateFromFile(path);
		for (String srcWord : wb.getSrcWords()) {
			System.out.println(srcWord + " -> " + wb.get(srcWord));
		}
		
		System.out.println();
		System.out.println("---------------invertiert---------------");
		System.out.println();
		
		Woerterbuch inverted = wb.invertDict();
		for(String srcWord : inverted.getSrcWords()) {
			System.out.println(srcWord + " -> " + inverted.get(srcWord));
		}
		
		// wir exportieren das invertierte woerterbuch
		inverted.extractToFile(pathInverted);
	}
}
