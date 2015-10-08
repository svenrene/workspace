package wbs.vererbung;

// TODO diskussion equals(), compareTo()

public abstract class Figur2D implements Comparable<Figur2D> {

	private int id;

	private static int counter = 0;

	protected Figur2D() {
		id = ++counter;
	}

	public abstract double flaeche();

	public abstract double umfang();

	@Override
	public String toString() {
		String classname = this.getClass().getSimpleName();
		return classname + "(" + id + ")" + " -> " + this.flaeche();
	}

	// implements statt override die methode
	@Override
	public int compareTo(Figur2D figur2d) {
		return (int) Math.signum(this.flaeche() - figur2d.flaeche());
	}

	public int getId() {
		return id;
	}

	public static int getCounter() {
		return counter;
	}

}
