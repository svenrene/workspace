package wbs.jdbc.misc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AutoCommitDemo {
	
	/*
	 * wir holen eine connection und setzen den autocommit-modus auf false.
	 * 
	 * wir machen einige änderungen oder updates.
	 * 
	 * dann setzen wir den autocommit-modus auf true.
	 * 
	 * werden die änderungen / updates sofort durchgeführt,
	 * oder erst nach einem expliziten commit?
	 * 
	 * explizites commit() ist nicht erforderlich
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
			connection.setAutoCommit(false);
			statement = connection
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			resultSet = statement.executeQuery(sqlSelect);
			resultSet.moveToInsertRow();
			resultSet.updateString(1, "987-3257224405");
			resultSet.updateString(2, "emerson");
			resultSet.updateString(3, "von der schönheit des guten");
			resultSet.updateDouble(4, 9.9);
			resultSet.insertRow();
			connection.setAutoCommit(true);
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
