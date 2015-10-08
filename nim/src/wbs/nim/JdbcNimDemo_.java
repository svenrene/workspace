package wbs.nim;

// wir machen das projekt nim jdbc- fähig

// wir erstellen die datenbank nimdb

// in dieser datenbank legen wir 3 tabellen an (s. nim.sql)

// wir erstellen eine subklasse von UndoableNim namens JdbcNim
// diese subklasse bekommt ein zusätzliches id- feld

// wir erzeugen einige JdbcNim- objekte
// wir zeigen die startstellung an
// und spielen jedes spiel bis zum ende

// wir persistieren alle objekte (mit startstellung und allen zügen)
// in der datenbank

// dann rekonstruieren wir die nim- objekte aus der datenbank

public class JdbcNimDemo_ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
