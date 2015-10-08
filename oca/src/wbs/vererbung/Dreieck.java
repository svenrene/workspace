package wbs.vererbung;

import wbs.util.ValidationUtil;

public class Dreieck extends Figur2D {

	private double a;
	private double b;
	private double c;

	public Dreieck(double a, double b, double c) {
		super();
		setA(a);
		setB(b);
		setC(c);
		
		double u = a + b + c;
		double s = u / 2 ;
		double x = s*(s-a)*(s-b)*(s-c);		
		ValidationUtil.validateTriangle(x, a, b, c);
		
	}
	
	@Override
	public double flaeche() {
		double s = (a + b + c) / 2;
		return Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}

	@Override
	public double umfang() {
		return a + b + c;
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

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

}
