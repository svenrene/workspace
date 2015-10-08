package wbs.generics_collections;

import java.util.Comparator;
import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Random;
import java.util.Set;

class ModuloMapper implements Mapper<Integer, Integer> {

	private int zahl;

	public ModuloMapper(int zahl) {
		this.zahl = zahl;
	}

	@Override
	public Integer map(Integer i) {
		return i % zahl;
	}

	public void setZahl(int zahl) {
		this.zahl = zahl;

	}

	public int getZahl() {
		return zahl;
	}
}

public class CreateSortedPartitionDemo {

	public static void main(String[] args) {
		Random rnd = new Random();
		Set<Integer> grundMenge = new HashSet<>();
		NavigableSet<NavigableSet<Integer>> sortedPartition;
		Mapper<Integer, Integer> mapper = new ModuloMapper(10);
		Comparator<Integer> cmp = new Comparator<Integer>() {

			@Override
			public int compare(Integer i1, Integer i2) {
				return i1.compareTo(i2);
			}
		};
		
		while(grundMenge.size()<100) {
			grundMenge.add(rnd.nextInt(1000)+1);
		}
		sortedPartition = SetUtil.createSortedPartition(grundMenge, mapper, cmp);
		
		int summe = 0;
		
		for(NavigableSet<Integer> subset : sortedPartition) {
			System.out.println(subset);
			summe += subset.size();
		}
		System.out.println(summe);
	}

}
