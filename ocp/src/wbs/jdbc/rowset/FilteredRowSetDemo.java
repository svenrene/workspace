package wbs.jdbc.rowset;

import java.sql.SQLException;

import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class FilteredRowSetDemo {
	public static void main(String[] args) {
		try {
			String url = "jdbc:mysql://localhost:3306/books";
			String user = "root";
			String password = "";
			RowSetFactory rowSetFactory;
			FilteredRowSet filteredRowSet;
			double fromPreis = 1.0;
			double toPreis = 10.0;
			String sql = "select isbn, autor, titel, preis from buch";
			MyPredicate predicate = new MyPredicate(fromPreis, toPreis, "preis");
			rowSetFactory = RowSetProvider.newFactory();
			filteredRowSet = rowSetFactory.createFilteredRowSet();
			filteredRowSet.setUrl(url);
			filteredRowSet.setUsername(user);
			filteredRowSet.setPassword(password);
			filteredRowSet.setFilter(predicate);
			filteredRowSet.setCommand(sql);
			filteredRowSet.execute();
			while (filteredRowSet.next()) {
				System.out.println(filteredRowSet.getString("isbn") + " -> "
						+ filteredRowSet.getDouble("preis"));
			}
			System.out.println("--------");
			filteredRowSet.beforeFirst();
			predicate.setFromPreis(9.0);
			predicate.setToPreis(50.0);
			while (filteredRowSet.next()) {
				System.out.println(filteredRowSet.getString("isbn") + " -> "
						+ filteredRowSet.getDouble("preis"));
			}
			filteredRowSet.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
