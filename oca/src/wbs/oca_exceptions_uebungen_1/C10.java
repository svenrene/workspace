//package wbs.oca_exceptions_uebungen_1;
//
//public class C10 {
//	static void m() {
//		try {
//			System.out.println("abc".charAt('d'));
//		} finally {
//			try {
//				System.out.println("abc".charAt('d'));
//			} catch (Throwable t) {
//				throw new RuntimeException();
//			} finally {
//				System.out.println("abc".charAt(2));
//			}
//		}
//	}
//
//	public static void main(String[] args) {
//		m();
//	}
//}