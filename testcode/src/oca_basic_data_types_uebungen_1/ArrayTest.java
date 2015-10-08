package oca_basic_data_types_uebungen_1;

public class ArrayTest {

	public static void main(String[] args) {
		int[] scores = { 1, 2, 3, 4, 5, 6};
        System.arraycopy(scores, 2, scores, 3, 2);
        for(int i :  scores) System.out.print(i);

    	char cA[][] = new char[3][];
    	for(int i=0; i<cA.length; i++) cA[i] = new char[4];
        
	}
	


}
