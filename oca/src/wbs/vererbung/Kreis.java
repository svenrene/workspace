package wbs.vererbung;

public class Kreis extends Figur2D {

	private double radius;

	public Kreis(double radius) {
		super();
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double flaeche() {
		return Math.PI * radius * radius;
	}

	@Override
	public double umfang() {
		return 2.0 * Math.PI * radius;
	}

}
