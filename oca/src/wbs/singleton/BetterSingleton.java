package wbs.singleton;

public class BetterSingleton {

	private static BetterSingleton INSTANCE = null;

	public static synchronized BetterSingleton getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new BetterSingleton();
		}
		return INSTANCE;
	}
}