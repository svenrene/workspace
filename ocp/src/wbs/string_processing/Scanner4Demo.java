package wbs.string_processing;

import java.util.Random;
import java.util.Scanner;

public class Scanner4Demo {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		Random rnd = new Random();
		for (int i = 0; i < 10; i++) {
			sb.append(Math.random() > 0.5 ? rnd.nextBoolean() : rnd
					.nextDouble());
			sb.append(" ");
			if (i % 2 == 0) {
				sb.append("blabla ");
			}
		}
		String source = sb.toString();
		try (Scanner scanner = new Scanner(source)) {
			while (scanner.hasNext()) {
				if (scanner.hasNextDouble()) {
					System.out.println(scanner.nextDouble());
				} else if (scanner.hasNextBoolean()) {
					System.out.println(scanner.nextBoolean());
				} else {
					System.out.println(scanner.next());
				}
			}
		}
	}
}