package wbs.jdbc;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertBooksIntoTableDemo2 {

	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://127.0.0.1:3306/books?useUnicode=yes&characterEncoding=UTF-8";
		String user = "root";
		String password = "";

		String path = "resources/sql/books.txt";

		String sql = "insert into buch(isbn, autor, titel, preis)"
				+ "values(?,?,?,?)";

		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				Scanner scanner = new Scanner(new File(path))) {
			scanner.useDelimiter(",|\n");
			while (scanner.hasNext()) {
				pstmt.setString(1, scanner.next());
				pstmt.setString(2, scanner.next());
				pstmt.setString(3, scanner.next());
				pstmt.setDouble(4, Double.parseDouble(scanner.next()));
				pstmt.execute();

			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
