package wbs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// user, pass im klartext
// url hart codiert
// sql hart codiert
// * in select- klausel

// keinerlei wiederverwendbarkeit
// wir sind in der db- welt, nicht in der objekt- welt

public class ResultSetDemo {

	/*
	 * wir geben alle records der tabelle buch aus und für jeden record den wert
	 * jeder spalte
	 */

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:mysql://127.0.0.1:3306/books?useUnicode=yes&characterEncoding=UTF-8";
		String user = "root";
		String password = "";

		String sql = "SELECT * FROM Buch";
		
		try (Connection connection = DriverManager.getConnection(url, user,
				password);
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
