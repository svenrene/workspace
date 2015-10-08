package wbs.patterns.dao;

import java.util.List;

// E	typ der entity (LottoSchein, LottoSpieler,...)
// P	typ des primary key (Integer, Long, String,...)

// komponenten für die geschäftslogik werden referenzen auf dao- objekte
// benötigen, die entsprechenden abhängigkeiten deklarieren (z.b. mit annotations) und
// vom execution environment (application server) beispielsweise durch dependency injection auflösen lassen

// die komponenten für die geschäftslogik deklarieren abhängigkeiten von interfaces, und nicht von
// konkreten klassen, so dass das ideal der losen kopplung gut umgesetzt wird.

// häufig verfährt man nun wie folgt: der entwickler schreibt zum DAO- interface eine implementierende klasse,
// das execution environment generiert zu dieser implementierung einen proxy, und die komponente, die 
// ihre abhängigkeiten deklariert hat, bekommt eine referenz auf den proxy des execution environment injiziert.

// der proxy des execution environment kann in vielfältiger weise rein deklarativ konfiguriert werden,
// diverse optimierungen vornehmen, und in grossem umfang die abwicklung von cross cutting concerns
// (aspekte) übernehmen.

// erreichte design-ziele
// - single responsibility
// - high cohesion
// - separation of concern
// - hohe wiederverwendbarkeit
// - loose coupling

// vermiedene anti-pattern
// - das rad neu erfinden
// - sumu hochzeit
// - god object
// - big ball of mud
// - copy and paste

public interface IGenericDAO<E,P> {
	public void save(E entity);
	public void delete(E entity);
	public void update(E entity);
	public E findById(P primaryKey);
	public List<E> findAll();
}
