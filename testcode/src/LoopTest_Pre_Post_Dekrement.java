
public class LoopTest_Pre_Post_Dekrement {

	public static void main(String[] args) {
		int i = 0;
		do System.out.println(" " + i);
		while(i++<5);

		System.out.println("___");
		System.out.println();
		
		i = 0;
		do System.out.println(" " + i);
		while(++i<5);
	}

}
