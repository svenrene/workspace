package wbs.arrays;

// import java.util.Arrays;
// import java.util.Random;
import java.util.Stack;

class AddKonstante implements IntFunction {
	private int c;

	public AddKonstante(int c) {
		this.c = c;
	}

	@Override
	public int f(int n) {
		return n + c;
	}

}

class Quadrieren implements IntFunction {

	@Override
	public int f(int n) {
		return n * n;
	}

}

public class IntArraysUtilDemo {

	public static void main(String[] args) {
		
		/*
		 * wir bestücken ein 10-elementiges int-array mit zufallszahlen zwischen
		 * 1 und 100. dann geben wir das array aus, das minimum, und das maximum
		 */

//		int[] ia = new int[10];
//		Random rnd = new Random();
//
//		for (int i = 0; i < ia.length; i++) {
//			ia[i] = rnd.nextInt(100) + 1;
//		}
//
//		System.out.println(Arrays.toString(ia));
//		// System.out.println((ia));
//		System.out.println(IntArraysUtil.min(ia));
//		System.out.println(IntArraysUtil.max(ia));
//
//		System.out.println(IntArraysUtil.hasDups(new int[] { 1, 2, 3, 4 }));
//		System.out.println(IntArraysUtil.hasDups(new int[] { 1, 2, 4, 4 }));
//
//		System.out.println(IntArraysUtil.toString(new int[] {}));
//		System.out.println(IntArraysUtil.toString(new int[] { 5 }));
//		System.out.println(IntArraysUtil.toString(new int[] { 5, 10 }));
//		System.out.println(IntArraysUtil.toString(new int[] { 5, 10, 45 }));
//		
		int[] fibonacci = IntArraysUtil.fibonacci(5);
//		System.out.println(IntArraysUtil.toString(fibonacci));
//		fibonacci = IntArraysUtil.fibonacci(10);
//		System.out.println(IntArraysUtil.toString(fibonacci));
//		fibonacci = IntArraysUtil.fibonacci(15);
//		System.out.println(IntArraysUtil.toString(fibonacci));
		
		System.out.println(IntArraysUtil.toString(IntArraysUtil.operateOnIntArray(fibonacci, "*", 2)));
		

		int[] zahlen = { 1, 2, 3, 4, 5 };

		IntFunction function = new AddKonstante(10);
		IntArraysUtil.operateOnIntArray(zahlen, function);
//		System.out.println(IntArraysUtil.toString(zahlen));

		function = new Quadrieren();
		IntArraysUtil.operateOnIntArray(zahlen, function);
//		System.out.println(IntArraysUtil.toString(zahlen));

		// retroanalyse is fun...
		// addiere 20, dann quadriere, dann addiere 10
		int[] zahlen2 = { 1, 2, 3, 4, 5 };
		IntFunction f0 = new Quadrieren();
		IntFunction f1 = new AddKonstante(10);
		IntFunction f2 = new Quadrieren();
		IntFunction f3 = new AddKonstante(20);
		Stack<IntFunction> functions = new Stack<>();
		functions.push(f0);
		functions.push(f1);
		functions.push(f2);
		functions.push(f3);
		
		IntArraysUtil.operateOnIntArray(zahlen2, functions);
		System.out.println(IntArraysUtil.toString(zahlen2));
	}
}
