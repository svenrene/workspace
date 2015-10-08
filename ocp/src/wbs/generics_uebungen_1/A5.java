package wbs.generics_uebungen_1;

import java.util.ArrayList;
import java.util.List;

public class A5 {
	public static void main(String[] args) {
		List<? super Integer> li = new ArrayList<>();
		List<Object> lo = new ArrayList<>();
		li = lo;
		li.add(4);
	}
}