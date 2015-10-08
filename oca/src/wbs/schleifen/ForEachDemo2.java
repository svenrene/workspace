package wbs.schleifen;

import java.util.ArrayList;

public class ForEachDemo2 {

	public static void main(String[] args) {

		// wir bestücken eine ArrayList mit einigen Strings
		// und geben dann alle elemente mit foreach aus

		ArrayList<String> al1 = new ArrayList<>();

		String s1 = "anna";
		String s2 = "zoroaster";
		String s3 = "ich bin ein string";

		al1.add(s1);
		al1.add(s2);
		al1.add(s3);

		for (String s : al1) {
			System.out.println(s);
		}

		System.out.println("--------------");

		// wir legen in einer ArrayList die zahlen von 1 bis 10 ab
		// und geben dann die elemente unter verwendung von foreach aus

		ArrayList<Integer> al2 = new ArrayList<>();

		for (int i = 1; i <= 10; i++) {
			al2.add(Integer.valueOf(i)); // autoboxing
		}

		for (Integer i : al2) {
			System.out.println(i);
		}
		
	}

}
