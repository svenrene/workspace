package wbs.oca_basic_data_types_uebungen_1;

public class StringDemo2 {
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = s1;
		System.out.println(s1.concat("def"));
		System.out.println(s1);
		s1 = s1.concat("ghi");
		System.out.println(s1);
		System.out.println(s2);
	}
}