package wbs.exceptions;

import java.util.Scanner;

public class MultiCatchDemo {

	public static void main(String args[]) {

		Scanner scnr = new Scanner(System.in);

		String number = scnr.next();

		try {

			if (number.length() > 5) {
				throw new IllegalArgumentException();
			}
			Integer.parseInt(number);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

}