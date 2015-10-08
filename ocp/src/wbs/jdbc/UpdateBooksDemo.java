package wbs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateBooksDemo {

	// wir erhöhen die preise aller bücher um 10 prozent

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/books?useUnicode=yes&characterEncoding=UTF-8";
		String user = "root";
		String password = "";
		String sqlSelect = "SELECT isbn, preis, autor, titel FROM Buch";
		double preis;
		// ggf try...catch...finally (OHNE try-with-resources)
		try (Connection connection = DriverManager.getConnection(url, user,
				password);
				Statement statement = connection.createStatement(
						ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				ResultSet resultSet = statement.executeQuery(sqlSelect)) {
			while (resultSet.next()) {
				System.out.println(resultSet.getString("autor") + " "
						+ resultSet.getString("titel"));
				preis = resultSet.getDouble(2);
				resultSet.updateDouble(2, preis * 2.0);
				resultSet.updateRow();
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
