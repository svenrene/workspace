package wbs.exceptions_assertions;

public class MyAutoCloseableDemo {
	public static void main(String[] args) {
		try (MyAutoCloseable_1 myAutoCloseable_1 = new MyAutoCloseable_1();
				MyAutoCloseable_2 myAutoCloseable_2 = new MyAutoCloseable_2()) {
			myAutoCloseable_1.m();
		} catch (Exception e) {
			System.out.println("exception: " + e.getMessage());
		} finally {
			System.out.println("in finally");
		}
	}
}

class MyAutoCloseable_1 implements AutoCloseable {
	private AutoCloseable autoCloseable;

	public MyAutoCloseable_1() {
	}

	public MyAutoCloseable_1(AutoCloseable autoCloseable) {
		this.autoCloseable = autoCloseable;
	}

	@Override
	public void close() throws Exception {
		if (autoCloseable != null) {
			autoCloseable.close();
		}
		System.out.println("closing myAutoCloseable_1");
	}

	public AutoCloseable getAutoCloseable() {
		return autoCloseable;
	}

	public void m() throws Exception {
		throw new Exception("exception from myAutoCloseable_1");
	}
}

class MyAutoCloseable_2 implements AutoCloseable {
	private AutoCloseable autoCloseable;

	public MyAutoCloseable_2() {
	}

	public MyAutoCloseable_2(AutoCloseable autoCloseable) {
		this.autoCloseable = autoCloseable;
	}

	@Override
	public void close() throws Exception {
		if (autoCloseable != null) {
			autoCloseable.close();
		}
		System.out.println("closing myAutoCloseable_2");
	}

	public AutoCloseable getAutoCloseable() {
		return autoCloseable;
	}

	public void m() throws Exception {
		throw new Exception("exception from myAutoCloesable_2");
	}
}