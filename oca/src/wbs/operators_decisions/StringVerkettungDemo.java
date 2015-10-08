package wbs.operators_decisions;

public class StringVerkettungDemo {
	public static void main(String[] args) {
		int n1 = 3;
		char c1 = 'a';
		String s1 = "blabl";
		System.out.println(n1 + c1); // 100
		System.out.println(c1 + n1); // 100
		System.out.println(c1 + s1); // ablabl
		System.out.println(s1 + c1); // blabla
		System.out.println(n1 + s1); // 3blabl
		System.out.println(s1 + n1); // blabl3
		System.out.println(n1 + " " + new Object());
		// 3 java.lang.Object@10b62c9
		System.out.println(new Integer(3) * 3 + s1); // 9blabl
		System.out.println(1 + 2 + "drei"); // 3drei
		System.out.println("eins" + 2 + 3); // eins23
		
	}
}
