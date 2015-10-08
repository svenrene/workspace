package wbs.generics_collections;

// O: typ der objekte (schüler, abgeordnete, wahlberechtigte, ...)
// P (property): eigenschaft eines objektes (klasse, fraktion, wahlkreis, ...)

public interface Mapper<O, P> {
	public P map(O o);
}
