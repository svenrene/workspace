package wbs.generics_collections;

import java.util.HashSet;
import java.util.Set;

// wir nehmen an, dass ein angebot zu einem suchenden passt, wenn die gewünschte
// berufserfahrung und die vorhandene berufserfahrung nicht zu weit auseinanderliegen

class StellenAngebot {

	private String jobName;
	private int gewuenschteBerufsErfahrung; // in jahren

	public StellenAngebot(String jobName, int gewuenschteBerufsErfahrung) {
		this.jobName = jobName;
		this.gewuenschteBerufsErfahrung = gewuenschteBerufsErfahrung;
	}
	
	public String getJobName() {
		return jobName;
	}
	
	public int getGewuenschteBerufsErfahrung() {
		return gewuenschteBerufsErfahrung;
	}
	
	@Override
	public String toString() {
		return jobName + "(" + gewuenschteBerufsErfahrung + ")";
	}

}

class StellenSuchender {

	private String name;
	private int vorhandeneBerufsErfahrung; // in jahren

	public StellenSuchender(String name, int vorhandeneBerufsErfahrung) {
		this.name = name;
		this.vorhandeneBerufsErfahrung = vorhandeneBerufsErfahrung;
	}
	
	public String getName() {
		return name;
	}

	public int getVorhandeneBerufsErfahrung() {
		return vorhandeneBerufsErfahrung;
	}

	@Override
	public String toString() {
		return name + "(" +  vorhandeneBerufsErfahrung + ")";
	}

}

class StellenAngebotMatcher implements
		Matcher<StellenAngebot, StellenSuchender> {

	private int erlaubteDifferenzBerufsErfahrung;
	
	public StellenAngebotMatcher(int erlaubteDifferenzBerufsErfahrung) {
		this.erlaubteDifferenzBerufsErfahrung = erlaubteDifferenzBerufsErfahrung;
	}

	@Override
	public boolean matches(StellenAngebot angebot, StellenSuchender suchender) {
		return suchender.getVorhandeneBerufsErfahrung()
	     + erlaubteDifferenzBerufsErfahrung >= angebot
	     .getGewuenschteBerufsErfahrung(); }

	public int getErlaubteDifferenzBerufsErfahrung() {
		return erlaubteDifferenzBerufsErfahrung;
	}

	public void setErlaubteDifferenzBerufsErfahrung(
			int erlaubteDifferenzBerufsErfahrung) {
		this.erlaubteDifferenzBerufsErfahrung = erlaubteDifferenzBerufsErfahrung;
	}
	
}

public class StellenVermittlungDemo {

	public static void main(String[] args) {
		// wir erzeugen einige stellenangebote
		// wir erzeugen einige stellensuchende
		// wir geben aus, welche stellenangebote zu welchen stellensuchenden
		// passen

		Set<StellenAngebot> angebote = new HashSet<>();
		Set<StellenSuchender> suchende = new HashSet<>();
		
		suchende.add(new StellenSuchender("anton", 10));
		suchende.add(new StellenSuchender("antoinette", 3));
		suchende.add(new StellenSuchender("alexis", 6));
		
		angebote.add(new StellenAngebot("java", 1));
		angebote.add(new StellenAngebot("c++", 5));
		angebote.add(new StellenAngebot("c#", 10));
		
		StellenAngebotMatcher matcher = new StellenAngebotMatcher(2);
		
		Set<Dupel<StellenAngebot, StellenSuchender>> vorschlaege = SetUtil
				.createDuples(angebote, suchende, matcher);
	
		for(Dupel<StellenAngebot, StellenSuchender> dupel : vorschlaege) {
			System.out.println(dupel);
		}
	}

}
