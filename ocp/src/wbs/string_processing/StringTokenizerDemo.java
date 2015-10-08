package wbs.string_processing;

import java.util.Arrays;
import java.util.StringTokenizer;

public class StringTokenizerDemo {
	public static void main(String[] args) {
		String s1 = "a1b25345678c3323d4e51";
		String delim1 = "12345";
		StringTokenizer st1 = new StringTokenizer(s1, delim1);
		while (st1.hasMoreElements()) {
			System.out.println(st1.nextToken());
		}
		System.out.println("----------");
		String s2 = "a b  c   d     e     ";
		StringTokenizer st2 = new StringTokenizer(s2);
		while (st2.hasMoreElements()) {
			System.out.println("[" + st2.nextToken() + "]");
		}
		// äquivalenter ausdruck mit split()
		System.out.println(Arrays.toString(s2.split("\\s+")));
	}
}