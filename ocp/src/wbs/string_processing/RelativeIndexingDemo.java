package wbs.string_processing;

public class RelativeIndexingDemo {
	public static void main(String[] args) {
		// verwendung des gewöhnlichen index
		System.out.printf("%s %s %s%n", "a", "b", "c"); // a b c
		// der gewöhnliche index beginnt mit dem 1. formatspezifizierer,
		// der keinen expliziten index verwendet
		System.out.printf("%1$s %s %s%n", "a", "b", "c"); // a a b
		// relative indexierung mit <
		System.out.printf("%s %s %<s%n", "a", "b", "c"); // a b b
	}
}