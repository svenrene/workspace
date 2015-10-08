package wbs.generics_uebungen_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class A4 {
	public static void main(String[] args) {
		List<? extends CharSequence> al = new ArrayList<>();
		List<String> ls = new LinkedList<>();
		ls.add("abc");
		al = ls;
		CharSequence cs = al.get(0);
		System.out.println(cs.length());
	}
}