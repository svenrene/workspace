package wbs.singleton;

@SuppressWarnings("unused")
public final class BadSingleton {
	
	private static BadSingleton INSTANCE = null;
	
	private int attribute1;
	
	private int attribute2;

	// ACHTUNG: SCHLECHT !!!
	public static BadSingleton getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new BadSingleton();
		}
		return INSTANCE;
	}

	private BadSingleton() {
	}

	public void businessMethod1() { /* ... */
	}

	public void businessMethod2() { /* ... */
	}
}
