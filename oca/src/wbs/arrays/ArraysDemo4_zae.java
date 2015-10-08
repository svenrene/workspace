package wbs.arrays;

// wir erzeugen ein zweidimensionales int- array wie folgt
// 1
// 1 2 
// 1 2 3
// 1 2 3 4
// ...
// ...
// 1 2 3 4 5 6 7 8 9 10
public class ArraysDemo4_zae {

	// retroanalyse is fun!
	public static void main(String[] args) {

		int[][] iia = new int[10][];
		int[] zeile;

		for (int i = 0; i < 10; i++) {
			zeile = new int[i + 1];
			for(int j = 0;j < zeile.length;j++) {
				zeile[j] = j + 1;
			}
			iia[i] = zeile;
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < iia[i].length; j++) {
				System.out.printf("%3d", iia[i][j]);
			}
			System.out.println();
		}
	}
}
