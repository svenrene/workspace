package wbs.generics_collections;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class SetUtil {

	/*
	 * wir schreiben eine methode, die zu einem gegebenen set ein subset
	 * liefert, dessen elemente alle eine bestimmte eigenschaft haben.
	 * 
	 * bsp.: alle strings einer stringmenge mit einer gegebenen länge bsp.: alle
	 * integer einer integermenge mit gegebener quersumme bsp.: alle
	 * angestellten eines unternehmens mit einer betriebszugehörigkeit von
	 * mindestens 10 jahren
	 */
	public static <T> Set<T> select(Set<T> set, Filter<T> selector) {
		Set<T> result = new HashSet<>();
		for (T t : set) {
			if (selector.accepts(t)) {
				result.add(t);
			}
		}
		return result;
	}

	/*
	 * eine partnervermittlung möchte alle paare von partnersuchenden auflisten,
	 * die zueinander passen
	 * 
	 * ein stellenvermittler möchte alle paare von stellenangeboten und
	 * stellensuchenden zusammenstellen, bei denen das stellenangebot zum
	 * stellensuchenden passt
	 */
	public static <T1, T2> Set<Dupel<T1, T2>> createDuples(Set<T1> set1,
			Set<T2> set2, Matcher<T1, T2> matcher) {
		Set<Dupel<T1, T2>> result = new HashSet<>();
		for (T1 t1 : set1) {
			for (T2 t2 : set2) {
				if (matcher.matches(t1, t2)) {
					result.add(new Dupel<>(t1, t2));
				}
			}
		}
		return result;
	}

	/*
	 * aus allen klassen einer schule soll jeweils genaus ein schüler ausgewählt
	 * werden. aus allen fraktionen im bundestag soll jeweils genau ein
	 * abgeordneter ausgewählt werden. aus allen wahlkreisen eines bundeslandes
	 * soll jeweils genau ein wahlberechtigter ausgewählt werden.
	 * 
	 * wir haben eine grundmenge (Set) diese grundmenge kann zerlegt werden in
	 * paarweise disjunkte teilmengen jedes element der grundmenge kann auf eine
	 * dieser teilmengen abgebildet werden
	 * 
	 * fachbegriff: partition (eine menge wird zerlegt in paarweise disjunkte
	 * teilmengen, deren vereinigung die grundmenge ergibt)
	 * 
	 * jedes element der grundgesamtheit (schüler, wahlberechtigte, ...) kann
	 * auf eine eigenschaft abgebildet werden (klasse, fraktion, ...)
	 * 
	 * methodenname: repraesentanten()
	 */

	public static <O, P> Set<O> repraesentanten(Set<O> grundmenge,
			Mapper<O, P> mapper) {
		Set<O> result = new HashSet<>();

		// wir bauen eine map auf
		// key-type: P value-type: O
		Map<P, O> map = new HashMap<>();
		P property;
		// wir iterieren über alle elemente der grundmenge
		for (O o : grundmenge) {
			// wir ermitteln die eigenschaft des aktuellen objektes
			property = mapper.map(o);
			// wir prüfen, ob die aktuelle property schon key in der map ist
			// falls nein, fügen wir ein neues key-value-pair in die map ein
			if (!map.containsKey(property)) {
				map.put(property, o);
			}
		}
		result.addAll(map.values());
		return result;
	}

	// wir ueberladen die methode repraesentanten().
	// wir waehlen jetzt nicht irgendeinen schueler, sondern den besten
	// wir waehlen jetzt nicht irgendeinen abgeordneten, sonder den abgeordneten
	// mit der laengsten parlamentszugehoerigkeit
	// wir waehlen jetzt nicht irgendeinen wahlberechtigten, sondern den
	// juengsten
	public static <O, P> Set<O> repraesentanten(Set<O> grundmenge,
			Mapper<O, P> mapper, Comparator<? super O> cmp) {
		Set<O> result = new HashSet<>();
		// wir bauen eine map auf
		// key-type: P value-type: O
		Map<P, O> map = new HashMap<>();
		P property;
		// wir iterieren über alle elemente der grundmenge
		for (O o : grundmenge) {
			// wir ermitteln die eigenschaft des aktuellen objektes
			property = mapper.map(o);
			// wir prüfen, ob die aktuelle property schon key in der map ist
			// falls nein, fügen wir ein neues key-value-pair in die map ein
			if (!map.containsKey(property)) {
				map.put(property, o);
			} else {
				// wir prüfen, ob das aktuelle objekt "groesser" ist als das
				// vorhandene
				// falls ja, ersetzen wir den wert für die aktuelle property
				O vorhandenesObjekt = map.get(property);
				if (cmp.compare(o, vorhandenesObjekt) > 0) { // aktuelles objekt
																// > vorhandenes
					map.put(property, o);
				}
			}

		}

		result.addAll(map.values());
		return result;
	}

	/*
	 * wir schreiben die methode createPartition(). sie zerlegt eine menge in
	 * paarweise disjunkte teilmengen, deren vereinigung die ausgangsmenge
	 * ergibt, und jede teilmenge soll dabei objekte enthalten, die in einer
	 * gegebenen eigenschaft übereinstimmen.
	 * 
	 * bsp.: eine stringmenge wird in teilmengen zerlegt derart, dass jede
	 * teilmenge strings derselben länge enthält
	 * 
	 * bsp.: eine integermenge wird in teilmengen zerlegt derart, dass jede
	 * teilmenge zahlen enthält, die bei der division durch 11 denselben rest
	 * enthält.
	 */

	public static <O, P> Set<Set<O>> createPartition(Set<O> grundMenge,
			Mapper<O, P> mapper) {
		Set<Set<O>> partition = new HashSet<>();
		Map<P, Set<O>> map = new HashMap<>();
		Set<O> subset;
		P property;
		for (O object : grundMenge) {
			property = mapper.map(object);
			subset = map.get(property);
			if (subset == null) {
				subset = new HashSet<>();
				map.put(property, subset);
			}
			subset.add(object);
		}
		partition.addAll(map.values());
		return partition;
	}
	
	/* 
	 * wir schreiben die methode createSortedPartition()
	 * funktionsweise wie createdPartition(), aber beim iterieren
	 * über alle subsets werden die subsets aufsteigend nach
	 * der anzahl der elemente geliefert, und in jedem subset
	 * sind die objekte aufsteigend sortiert (sortierkriterium für
	 * die subsets wird durch einen comparator geliefert)
	 */
	
	public static <O, P> NavigableSet<NavigableSet<O>> createSortedPartition(
			Set<O> grundMenge, Mapper<O, P> mapper, 
			final Comparator<? super O> cmp) { 
		Comparator<NavigableSet<O>> cmpSetsBySize = new Comparator<NavigableSet<O>>() {
			@Override
			public int compare(NavigableSet<O> set1, NavigableSet<O> set2) {
				int diff = Integer.compare(set1.size(), set2.size());
				return diff!= 0 ? diff : cmp.compare(set1.last(), set2.last());
			}
			
		};
		
		NavigableSet<NavigableSet<O>> sortedPartition = new TreeSet<>(cmpSetsBySize);
		Map<P, NavigableSet<O>> map = new HashMap<>();
		NavigableSet<O> subset;
		P property;
		for (O object : grundMenge) {
			property = mapper.map(object);
			subset = map.get(property);
			if (subset == null) {
				subset = new TreeSet<>();
				map.put(property, subset);
			}
			subset.add(object);
		}
		sortedPartition.addAll(map.values());
		return sortedPartition;
	}
	
}
