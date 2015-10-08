//package wbs.generics_uebungen_1;
//
//import java.util.ArrayList;
//
//public class A02 {
//	public static void main(String[] args) {
//		ArrayList<? super Number> al = new ArrayList<>();
//		ArrayList<Integer> ai = new ArrayList<>();
//		al = ai;
//		al.add(1L);
//	}
//}