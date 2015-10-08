package wbs.generics_collections;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RepraesentantenDemo2_GZ {

	/*
	 * wir bestücken ein set mit 1000 zufallszahlen zwischen 1 und 1_000_000.
	 * 
	 * für jede anzahl von einserbits geben wir die höchste zahl der menge aus,
	 * die diese anzahl von einserbits hat
	 */

	public static void main(String[] args) {
		Random rnd = new Random();
		Set<Integer> grundMenge = new HashSet<>();
		Set<Integer> repraesentanten;
		Mapper<Integer, Integer> mapper = new Mapper<Integer, Integer>() {
			@Override
			public Integer map(Integer i) {
				return Integer.bitCount(i);
			}
		};
		Comparator<Integer> cmp = new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return i1.compareTo(i2);
			}
		};
		while (grundMenge.size() < 1000) {
			grundMenge.add(rnd.nextInt(1_000_000) + 1);
		}
		repraesentanten = SetUtil.repraesentanten(grundMenge, mapper, cmp);
		for (Integer i : repraesentanten) {
			System.out.println(i + "(" + Integer.toBinaryString(i) + ")"
					+ " -> " + Integer.bitCount(i));
		}

	}

}
