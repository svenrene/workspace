package wbs.generics_collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class SimpleDictDemo {

	public static void main(String[] args) {
		// wir basteln ein einfaches wörterbuch deutsch -> englisch
		// jedem wort der deutschen sprache soll ein wort der englischen sprache
		// entsprechen
		Map<String, String> dict = new HashMap<>();
		
		// wir machen einen eintrag für hund / dog
		dict.put("hund", "dog");
		
		// dito für katze und vogel
		dict.put("katze", "cat");
		dict.put("vogel", "bird");
		
		// wir geben alle schlüssel-wert-paare aus (5 möglichkeiten)
		// 1.
		System.out.println(dict);
		// 2.
		System.out.println(dict.entrySet());
		// 3. iteration über alle keys mit foreach
		for (String s : dict.keySet()) {
			System.out.println(s + " -3> " + dict.get(s));
		}
		// 4. iteration über alle map.entries mit foreach
		for (Map.Entry<String, String> entry : dict.entrySet()) {
			System.out.println(entry.getKey() + " -4> " + entry.getValue());
		}
		// 5. Iteration über alle keys mit einem iterator
		Iterator<String> it1 = dict.keySet().iterator();
		String key;
		while(it1.hasNext()) {
			key = it1.next();
			System.out.println(key + " -5> " + dict.get(key));
		}
		// 6. Iteration über alle map.entries mit einem iterator
		Iterator<Map.Entry<String, String>> it2 = dict.entrySet().iterator();
		Map.Entry<String, String> entry;
		while(it2.hasNext()) {
			entry = it2.next();
			System.out.println(entry.getKey() + " -6> " + entry.getValue());
			
		}

	}

}
