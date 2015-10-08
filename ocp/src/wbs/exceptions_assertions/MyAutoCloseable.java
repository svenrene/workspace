package wbs.exceptions_assertions;

import java.io.IOException;

class MyAutocloseable implements AutoCloseable {
	private String name;

	public MyAutocloseable(String name, boolean throwExc) throws Exception {
		this.name = name;
		System.out.println("constructor..." + name);
		if (throwExc) {
			throw new Exception("exception from constructor in " + name);
		}
	}

	public String getName() {
		return name;
	}

	@Override
	public void close() throws Exception {
		System.out.println("closing " + name);
		throw new IOException("exception from close() in " + name);
	}
}