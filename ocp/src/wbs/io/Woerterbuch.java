package wbs.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Woerterbuch implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String srcLanguage;
	private String dstLanguage;

	public static final String SRC_DELIMITER = ":";
	public static final String DST_DELIMITER = ";";

	private NavigableMap<String, NavigableSet<String>> dict = new TreeMap<>();

	public Woerterbuch(String srcLanguage, String dstLanguage) {
		this.srcLanguage = srcLanguage;
		this.dstLanguage = dstLanguage;
	}

	// schnittstelle

	// neue wörter eintragen
	public boolean insert(String srcWord, String dstWord, String... dstWords) {
		NavigableSet<String> words = dict.get(srcWord);
		boolean flag1 = false;
		boolean flag2 = false;
		if (words == null) {
			words = new TreeSet<>();
			dict.put(srcWord, words);
		}
		flag1 = words.add(dstWord);
		flag2 = words.addAll(Arrays.asList(dstWords));
		return flag1 || flag2;
	}

	// ohne fehlerhandling...
	public boolean insert(String srcWord, String... dstWords) {
		NavigableSet<String> words = dict.get(srcWord);
		boolean flag = false;
		if (words == null) {
			words = new TreeSet<>();
			dict.put(srcWord, words);
		}
		flag = words.addAll(Arrays.asList(dstWords));
		return flag;
	}

	// einträge löschen

	public boolean delete(String srcWord, String... dstWords) {
		boolean result = false;
		NavigableSet<String> words = dict.get(srcWord);
		if (words != null) {
			if (dstWords.length == 0) {
				dict.remove(srcWord);
				result = true;
			} else {
				result = words.removeAll(Arrays.asList(dstWords));
				if (words.size() == 0) {
					dict.remove(srcWord);
				}
			}
		}
		return result;
	}

	// einträge ändern
	public boolean replace(String srcWord, String dstOld, String dstNew) {
		boolean result = false;
		NavigableSet<String> words = dict.get(srcWord);
		if (words != null && words.contains(dstOld) && !dstOld.equals(dstNew)) {
			words.remove(dstOld);
			words.add(dstNew);
			result = true;
		}
		return result;
	}

	// updates der wörter auf der basis von text-dateien (csv)
	// format der eingabedaten (eingabedaten nach resources/io/characterdata)
	// srcWord:dstWord1;dstWord2;dstWord3
	// bsp.:
	// reden:say;talk
	// gehen:go;walk

	// ohne fehlerhandling...
	// mögliche fehler in den eingabedaten:
	// kein doppelpunkt (SRC_DELIMITER)
	// mehr als ein doppelpunkt (SRC_DELIMITER)
	// srcWord leer
	// leere dstWords
	// leere zeilen
	public boolean updateFromFile(String path) throws IOException {
		int pos;
		String line;
		String srcWord;
		String[] dstWords;
		boolean result = false;
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			while ((line = br.readLine()) != null) {
				pos = line.indexOf(SRC_DELIMITER);
				srcWord = line.substring(0, pos);
				dstWords = line.substring(pos + 1).split(DST_DELIMITER);
				if (insert(srcWord, dstWords)) {
					result = true;
				}
			}
		}
		return result;
	}

	// wir schreiben eine methode, mit der ein wörterbuch so in eine externe
	// datei geschrieben wird, dass es mit der methode updateFromFile() wieder
	// eingelesen werden kann

	public boolean insertOneWord(String srcWord, String dstWord) {
		NavigableSet<String> words = dict.get(srcWord);
		if (words == null) {
			words = new TreeSet<>();
			dict.put(srcWord, words);
		}
		return words.add(dstWord);
	}

	// wir schreiben eine methode zum invertieren eines wörterbuchs.
	// d.h. die ursrüngliche quellsprache wird zur zielsprache und umgekehrt.

	public Woerterbuch invertDict() {
		Woerterbuch inverted = new Woerterbuch(dstLanguage, srcLanguage);
		for (Map.Entry<String, NavigableSet<String>> entry : dict.entrySet()) {
			for (String dstWord : entry.getValue()) {
				inverted.insertOneWord(dstWord, entry.getKey());
			}
		}
		return inverted;
	}

	public NavigableSet<String> get(String srcWord) {
		return dict.get(srcWord);
	}

	// export der wörter in textdateien (csv)
	// wir verwenden einen PrintWriter
	public void extractToFile(String path) throws IOException {
		try (PrintWriter pw = new PrintWriter(path)) {
			int numberOfDstWords;
			int dstWordCounter;
			int lineCounter = 0;
			int numberOfEntries = dict.size();
			for (Map.Entry<String, NavigableSet<String>> entrie : dict
					.entrySet()) {
				pw.print(entrie.getKey());
				pw.print(SRC_DELIMITER);
				numberOfDstWords = entrie.getValue().size();
				dstWordCounter = 1;
				for (String dstWord : entrie.getValue()) {
					pw.print(dstWord);
					if (dstWordCounter < numberOfDstWords) {
						pw.print(DST_DELIMITER);
					}
					dstWordCounter++;
				}
				lineCounter++;
				if (lineCounter < numberOfEntries) {
					pw.println();
				}
			}
			pw.flush();
		}
	}

	public String getSrcLanguage() {
		return srcLanguage;
	}

	public String getDstLanguage() {
		return dstLanguage;
	}

	public Set<String> getSrcWords() {
		return dict.keySet();
	}

	// serialisierung und deserialisierung kompletter wörterbuch-objekte
	public static void serializeWoerterBuch(Woerterbuch woerterbuch, String path)
			throws IOException {
		try (ObjectOutput oos = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(path)))) {
			oos.writeObject(woerterbuch);
		}
	}

	// serialisierung und deserialisierung kompletter wörterbuch-objekte
	public static Woerterbuch deserializeWoerterBuch(String path)
			throws IOException, ClassNotFoundException {
		try (ObjectInput ois = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(path)))) {
			return (Woerterbuch) ois.readObject();
		}
	}
}