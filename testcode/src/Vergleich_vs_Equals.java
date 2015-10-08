
public class Vergleich_vs_Equals {

	public static void main(String[] args) {
		
		int i = 5;
		Integer ii = 135;
		Integer ii2 = 135;
		
		//System.out.println(ii==i);
		System.out.println(ii==ii2);
		System.out.println(ii.equals(ii2));

		byte b = 5;
		b += i;
		
	}

}
