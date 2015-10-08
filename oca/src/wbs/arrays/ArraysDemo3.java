package wbs.arrays;

public class ArraysDemo3 {

	public static void main(String[] args) {

		// wie erzeugen ein 10 x 10 int- array, in dem in den beiden
		// hauptdiagonalen
		// eine 1 steht, und in allen anderen feldern eine 0

		int[][] iia = new int[10][10];

		for (int i = 1; i < 10; i++) {

			iia[i][i] = 1;
			iia[i][9 - i] = 1;

		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.printf("%2d", iia[i][j]);
			}
			System.out.println();
		}

	}

}
