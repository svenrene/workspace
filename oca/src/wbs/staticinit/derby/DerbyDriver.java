package wbs.staticinit.derby;

import wbs.staticinit.IConnection;
import wbs.staticinit.IDriver;
import wbs.staticinit.MyDriverManager;

public class DerbyDriver implements IDriver {
	
	static {
		MyDriverManager.registerDriver(new DerbyDriver());
	}

	@Override
	public IConnection connect(String url) {
		return new DerbyConnection();
	}

	@Override
	public boolean acceptsURL(String url) {
		// eine jdbc-url für derby beginnen mit jdbc:derby;
		return url.startsWith("jdbc:derby");
	}

}
