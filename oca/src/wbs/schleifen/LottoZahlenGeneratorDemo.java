package wbs.schleifen;

import java.util.Iterator;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class LottoZahlenGeneratorDemo {

	public static void main(String[] args) {

		LottoZahlenGenerator generator = new LottoZahlenGenerator();
		for (int zahl : generator) {
			System.out.println(zahl);
		}
		System.out.println("------------");
		generator.reset();
		for (int zahl : generator) {
			System.out.println(zahl);
		}
	}
}

class LottoZahlenGenerator implements Iterable<Integer> {

	private SortedSet<Integer> zahlen = new TreeSet<>();
	private Random rnd = new Random();

	public LottoZahlenGenerator() {

	}

	@Override
	public Iterator<Integer> iterator() {
		return zahlen.iterator();
	}

	public void reset() {
		zahlen.clear();
		generateZahlen();
	}

	private void generateZahlen() {
		while (zahlen.size() < 6) {

			zahlen.add(rnd.nextInt(49) + 1);
		}
	}

}