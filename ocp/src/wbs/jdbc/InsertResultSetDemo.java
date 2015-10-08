package wbs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertResultSetDemo {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://127.0.0.1:3306/books?useUnicode=yes&characterEncoding=UTF-8";
		String user = "root";
		String password = "";
		String sqlSelect = "SELECT isbn, autor, titel, preis FROM Buch";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			connection.setAutoCommit(false);
			statement = connection
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			resultSet = statement.executeQuery(sqlSelect);
			resultSet.moveToInsertRow();
			resultSet.updateString(1, "987-0375713699");
			resultSet.updateString(2, "abram");
			resultSet.updateString(3, "the spell of the sensuous");
			resultSet.updateDouble(4, 16.54);
			resultSet.insertRow();
			connection.commit();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			connection.rollback();
		} finally {
			if (connection != null) {
				// ...
				connection.close();
			}
		}
	}
}