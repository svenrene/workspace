package wbs.jdbc.misc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RollbackDemo {

	/*
	 * wir holen eine connection und belassen den autocommit- modus auf true.
	 * 
	 * dann machen wir einige änderungen / updates.
	 * 
	 * dann rufen wir rollback() auf.
	 * 
	 * was passiert?
	 * 
	 * alle änderungen / updates werden durchgeführt, dann kommt eine exception
	 */

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
			//connection.setAutoCommit(false);
			statement = connection
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			resultSet = statement.executeQuery(sqlSelect);
			resultSet.moveToInsertRow();
			resultSet.updateString(1, "987-0321349606");
			resultSet.updateString(2, "goetz");
			resultSet.updateString(3, "java concurrencs in practice");
			resultSet.updateDouble(4, 41.95);
			resultSet.insertRow();
			connection.rollback();
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
