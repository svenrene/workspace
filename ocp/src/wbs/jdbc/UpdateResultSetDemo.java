package wbs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateResultSetDemo {
	
	/*
	 * unter verwendung eines resultsets erhöhen wie die preis aller bücher,
	 * deren bisheriger preis unter 10 euro liegt, um 20 prozent
	 */
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://127.0.0.1:3306/books?useUnicode=yes&characterEncoding=UTF-8";
		String user = "root";
		String password = "";
		String sqlSelect = "SELECT isbn, preis FROM Buch where preis < 10.0";

		double neuerPreis;

		try (Connection connection = DriverManager.getConnection(url, user,
				password);
				Statement statement = connection.createStatement(
						ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				ResultSet resultSet = statement.executeQuery(sqlSelect)) {
			while (resultSet.next()) {
				neuerPreis = resultSet.getDouble("preis") * 1.2;
				resultSet.updateDouble(2, neuerPreis);
				resultSet.updateRow();
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}