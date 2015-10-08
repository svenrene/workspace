package wbs.jdbc.dao;

import java.util.List;

public class BuchDAODemo {

	public static void main(String[] args) {

		
		IBuchDAO buchDAO = DAOFactory.getBuchDAO();
		List<Buch> buecher;
		Buch buch;
		
		// wir listen alle bücher auf
		buecher = buchDAO.findAll();
		for(Buch myBuch : buecher) {
			System.out.println(myBuch);
		}
		
		// wir erzeugen ein neues buch und speichern es
		buch = new Buch();
		
		buch.setIsbn("978-3458347347");
		buch.setAutor("melvin");
		buch.setTitel("Bartly, der Schreiber: Eine Geschichte aus der Wall Street");
		// buch.setTitel("Bartly, der Schreiber:");
		buch.setPreis(7.0);
		
		// setter aufrufen
		buchDAO.save(buch);
		
		// wir listen erneut alle bücher auf
		buecher = buchDAO.findAll();
		for(Buch myBuch : buecher) {
			System.out.println(myBuch);
		}
		
	}

}
