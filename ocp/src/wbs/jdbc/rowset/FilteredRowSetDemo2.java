package wbs.jdbc.rowset;

import java.sql.SQLException;

import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class FilteredRowSetDemo2 {
	public static void main(String[] args) {
		try {
			String url = "jdbc:mysql://localhost:3306/books";
			String user = "root";
			String password = "";
			RowSetFactory rowSetFactory;
			FilteredRowSet filteredRowSet;
			String sql = "select isbn, autor, titel, preis from buch";
			MyPredicate2 predicate = new MyPredicate2("preis");
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
			predicate.setColumnName("autor");
			while (filteredRowSet.next()) {
				System.out.println(filteredRowSet.getString("isbn") + " -> "
						+ filteredRowSet.getString("autor"));
			}
			System.out.println("--------");
			
			filteredRowSet.beforeFirst();
			predicate.setColumnName("titel");
			while (filteredRowSet.next()) {
				System.out.println(filteredRowSet.getString("isbn") + " -> "
						+ filteredRowSet.getString("titel"));
			}
			System.out.println("--------");
			
			filteredRowSet.beforeFirst();
			predicate.setColumnName("isbn");
			while (filteredRowSet.next()) {
				System.out.println(filteredRowSet.getString("isbn") + " -> "
						+ filteredRowSet.getString("titel"));
			}
			System.out.println("--------");
			
			filteredRowSet.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
