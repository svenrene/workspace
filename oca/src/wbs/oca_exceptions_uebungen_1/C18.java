//package wbs.oca_exceptions_uebungen_1;
//
//public class C18 {
//	public static void m() {
//		try {
//			System.out.println("abc".charAt(100));
//		} catch (IndexOutOfBoundsException e1) {
//			try {
//				System.out.println("abc".charAt(100));
//			} catch (RuntimeException e2) {
//				throw new IllegalArgumentException();
//			} finally {
//				throw new IndexOutOfBoundsException();
//			}
//		} catch (RuntimeException e) {
//			System.out.println("out of bounds...");
//		}
//	}
//
//	public static void main(String[] args) {
//		m();
//	}
//}