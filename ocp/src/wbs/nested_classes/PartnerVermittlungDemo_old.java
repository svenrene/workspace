package wbs.nested_classes;

import java.util.HashSet;
import java.util.Set;

import wbs.generics_collections.Dupel;
import wbs.generics_collections.Matcher;
import wbs.generics_collections.SetUtil;

enum Haarfarbe_GZ {
	BLOND, SCHWARZ, GRAU, ROT, WEISS;
}

class PartnerSuchender_GZ {
	// achtung: passt zu ist nicht unbedingt symmetrisch!
	private String name;
	private Haarfarbe_GZ haarfarbe;
	private Set<Haarfarbe_GZ> akzeptierteHaarfarben;
	
	public PartnerSuchender_GZ(String name, Haarfarbe_GZ eigeneHaarFarbe, Haarfarbe_GZ... weitereAktzeptierteHaarFarben) {
		this.name = name;
		this.haarfarbe = eigeneHaarFarbe;
		akzeptierteHaarfarben = new HashSet<>();
		akzeptierteHaarfarben.add(haarfarbe);
		for (Haarfarbe_GZ farbe : weitereAktzeptierteHaarFarben) {
			akzeptierteHaarfarben.add(farbe);
		}

	}

	public String getName() {
		return name;
	}

	public Haarfarbe_GZ getHaarfarbe() {
		return haarfarbe;
	}

	public Set<Haarfarbe_GZ> getAkzeptierteHaarfarben() {
		return akzeptierteHaarfarben;
	}

	@Override
	public String toString() {
		return name + "(" + haarfarbe + ")" + "akzeptiert "
				+ akzeptierteHaarfarben;
	}
	
}

class PartnerSuchenderMatcher implements 
	Matcher<PartnerSuchender_GZ, PartnerSuchender_GZ> {
	
	@Override
	public boolean matches(PartnerSuchender_GZ p1, PartnerSuchender_GZ p2) {
		boolean b1 = p1.getAkzeptierteHaarfarben().contains(p2.getHaarfarbe());
		boolean b2 = p2.getAkzeptierteHaarfarben().contains(p1.getHaarfarbe());
		return b1 && b2;
	}
}

public class PartnerVermittlungDemo_old {

	// wir erzeugen einige partnersuchende
	// wir listen alle partnersuchenden auf, die "zusammenpassen"
	// kriterium frei wählbar
	public static void main(String[] args) {
		
		// alexis ist blond und akzeptiert weisshaarige und grauhaarige
		PartnerSuchender_GZ alexis = new PartnerSuchender_GZ("alexis",
				Haarfarbe_GZ.BLOND, Haarfarbe_GZ.SCHWARZ, Haarfarbe_GZ.GRAU);
		// beatrice hat schwarzes haar und akzeptiert nur weisshaarige
		PartnerSuchender_GZ beatrice = new PartnerSuchender_GZ("beatrice", 
				Haarfarbe_GZ.SCHWARZ, Haarfarbe_GZ.WEISS);
		// eleonore ist weisshaarig und akzeptiert nur blonde
		PartnerSuchender_GZ eleonore = new PartnerSuchender_GZ("eleonore", 
				Haarfarbe_GZ.WEISS, Haarfarbe_GZ.BLOND);
		
		Set<PartnerSuchender_GZ> partnerSuchende = new HashSet<>();
		
		partnerSuchende.add(alexis);
		partnerSuchende.add(beatrice);
		partnerSuchende.add(eleonore);
		
		PartnerSuchenderMatcher matcher = new PartnerSuchenderMatcher();
		
		Set<Dupel<PartnerSuchender_GZ, PartnerSuchender_GZ>> vorschlaege = SetUtil
				.createDuples(partnerSuchende, partnerSuchende, matcher);
		
		for(Dupel<PartnerSuchender_GZ, PartnerSuchender_GZ> dupel : vorschlaege) {
			System.out.println(dupel.getFirst().getName() + " passt zu "
					+ dupel.getSecond().getName());
		}
	}

}
