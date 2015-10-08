package wbs.generics_collections;

// T1: Stellenangebot
// T2: StellenSuchender

// T1, T2: PartnerSuchender

public class Dupel<T1, T2> {

	private T1 first;
	private T2 second;
		
	public Dupel(T1 first, T2 second) {
		this.first = first;
		this.second = second;
	}

	public T1 getFirst() {
		return first;
	}

	public void setFirst(T1 first) {
		this.first = first;
	}

	public T2 getSecond() {
		return second;
	}

	public void setSecond(T2 second) {
		this.second = second;
	}

	@Override
	public String toString() {
		return "(" + first + "," + second + ")";
	}
	
	
}
