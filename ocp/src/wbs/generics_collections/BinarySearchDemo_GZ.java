package wbs.generics_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BSBase_GZ implements Comparable<BSBase_GZ> {

	private int alter;

	public BSBase_GZ(int alter) {
		this.alter = alter;
		
	}

	@Override
	public int compareTo(BSBase_GZ base) {
		return Integer.compare(alter, base.alter);
	}

	public int getAlter() {
		return alter;
	}

	@Override
	public String toString() {
		return "(" + alter + ")";
	}
}

class BSSub_GZ extends BSBase_GZ {
	public BSSub_GZ(int alter) {
		super(alter);
	}
}

// wir untersuchen, was wir als ergebnis bekommen, wenn
// - der gesuchte schlüssel gefunden wird
// - der gesuchte schlüssel nicht gefunden wird
public class BinarySearchDemo_GZ {

	public static void main(String[] args) {
		BSSub_GZ sub2 = new BSSub_GZ(2);
		BSSub_GZ sub3 = new BSSub_GZ(3);
		BSSub_GZ sub4 = new BSSub_GZ(5);
		BSSub_GZ sub5 = new BSSub_GZ(7);
		BSSub_GZ sub6 = new BSSub_GZ(11);

		List<BSSub_GZ> subs = new ArrayList<>();
		subs.add(sub6);
		subs.add(sub5);
		subs.add(sub4);
		subs.add(sub3);
		subs.add(sub2);

		Collections.sort(subs);

		int pos1 = Collections.binarySearch(subs, new BSSub_GZ(11));
		System.out.println(pos1);

		int pos2 = Collections.binarySearch(subs, new BSSub_GZ(10));
		System.out.println(pos2);

	}
}
