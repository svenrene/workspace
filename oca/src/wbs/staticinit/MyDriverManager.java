package wbs.staticinit;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyDriverManager {

	private static List<IDriver> drivers = new ArrayList<>();

	public static IConnection getConnection(String url) throws SQLException {
		IConnection connection = null;
		// wir fragen die registrierten treiber, ob sie den gegebenen url
		// unterstützen
		for (IDriver driver : drivers) {
			if (driver.acceptsURL(url)) {
				connection = driver.connect(url);
				break;
			}
		}
		if (connection != null) {
			return connection;
		} else {
			throw new SQLException("no suitable driver found");
		}
	}

	public static void registerDriver(IDriver driver) {
		drivers.add(driver);
	}

}
