package wbs.intro;

public class StringDemo {
	
	// zählungen beginnen in java meistens bei 0
	
	// intervalle sind in java meistens links-inklusiv und rechts-exklusiv

	public static void main(String[] args) {
		String s = "abrakadabra";
		
		// wir geben aus:
		
		// das erste zeichen von s
		System.out.println(s.substring(0, 1));

		// das letzte zeichen von s
		System.out.println(s.charAt(s.length() - 1));
		
		// die länge von s
		System.out.println(s.length());
		
		// alles bis zum 4. zeichen
		System.out.println(s.substring(0, 4));
		
		// alles ab dem 4. zeichen
		System.out.println(s.substring(4));
		
		// alles zwischen dem 3. und dem 6. zeichen
		System.out.println(s.substring(3, 6));
		
		// die position des letzten 'r'
		System.out.println(s.indexOf('r'));
		
		// die position des letzten 'r'
		System.out.println(s.lastIndexOf('r'));

	}

}
