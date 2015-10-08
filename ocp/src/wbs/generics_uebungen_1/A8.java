package wbs.generics_uebungen_1;

import java.util.LinkedList;
import java.util.List;

public class A8 {
	static <T extends CharSequence> void m(List<T> list) {
	}

	public static void main(String[] args) {
		m(new LinkedList<StringBuffer>());
	}
}