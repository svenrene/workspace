package wbs.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ResultSetDemo2 {

	/*
	 * wir geben alle records der tabelle buch aus und für jeden record den wert
	 * jeder spalte
	 */

	public static void main(String[] args) throws SQLException{
		
		Driver driver = new com.mysql.jdbc.Driver();
		
		Properties props = new Properties();

		props.setProperty("user", "root");
		props.setProperty("password", "");
		
		String url = "jdbc:mysql://localhost:3306/books";
		// String user = "root";
		// String password = "";

		String sql = "SELECT * FROM Buch";
		
		try (Connection connection = DriverManager.getConnection(url, props);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql)) {
			while (resultSet.next()) {
				System.out.println(resultSet.getString("isbn") + 
						 " -> " + resultSet.getString("autor") + 
						 " -> " + resultSet.getString("titel") + 
						 " -> " + resultSet.getString("preis"));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

	}

}
