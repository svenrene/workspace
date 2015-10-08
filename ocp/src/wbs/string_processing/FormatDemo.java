package wbs.string_processing;

import java.util.IllegalFormatConversionException;
import java.util.MissingFormatWidthException;

public class FormatDemo {
	public static void main(String[] args) {
		float f = 1.23456789f;
		// default- anzahl nachkommastellen: 6
		System.out.printf("%f%n", f);
		// immer vorzeichen, 2 nachkommastellen, rechtsbündig
		System.out.printf("%+10.2f%n", f);
		// vorzeichen bei bedarf, 4 nachkommastellen, rechtsbündig
		System.out.printf("%10.4f%n", f);
		// vorzeichen bei bedarf, 4 nachkommastellen, linkssbündig
		System.out.printf("%-10.4f%n", f);
		// vorzeichen bei bedarf, 4 nachkommastellen, rechtsbündig,
		// links mit nullen auffüllen
		System.out.printf("%010.4f%n", f);
		// %b
		// null -> false
		// boolean oder Boolean -> String.valueOf(...)
		// other: true
		System.out.printf("%b%n", 0.0); // true
		System.out.printf("%b%n", null); // false + warning
		System.out.printf("%b%n", (Object) null); // false
		try {
			System.out.printf("%+0d", 12345);
		} catch (MissingFormatWidthException e) {
			System.out.println("exception: " + e.getMessage());
		}
		System.out.printf("%+010d%n", 123);
		try {
			System.out.printf("%f%n", 12345);
		} catch (IllegalFormatConversionException e) {
			System.out.println("exception: " + e.getMessage()); //
		}
	}
}