package wbs.jdbc.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DAOHelper {

	private static String user;
	private static String password;
	private static String url;

	// ggf daohelper als singleton implementieren

	static {
		InputStream is = DAOHelper.class.getResourceAsStream("db.properties");
		Properties props = new Properties();
		try {
			props.load(is);
			user = props.getProperty("user");
			password = props.getProperty("password");
			url = props.getProperty("url");
			is.close();
		} catch (IOException e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Connection getConnection() throws PersistenceException {
		try {
			// ggf datasource und connection-pooling verwenden
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new PersistenceException(e);
		}
	}

}
