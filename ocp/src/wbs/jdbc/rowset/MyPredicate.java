package wbs.jdbc.rowset;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.Predicate;

public class MyPredicate implements Predicate {
	private double fromPreis;
	private double toPreis;
	private String columnName;

	public MyPredicate(double fromPreis, double toPreis, String columnName) {
		this.fromPreis = fromPreis;
		this.toPreis = toPreis;
		this.columnName = columnName;
	}

	@Override
	public boolean evaluate(RowSet rowSet) {
		boolean result = false;
		double preis;
		try {
			// bug in java se 7
			if (!rowSet.isAfterLast()) {
				try {
					preis = rowSet.getDouble(this.columnName);
					if (preis >= fromPreis && preis <= toPreis) {
						result = true;
					}
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
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

	@Override
	public boolean evaluate(Object value, String columnName)
			throws SQLException {
		// hier nicht benötigt
		// könnte aufgerufen werden von:
		// public boolean evaluate(RowSet rowSet)
		return false;
	}

	public void setFromPreis(double fromPreis) {
		this.fromPreis = fromPreis;
	}

	public void setToPreis(double toPreis) {
		this.toPreis = toPreis;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
}