package wbs.staticinit.mysql;

import wbs.staticinit.IConnection;
import wbs.staticinit.IDriver;
import wbs.staticinit.MyDriverManager;

public class MySqlDriver implements IDriver {
	
	static { 
		MyDriverManager.registerDriver(new MySqlDriver());
	}

	@Override
	public IConnection connect(String url) {
		return new MySqlConnection();
	}

	@Override
	public boolean acceptsURL(String url) {
		// eine jdbc-url für mysql beginnen mit jdbc:mysql;
		return url.startsWith("jdbc:mysql");
	}

}
