package wbs.schleifen;

import java.util.TreeSet;
import java.util.Set;

public class StringUtilDemo {

	public static void main(String[] args) {

		String s1 = "anna";
		String s2 = "Anna";
		String s3 = "amme";
		
		System.out.println(StringUtil.isPalindrom(s1));
		System.out.println(StringUtil.isPalindrom(s2));
		System.out.println(StringUtil.isPalindrom(s3));

		// Set ist ein Interface. HashSet implementiert Set.
		// Bei einem Set ist garantiert, dass es keine Duplikate gibt.
		// TreeSet sortiert aufsteigend
		
		Set<String> strings = new TreeSet<>();
		
		strings.add("aber");
		strings.add("1496");
		strings.add("turmfalke");
		strings.add("");
		strings.add("a");
		
		System.out.println(StringUtil.isStrictAscending(""));
		
		System.out.println("-------------------");
		// foreach
		for(String s : strings) {
			System.out.println(s + " isStrictAscending: " + StringUtil.isStrictAscending(s));
		}
		
	}

}
