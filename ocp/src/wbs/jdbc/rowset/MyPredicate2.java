package wbs.jdbc.rowset;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.Predicate;

public class MyPredicate2 implements Predicate {
	
	private String columnName;

	public MyPredicate2(String columnName) {
		this.columnName = columnName;
	}

	@Override
	public boolean evaluate(RowSet rowSet) {
		boolean result = false;
		try {
			// bug in java se 7
			if (!rowSet.isAfterLast()) {
				switch(this.columnName) {
				case "preis":
					double preis = rowSet.getDouble("preis");
					result = evaluate(Double.valueOf(preis), "preis");
					break;
				case "autor":
					String autor = rowSet.getString("autor");
					result = evaluate(autor, "autor");
					break;
				case "titel":
					String titel = rowSet.getString("titel");
					result = evaluate(titel, "titel");
					break;
				case "isbn":
					String isbn = rowSet.getString("isbn");
					result = evaluate(isbn, "isbn");
					break;
				
				}
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return result;
	}
	
	@Override
	public boolean evaluate(Object value, String columnName)
			throws SQLException {
		boolean result = false;
		switch(columnName) {
		case "preis":
			Double preis = (Double) value;
			result = preis >= 10.0 && preis <= 25.0;
			break;
		case "autor":
			String autor = (String) value;
			result = autor.indexOf('o') >= 0;
			break;
		case "titel":
			String titel = (String) value;
			result = titel.startsWith("t");
			break;
		case "isbn":
			String isbn = (String) value;
			result = isbn.endsWith("1");
			break;
		}
		return result;
	}


	@Override
	public boolean evaluate(Object value, int columnIndex) throws SQLException {
		// hier nicht benötigt
		// könnte aufgerufen werden von:
		// public boolean evaluate(RowSet rowSet)
		return false;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
}