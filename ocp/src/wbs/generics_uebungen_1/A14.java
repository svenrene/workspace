package wbs.generics_uebungen_1;

import java.util.NavigableMap;
import java.util.TreeMap;

public class A14 {
	static Integer i;

	public static void main(String[] args) {
		NavigableMap<Integer, Integer> map = new TreeMap<>();
		map.put(1, i);
		map.put(i, 1);
	}
}