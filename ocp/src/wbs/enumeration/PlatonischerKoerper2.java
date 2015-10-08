package wbs.enumeration;

// dasselbe wie PlatonischerKoerper, aber die konstanten
// bekommen keinen eigenen class-body. die charakteristischen groessen
// für jede konstante werden als feld definiert

public enum PlatonischerKoerper2 {
	
	Tertrader(4,6,4), Oktaeder(8,12,6), Hexaeder(6,12,8), 
	Ikosaeder(20,30,12),Dodekaeder(12,30,20);
	
	private PlatonischerKoerper2(int flaechen, int kanten, int ecken) {
		
		this.flaechen = flaechen;
		this.kanten = kanten;
		this.ecken = ecken;
	}
	
	private int flaechen;
	private int kanten;
	private int ecken;

	public int getFlaechen() {
		return flaechen;
	}
	
	public int getKanten() {
		return kanten;
	}

	public int getEcken() {
		return ecken;
	}

}
