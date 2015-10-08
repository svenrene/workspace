package wbs.generics_collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class MapUtil {
	public static <K, V> Map<V, List<K>> invert(Map<K, V> map) {
		Map<V, List<K>> inverted = new HashMap<V, List<K>>();
		List<K> keyList;
		for (Map.Entry<K, V> entry : map.entrySet()) {
			keyList = inverted.get(entry.getValue());
			if (keyList == null) {
				keyList = new ArrayList<K>();
				inverted.put(entry.getValue(), keyList);
			}
			keyList.add(entry.getKey());
		}
		return inverted;
	}

	public static <K, V extends Comparable<? super V>> SortedMap<V, SortedSet<K>> invert(
			Map<K, V> map, Comparator<? super K> comp) {
		SortedMap<V, SortedSet<K>> inverted = new TreeMap<V, SortedSet<K>>();
		SortedSet<K> keySet;
		for (Map.Entry<K, V> entry : map.entrySet()) {
			keySet = inverted.get(entry.getValue());
			if (keySet == null) {
				keySet = new TreeSet<K>(comp);
				inverted.put(entry.getValue(), keySet);
			}
			keySet.add(entry.getKey());
		}
		return inverted;
	}
	
	/* 
	 * wir schreiben eine methode, die zu zwei gegebenen maps eine dritte map liefert.
	 * bsp.:
	 * map1: bildet spieler auf einen verein ab
	 * map2: bildet vereine auf vereinsvorsitzende ab
	 * ergebnismap: bildet spieler auf vereinsvorsitzende ab
	 * 
	 * bsp.:
	 * map1: bildet abgeordnete auf ihre partei ab
	 * map2: bildet parteien auf ihren parteivorsitzenden ab
	 * map3: bildet abgeordnete auf ihre parteivorsitzende ab
	 * 
	 * ggf exception werfen
	 * 
	 * methodenname: compose()
	 * 
	 */
	
	public static <T1, T2, T3> Map<T1, T3> compose(
			Map<T1, T2> map1, Map<T2, T3> map2) {
		Map<T1, T3> composed = new HashMap<T1,T3>();
		
		T2 t2;
		T3 t3;
		for (Map.Entry<T1, T2> entryMap1 : map1.entrySet()) {

			t2 = entryMap1.getValue();
			t3 = map2.get(t2);
			if (null == t3 ) {
				throw new IllegalArgumentException("no entries in map 2 for: " + t2 +  " result from t3:" + t3);
			}
			composed.put(entryMap1.getKey(), t3);
		}
		return composed;
	}

}