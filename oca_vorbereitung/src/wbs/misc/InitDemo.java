package wbs.misc;

public class InitDemo {

	private int n;
	{
		System.out.println("elementinitialisierer 1");
		n = 1;
	}

	static {
		System.out.println("statischer initialisierer 1");
	}

	{
		System.out.println("elementinitialisierer 2");
		n++;
	}

	public InitDemo() {
		System.out.println("InitDemo()");
		n++;
	}

	static int einevariable = 5;

	public static void main(String[] args) {
		InitDemo demo = new InitDemo();
		System.out.println(demo.n);
	}

	static {
		System.out.println("statischer initialisierer 2 " + "wert der variablen: " + einevariable);
	}

}