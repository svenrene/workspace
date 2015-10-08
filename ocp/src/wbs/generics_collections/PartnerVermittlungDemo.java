package wbs.generics_collections;

import java.util.HashSet;
import java.util.Set;


enum Haarfarbe {
	BLOND, SCHWARZ, GRAU, ROT, WEISS;
}

class PartnerSuchender {
	// achtung: passt zu .. ist nicht unbedingt symmetrisch!
	private String name;
	private Haarfarbe haarfarbe;
	private Set<Haarfarbe> akzeptierteHaarfarben;

	public PartnerSuchender(String name, Haarfarbe eigeneHaarFarbe,
			Haarfarbe akzeptierteHaarfarbe,
			Haarfarbe... weitereAkzeptierteHaarFarben) {
		this.name = name;
		this.haarfarbe = eigeneHaarFarbe;
		akzeptierteHaarfarben = new HashSet<>();
		akzeptierteHaarfarben.add(akzeptierteHaarfarbe);
		for (Haarfarbe farbe : weitereAkzeptierteHaarFarben) {
			akzeptierteHaarfarben.add(farbe);
		}
	}

	public String getName() {
		return name;
	}

	public Haarfarbe getHaarfarbe() {
		return haarfarbe;
	}

	public Set<Haarfarbe> getAkzeptierteHaarfarben() {
		return akzeptierteHaarfarben;
	}

	@Override
	public String toString() {
		return name + "(" + haarfarbe + ") " + "akzeptiert "
				+ akzeptierteHaarfarben;
	}
}

class PartnerSuchenderMatcher implements
		Matcher<PartnerSuchender, PartnerSuchender> {

	@Override
	public boolean matches(PartnerSuchender p1, PartnerSuchender p2) {
		// wir akzeptieren, dass jemand sich selbst als partner vorgeschlagen
		// werden kann...
		boolean b1 = p1.getAkzeptierteHaarfarben().contains(p2.getHaarfarbe());
		boolean b2 = p2.getAkzeptierteHaarfarben().contains(p1.getHaarfarbe());
		return b1 && b2;
	}

}

public class PartnerVermittlungDemo {

	// wir erzeugen einige partnersuchende
	// wir listen alle partnersuchenden auf, die "zusammpassen"
	// kriterium frei wählbar
	public static void main(String[] args) {

		// alexis ist blond und akzeptiert weisshaarige und grauhaarige
		PartnerSuchender alexis = new PartnerSuchender("alexis",
				Haarfarbe.BLOND, Haarfarbe.WEISS, Haarfarbe.GRAU);
		// beatrice hat schwarzes haar und akzeptiert nur weisshaarige
		PartnerSuchender beatrice = new PartnerSuchender("beatrice",
				Haarfarbe.SCHWARZ, Haarfarbe.WEISS);
		// eleonore ist weisshaarig und akzeptiert nur blonde
		PartnerSuchender eleonore = new PartnerSuchender("eleonore",
				Haarfarbe.WEISS, Haarfarbe.BLOND);

		Set<PartnerSuchender> partnerSuchende = new HashSet<>();

		partnerSuchende.add(alexis);
		partnerSuchende.add(beatrice);
		partnerSuchende.add(eleonore);

		PartnerSuchenderMatcher matcher = new PartnerSuchenderMatcher();

		Set<Dupel<PartnerSuchender, PartnerSuchender>> vorschlaege = SetUtil
				.createDuples(partnerSuchende, partnerSuchende, matcher);

		for (Dupel<PartnerSuchender, PartnerSuchender> dupel : vorschlaege) {
			System.out.println(dupel.getFirst().getName() + " passt zu "
					+ dupel.getSecond().getName());
		}
	}

}
