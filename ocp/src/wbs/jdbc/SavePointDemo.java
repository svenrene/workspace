package wbs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

public class SavePointDemo {

	/*
	 * wir setzen autocommit auf false
	 * 
	 * wir fügen einige records in die tabelle buch ein
	 * 
	 * einige dieser inserts werden unter verwendung eines savepoints
	 * annuliert
	 * 
	 * anschliessend erfolgt ein commit
	 */
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/books?useUnicode=yes&characterEncoding=UTF-8";
		String user = "root";
		String password = "";
		String sql = "insert into buch( isbn, autor, titel, preis)"
				+ "values(?,?,?,?)";

		// ggf try...catch...finally (OHNE try-with-resources)
		
		@SuppressWarnings("unused")
		Savepoint sp1;
		Savepoint sp2;
		@SuppressWarnings("unused")
		Savepoint sp3;
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			sp1 = conn.setSavepoint();
			pstmt.setString(1,  "987-0071772006");
			pstmt.setString(2,  "sierra");
			pstmt.setString(3,  "OCA/OCP Java SE 7 Programmer");
			pstmt.setDouble(4,  29.74);
			pstmt.execute();
			
			sp2 = conn.setSavepoint();
			pstmt.setString(1,  "987-3896706461");
			pstmt.setString(2,  "heinz von foerster");
			pstmt.setString(3,  "Wahrheit ist die Erfindung eines Lügners");
			pstmt.setDouble(4,  19.95);
			pstmt.execute();
			
			sp3 = conn.setSavepoint("sp3");
			pstmt.setString(1,  "987-1780380766");
			pstmt.setString(2,  "barnes");
			pstmt.setString(3,  "capation beefheart");
			pstmt.setDouble(4,  15.12);
			pstmt.execute();
			
			conn.rollback(sp2);
			
			conn.commit();
			//}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} 

	}
}


