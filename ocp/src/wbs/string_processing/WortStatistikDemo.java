package wbs.string_processing;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.concurrent.atomic.AtomicInteger;

import wbs.z_sammelfordelete.WordStatistikUtil;

class WortStatistikComparator implements
		Comparator<Map.Entry<String, AtomicInteger>> {

	@Override
	public int compare(Entry<String, AtomicInteger> e1,
			Entry<String, AtomicInteger> e2) {
		int diff = Integer.compare(e2.getValue().intValue(), e1.getValue()
				.intValue());
		return diff != 0 ? diff : e1.getKey().compareTo(e2.getKey());
	}

}

public class WortStatistikDemo {

	/*
	 * wir erstellen eine csv- datei beliebig viele zeilen in jeder zeile
	 * beliebig viele, durch komma getrennte wörter (java keywords)
	 * 
	 * wir iterieren über alle dateien in einem gegebenen verzeichnis, die eine
	 * bestimmte eigenschaft haben (extension .java)
	 * 
	 * wir erstellen eine statistik, wie oft jedes der wörter insgesamt vorkommt
	 * 
	 * wie geben die statistik aus 1. sortierkriterium ist die häufigkeit (die
	 * häufigsten zuerst) 2. sortierkriterium: alphabetisch
	 * 
	 * der code sollte so geschrieben werden, dass er möglichst allgemein
	 * verwendet werden kann, und ein späteres rekursives durchlaufen von
	 * verzeichnissen leicht integriert werden kann
	 * 
	 * apis: io, text / regex, collections, comparatoren
	 * 
	 * hinweis: die klasse AtomicInteger könnte nützlich sein
	 */
	public static void main(String[] args) throws IOException {

		String dir = "src/wbs/generics_collections";

		String pathToWordsFile = "resources/io/characterdata/java_keyword.txt";

		NavigableMap<String, AtomicInteger> wordMap = WordStatistikUtil
				.initWordMap(pathToWordsFile);

		FileFilter filter = new FileFilter() {
			@Override
			public boolean accept(File file) {
				return file.getName().endsWith(".java");
			}
		};
		
		WortStatistikComparator cmp = new WortStatistikComparator();

		WordStatistikUtil
				.updateWordMapFromFiles(new File(dir), filter, wordMap);

		List<Map.Entry<String, AtomicInteger>> entryList = new ArrayList<>(
				wordMap.entrySet());
		
		Collections.sort(entryList, cmp);
		
		for(Map.Entry<String, AtomicInteger> entry : entryList) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}

	}

}
