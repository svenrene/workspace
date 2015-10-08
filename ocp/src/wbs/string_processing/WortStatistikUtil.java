package wbs.string_processing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class WortStatistikUtil {

	public static NavigableMap<String, AtomicInteger> initWordMap(String path)
			throws IOException {
		String line;
		String[] tokens;
		NavigableMap<String, AtomicInteger> wordMap = new TreeMap<>();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			while ((line = br.readLine()) != null) {
				tokens = line.split(",");
				for (String token : tokens) {
					wordMap.put(token, new AtomicInteger());
				}
			}
		}
		return wordMap;
	}

	public static void updateWordMapFromFile(File file,
			NavigableMap<String, AtomicInteger> wordMap) throws IOException {
		String token;
		try (Scanner scanner = new Scanner(file)) {
			scanner.useDelimiter("\\W+");
			while (scanner.hasNext()) {
				token = scanner.next();
				if (token.length() != 0 && wordMap.containsKey(token)) {
					wordMap.get(token).getAndIncrement();
				}
			}
		}
	}

	public static void updateWordMapFromFiles(File dir, FileFilter filter,
			NavigableMap<String, AtomicInteger> wordmap) throws IOException {
		File[] files = dir.listFiles(filter);
		for (File file : files) {
			updateWordMapFromFile(file, wordmap);
		}
	}
}
