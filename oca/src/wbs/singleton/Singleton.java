package wbs.singleton;

@SuppressWarnings("unused")
public final class Singleton {
	private static final Singleton INSTANCE = new Singleton();
	private int attribute1;
	private int attribute2;

	public static Singleton getInstance() {
		return INSTANCE;
	}

	private Singleton() {
	}

	public void businessMethod1() { /* ... */
	}

	public void businessMethod2() { /* ... */
	}
}
