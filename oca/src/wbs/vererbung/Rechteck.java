package wbs.vererbung;

public class Rechteck extends Figur2D {

	private double a;
	private double b;

	
	public Rechteck(double a, double b) {
		super();
		setA(a);
		setB(b);
	}

	@Override
	public double flaeche() {
		return (a * b);
	}

	@Override
	public double umfang() {
		return (2 * (a + b));
		// return (2 * a + 2 * b);
	}
	
	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}


}
