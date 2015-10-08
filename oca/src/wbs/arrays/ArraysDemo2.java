package wbs.arrays;

public class ArraysDemo2 {

	public static void main(String[] args) {

		/*
		 * wir bestücken ein zweidimensiones int- array mit dem kleinen
		 * einmaleins und geben es aus
		 * 
		 * 1 2 3 4 5 6 7 8 9 10 2 4 6 8 10 12 14 16 18 20 ... ... 10 20 30 40 50
		 * 60 70 80 90 100
		 */

		int[][] iia = new int[10][10];

		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				iia[i - 1][j - 1] = i * j;
			}
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.printf("%4d", iia[i][j]);
			}
			System.out.println();
		}

	}

}
