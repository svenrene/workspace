package wbs.jdbc.dao;

import java.util.List;

public interface IBuchDAO {

	void save(Buch buch) throws PersistenceException;
	List <Buch> findAll() throws PersistenceException;
	
}
