package wbs.io;

import java.util.Scanner;

public class ScannerDemo1 {

	public static void main(String[] args) {
		
		String s = "1,a,23,b,345,c,6789,d";
		Scanner scanner = new Scanner(s);
		scanner.useDelimiter(",");
		while(scanner.hasNext()) {
			System.out.println(scanner.next());
		}
		scanner.close();
	}
}
