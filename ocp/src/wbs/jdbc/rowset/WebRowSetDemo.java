package wbs.jdbc.rowset;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class WebRowSetDemo {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/books";
		String user = "root";
		String password = "";
		RowSetFactory rowSetFactory;
		WebRowSet webRowSet;
		String sql = "SELECT * FROM buch";
		try (FileWriter fileWriter = new FileWriter("resources/xml/buch.xml")) {
			rowSetFactory = RowSetProvider.newFactory();
			webRowSet = rowSetFactory.createWebRowSet();
			webRowSet.setUrl(url);
			webRowSet.setUsername(user);
			webRowSet.setPassword(password);
			webRowSet.setCommand(sql);
			webRowSet.execute();
			webRowSet.writeXml(fileWriter);
			webRowSet.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}