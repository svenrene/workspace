package wbs.jdbc.misc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClosedStatementDemo {

	/*
	 * was passiert, wenn auf eine ResultSet zugegriffen wird, und das statement,
	 * durch das es erzeugt wurde, bereits geschlossen ist?
	 * 
	 * SQLException
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
			statement.close();
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
