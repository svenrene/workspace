package wbs.generics_uebungen_1;

import java.util.ArrayList;

public class A03 {
	public static void main(String[] args) {
		ArrayList<? super Number> al = new ArrayList<>();
		ArrayList<Object> ao = new ArrayList<>();
		al = ao;
		al.add(1L);
	}
}