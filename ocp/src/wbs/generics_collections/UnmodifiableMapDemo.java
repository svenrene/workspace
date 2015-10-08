package wbs.generics_collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UnmodifiableMapDemo {

	
	/*
	 * wir bestücken eine map mit einigen schlüssel-wert-paaren
	 * 
	 * zu dieser map holen wir und unter der verwendung der klasse Collections
	 * ein map, die nicht verändert werden kann (aber dieselben schlüssel-wert-paare
	 * enthält).
	 * 
	 * dann rufen wir für die unmodifiable map die methode remove() auf,
	 * und zwar für einen key, der inder map nicht enthalten ist.
	 * 
	 * was passiert?
	 */
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		
		map.put("a", "aa");
		map.put("b", "bb");
		
		Map<String, String> unmodifiableMap = Collections.unmodifiableMap(map);
		
		System.out.println(unmodifiableMap.getClass().getName());
		
		unmodifiableMap.remove("c");

	}

}
