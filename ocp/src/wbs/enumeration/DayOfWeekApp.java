package wbs.enumeration;

enum DayOfWeek{
	MO("montag"), DI("dienstag");
	// class body
	private String bez;

	
	// kosntruktoren eines enum sind immer private
	// private ist optional, protected und public sind nicht erlaubt
	
	// der nachstehende konstruktor wird für jede enum- konstante aufgerufen
	// der aufruf erfolgt implizit
	private DayOfWeek(String bez) {
		this.bez = bez;
	}

	public String getBez() {
		return this.bez;
	}

	public void setBez(String bez) {
		this.bez = bez;
	}

	// enums sind implizit subklassen von object
	// sie können toString() von Object überschreiben
	public String toString() {
		return this.bez;
	}
}

public class DayOfWeekApp{
	public static void main(String[] args) throws Exception {
		DayOfWeek day = DayOfWeek.MO;
		System.out.println(day); // montag
		day.setBez("monday");
		System.out.println(day); // monday
		System.out.println(day.name()); // MO
	}
}