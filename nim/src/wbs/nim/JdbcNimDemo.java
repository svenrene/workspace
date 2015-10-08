package wbs.nim;

import java.util.List;

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

public class JdbcNimDemo {

	
	public static void main(String[] args) {
		
		int anzahl = 10;
		
		// subklasse von UndoableNim
		// deklariert ein id- feld
		// deklariert einige hilfsmethoden
		JdbcNim nim;
		
		// dao- interface und dao- deklarierung
		IJdbcNimDAO jdbcNimDAO = new JdbcNimDAOImpl();
		
		System.out.println("...saving");
		
		for(int i = 0;i < anzahl;i++) {
			nim = new JdbcNim();
			// id vergeben...
			System.out.println(nim);
			while(! nim.isOver()) {
				nim.ziehen(nim.zugVorschlag());
			}
			jdbcNimDAO.save(nim);
		}
		
		System.out.println("...restoring");
		
		List<JdbcNim> nims = jdbcNimDAO.findAll();
		
		for(JdbcNim myNim : nims) {
			myNim.reset();
			System.out.println(myNim);
		}
	}

}
