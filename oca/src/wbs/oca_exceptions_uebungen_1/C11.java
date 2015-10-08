//package wbs.oca_exceptions_uebungen_1;
//
//class E11 extends Exception {
//}
//
//class E12 extends E11 {
//}
//
//class C110 {
//	void m1() throws E12 {
//	}
//
//	void m2() throws E11 {
//	}
//}
//
//public class C11 {
//	void m() throws E11 {
//		try {
//			new C110().m1();
//		} catch (E11 e) {
//			throw new E12();
//		} finally {
//			System.out.println("aber hoppla!");
//		}
//	}
//
//	public static void main(String[] args) {
//		try {
//			new C11().m();
//			System.out.println("gaga!");
//		} catch (RuntimeException e) {
//			throw new RuntimeException("finis!");
//			System.out.println(e.getMessage());
//		} catch (Throwable t) {
//			System.out.println("nana...");
//		}
//	}
//}