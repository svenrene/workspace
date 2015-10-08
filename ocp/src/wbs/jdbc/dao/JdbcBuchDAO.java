package wbs.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


// bei jdbc ist der entwickler verantwortlich für die transformation von objekten
// in records von tabellen und umgekehrt

//bei jpa ist der jpa- provider verantwortlich für die transformation von objekten
//in records von tabellen und umgekehrt

public class JdbcBuchDAO implements IBuchDAO {

	private final String  sqlInsert = "insert into buch (isbn, autor, titel, preis) "
			+ " values(?,?,?,?)";
	private final String sqlSelectAll = "select isbn, autor, titel, preis "
			+ "from buch";
	
	public JdbcBuchDAO() {
		// TODO Auto-generated constructor stub
	}
	
	
	// die save()- methode macht automatisch ein commit(), was dem grundsatz
	// wiederspricht, das die transaktionsgrenzen von business-prozessen
	// gesetzt werden sollten, aber nicht von dao's
	@Override
	public void save(Buch buch) throws PersistenceException {
		// alternative: IoC / DI
		// das dao holt sich die connection nicht selbst, sondern lässt
		// sich eine referenz auf eine connection vom execution environment
		// einspritzen
		try(Connection conn = DAOHelper.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqlInsert)) {
			pstmt.setString(1, buch.getIsbn());
			pstmt.setString(2, buch.getAutor());
			pstmt.setString(3, buch.getTitel());
			pstmt.setDouble(4, buch.getPreis());
			pstmt.execute();
			
		}
		catch(SQLException e) {
			// e.printStackTrace
			throw new PersistenceException(e);
		}

	}

	@Override
	public List<Buch> findAll() throws PersistenceException {

		String isbn;
		String titel;
		String autor;
		double preis;
		
		List<Buch> buecher = new ArrayList<>();
		
		try(Connection connection = DAOHelper.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sqlSelectAll)) {
			while(resultSet.next()) {
				isbn = resultSet.getString("isbn");
				titel = resultSet.getString("titel");
				autor = resultSet.getString("autor");
				preis = resultSet.getDouble("preis");
				Buch buch = new Buch(isbn, autor, titel, preis);
				buecher.add(buch);
			}
		}
		catch(SQLException e) {
			throw new PersistenceException(e);
		}
		return buecher;
	}

}
