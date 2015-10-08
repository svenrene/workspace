package wbs.misc;

class A {

	public int setVar(int a, int b, float c) {
		return 1;
	}

	public int setVar(int a, float b, int c) {
		return (int) (a + b + c);
	}

//	public int setVar(int a, float b,  int c) {
//		return this(a,b,c);
//	}
//	
//	public int setVar(int x, int y,  float z) {
//		return x+y;
//	}
//	public float setVar(int a, int b,  float c) {
//		return c*a;
//	}

	 public float setVar(int a) {
		return a;
	}
	
}

public class UeberladenDemo {

	public static void main(String[] args) {

	}

}
