package wbs.jdbc;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertBooksIntoTableDemo {
	
	public static void main(String[] args) throws Exception {
		
		String url = "jdbc:mysql://127.0.0.1:3306/books?useUnicode=yes&characterEncoding=UTF-8";
		String user = "root";
		String password = "";

		String[] tokens;

		String sql = "INSERT INTO buch(isbn, autor, titel, preis)"
				+ "VALUES(?,?,?,?)";

		String csv = new String(Files.readAllBytes(Paths
				.get("resources/sql/books.txt")));
		
		String[] lines = csv.split(System.lineSeparator());
		
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for (String line : lines) {
				try {
					tokens = line.split(",");
					pstmt.setString(1, tokens[0]);
					pstmt.setString(2, tokens[1]);
					pstmt.setString(3, tokens[2]);
					pstmt.setDouble(4, Double.parseDouble(tokens[3]));
					pstmt.execute();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
