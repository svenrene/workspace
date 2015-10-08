package wbs.generics_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Thread11 extends Thread {
	private List<Integer> list;

	public Thread11(List<Integer> list) {
		this.list = list;
	}

	@Override
	public void run() {
		/*
		 * wir schreiben alle ungeraden zahlen zwischen 1 und 1000000 in die
		 * list
		 */
		for (int i = 1; i < 10000000; i += 2) {
			list.add(i);
		}
	}
}

class Thread12 extends Thread {
	private List<Integer> list;

	public Thread12(List<Integer> list) {
		this.list = list;
	}

	@Override
	public void run() {
		/*
		 * wir schreiben alle geraden zahlen zwischen 1 und 1000000 in die list
		 */
		for (int i = 2; i <= 10000000; i += 2) {
			list.add(i);
		}
	}
}

// knackpunkte:
// 1. ArrayList ist nicht thread-safe
// 2. Zugriffe mehrerer Threads auf ein- und dieselbe ArrayList sind deshalb
// problematisch
// 3. Das Problem liegt darin, dass Methoden wie add() nicht atomar sind
// 4. Das Ergebnis eines programmlaufs kann nicht vorhergesagt werden
// (korrektes ergebnis, falsches ergebnis, exceptions(s))
// 5. die klasse Collections liefert viele viele interfaces aus dem
// collections-framework
// threadsichere varianten (mit ziemlich schlechter performance)
// 6. in den concurrent-packages gibt es einige weitere für multithreading
// spezialisierte
// collection-klassen

public class ConcurrentAccessDemo {
	public static void main(String[] args) throws InterruptedException {
		List<Integer> list = Collections
				.synchronizedList(new ArrayList<Integer>());
		// List<Integer> list = new ArrayList<>();
		Thread11 thread11 = new Thread11(list);
		Thread12 thread12 = new Thread12(list);
		thread11.start();
		thread12.start();
		thread11.join();
		thread12.join();
		System.out.println(list.size());
	}
}