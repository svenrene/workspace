package wbs.generics_collections;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CreatePartitionDemo {

	/*
	 * bsp.: eine stringmenge wird in teilmengen zerlegt derart, dass jede
	 * teilmenge strings derselben länge enthält
	 * 
	 * bsp.: eine integermenge wird in teilmengen zerlegt derart, dass jede
	 * teilmenge zahlen enthält, die bei der division durch 11 denselben rest
	 * enthält.
	 */
	public static void main(String[] args) {
		Set<String> strings = new HashSet<>();
		Random rnd = new Random();
		while (strings.size() < 30) {
			strings.add(Integer.toBinaryString(rnd.nextInt(1000) + 1));
		}
		Set<Set<String>> sPartition = SetUtil.createPartition(strings,
				new Mapper<String, Integer>() {
					@Override
					public Integer map(String s) {
						return s.length();
					}
				});
		for (Set<String> subset : sPartition) {
			System.out.println(subset);
		}
	}

}
