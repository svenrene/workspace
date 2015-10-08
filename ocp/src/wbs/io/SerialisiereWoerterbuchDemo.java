package wbs.io;

import java.io.IOException;

public class SerialisiereWoerterbuchDemo {
	public static void main(String[] args)  throws IOException, ClassNotFoundException{
		// step 1
		
		// wir erzeugen ein leeres woerterbuch
		// wir importieren eine csv- datei ins woerterbuch
		// wir invertieren das woerterbuch
		// wir serialisieren das invertierte woerterbuch
		
		// step 2
		// wir deserialisieren das invertierte woerterbuch
		// wir exportieren das invertierte woerterbuch in eine csv- datei
		
		String csvIn = "resources/io/characterdata/wb_de_en_pejorativ.txt";
		String serInOutInverted = "resources/io/stream/wb_en_de_pejorativ.ser";
		String csvOutInverted = "resources/io/characterdata/wb_en_de_pejorativ.txt";
		
		Woerterbuch en_de;
		Woerterbuch de_en = new Woerterbuch("de", "en");
		
		// step 1
		de_en.updateFromFile(csvIn);
		en_de = de_en.invertDict();
		Woerterbuch.serializeWoerterBuch(en_de, serInOutInverted);
		
		//step 2
		en_de = null;
		en_de = Woerterbuch.deserializeWoerterBuch(serInOutInverted);
		en_de.extractToFile(csvOutInverted);
		
		
	}
}
