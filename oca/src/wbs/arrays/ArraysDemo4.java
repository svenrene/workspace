package wbs.arrays;

// wir erzeugen ein zweidimensionales int- array wie folgt
// 1
// 1 2
// 1 2 3
// 1 2 3 4
// ...
// ...
// 1 2 3 4 5 6 7 8 9 10

public class ArraysDemo4 {

	public static void main(String[] args) {

		int[][] iia = new int[10][];

		for (int i = 0; i < 10;i++ ) {
			
		//	System.out.println(i);

			iia[i] = new int[i+1];

			for (int j = 0; j < i; j++) {
			
		//		System.out.println("wert i: " + i);
			//	System.out.println("wert j: " + j);

				iia[i][j] = j+1;

			}

		}

		for (int i = 1; i < 10; i++) {
			for (int j = 0; j < i; j++) {
				System.out.printf("%3d", iia[i][j]);
			}
			System.out.println();
		}

	}

}