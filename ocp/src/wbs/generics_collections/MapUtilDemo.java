package wbs.generics_collections;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.SortedSet;

public class MapUtilDemo {

	// wir testen die klasse MapUtil
	
	public static void main(String[] args) {

		Random rnd = new Random();
		int zahl;
		String zahlAsBinaryString;
		Map<String, Integer> map = new HashMap<>();
		while(map.size()<300) {
			zahl = rnd.nextInt(1000) +1;
			zahlAsBinaryString = Integer.toBinaryString(zahl);
			map.put(zahlAsBinaryString, zahlAsBinaryString.length());
		}
		
		Map<Integer, List<String>> inverted = MapUtil.invert(map);
		
		for(Map.Entry<Integer, List<String>> entry : inverted.entrySet()) {
			System.out.println(entry.getKey()+" -> " +entry.getValue());
		}
		System.out.println("-------------------");
		Comparator<String> cmp = new Comparator<String>(){
			@Override
			public int compare(String s1, String s2) {
				return Integer.compare(Integer.parseInt(s1, 2),
				Integer.parseInt(s2, 2));
			}
		};
		Map<Integer,SortedSet<String>> inverted_2 = MapUtil.invert(map,cmp);
		for(Map.Entry<Integer, SortedSet<String>> entry : inverted_2.entrySet()) {
			System.out.println(entry.getKey()+" -> " +entry.getValue());
		}
		
	}
	


}
