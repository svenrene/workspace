package oca_enthuware.using_loop_constructs;

public class C3 {

	public static void main(String[] args) {
		int i = 0;
		int j = 0;
		int k = 0;
//		while (i < 5) {
//			i++;
//			j++;
//			if (i == 3)
//				continue;
//			System.out.println("i :" + i + " j: " + j);
//		}
		for(;i<5;i++){
			j++;
			System.out.println("i :" + i + " j: " + j+ " k: " + k);
			if(i==3) continue;
			k++;
		}
			
	}
}
