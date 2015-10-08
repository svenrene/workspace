package wbs.generics_collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

class QuadratZahlenGenerator implements Iterable<Integer>{
	private int anzahl;
	
	public QuadratZahlenGenerator(int anzahl) {
		this.anzahl = anzahl;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			private int i = 1;
			@Override
			public boolean hasNext() {
				return i <= anzahl;
			}

			@Override
			public Integer next() {
				if(! hasNext()) {
					throw new NoSuchElementException("no more elements...");
				}
				int result = i*i;
				i++;
				return result;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException("remove not supported...");
			}
			
		};
	}
	
}

public class MyIterableDemo {

	public static void main(String[] args) {
		QuadratZahlenGenerator generator = new QuadratZahlenGenerator(10);
		// ausgabe: 1 4 9 16 ... 100
		for(Integer i : generator) {
			System.out.println(i);
		}
		
	}

}
