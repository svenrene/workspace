package wbs.exceptions_assertions;

public class SuppressedExceptionDemo {
	public static void main(String[] args) {
		try (MyAutocloseable auto1 = new MyAutocloseable("a1", false);
				MyAutocloseable auto2 = new MyAutocloseable("a2", false);) {
			System.out.println("after opening...");
			throw new IllegalArgumentException("illegal arguments...");
		} catch (Exception e) {
			System.out.println("exception: " + e);
			System.out.println("suppressed exceptions:");
			for (Throwable throwable : e.getSuppressed()) {
				System.out.println(throwable);
			}
		}
	}
}