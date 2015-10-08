package wbs.testcode;

import java.io.FileNotFoundException;
import java.io.IOException;

// statische methoden können nicht überschrieben werden!!!

class A{
	int a= 5;
	String doA() { return "a1";}
	protected static String doA2() { return "a2";}
}
	


public class B extends A {

		int a= 7;
		String doA() { return "b1"; }
		public static String doA2() {return "b2";}
		void go() {
			A myA = new B();
			System.out.println(myA.doA() + " " + myA.doA2() + " " + myA.a);
		}
		public static void main(String[] args) {
			new B().go();
		//	infected();
	}

//		public static void infected(){
//			System.out.println("before");
//			try {
//				//int i = 10/0;
//				System.out.println("try ");
//			} catch(Exception e) {
//				System.out.println("catch ");
//				throw e;
////			} finally {
////				System.out.println("finally ");
//			}
//			System.out.println("after ");
//		}
		
}
