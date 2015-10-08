package wbs.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseMetaDataDemo {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/?useUnicode=yes&characterEncoding=UTF-8";
		String user = "root";
		String password = "";
		ResultSet resultSet;
		
		// nachteile von DriverManager
		// performance: erzeugung / zerstörung von connections
		// zugriffsparameter: aufwändige verteilung, sicherheitsbedenken
		// update / austausch der treiberbibliotheken
		// delegierung des transaktionshaendlings schwierig / unmöglich
		
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			DatabaseMetaData meta = conn.getMetaData();
			System.out.println(meta.getDatabaseProductName());
			System.out.println(meta.getDatabaseProductVersion());
			System.out.println(meta.getDriverMajorVersion());
			System.out.println(meta.getDriverMinorVersion());
			System.out.println(meta.getURL());
			System.out.println("-----------------");
			resultSet = meta.getCatalogs();
			while (resultSet.next()) {
				for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
					System.out.println(resultSet.getMetaData().getColumnName(i)
							+ " -> " + resultSet.getObject(i));
				}
			}
			resultSet.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
