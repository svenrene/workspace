package wbs.generics_uebungen_1;

import java.util.NavigableSet;
import java.util.TreeSet;

public class A11 {
	public static void main(String[] args) {
		NavigableSet<Integer> set = new TreeSet<>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(10);
		set.subSet(2, 3).add(4);
	}
}