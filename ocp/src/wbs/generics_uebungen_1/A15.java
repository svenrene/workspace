package wbs.generics_uebungen_1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class A15 {
	static Integer i;

	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, i);
		map.put(i, 1);
		new HashSet<>().add(i);
	}
}