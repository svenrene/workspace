package oca_basic_data_types_uebungen_1;

public class StringDemo {
	public static void main(String[] args) {
		String s1 = "abc,def";
		int pos = s1.indexOf(',');
		System.out.println(pos);
		System.out.println(s1.substring(pos));
		System.out.println(s1.substring(pos, pos + 1));
		try {
			System.out.println(s1.substring(pos, 1));
		} catch (IndexOutOfBoundsException e) {
			System.out.println("nana");
		}
		System.out.println(s1.split(",")[0]);
	}
}
