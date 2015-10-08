package wbs.interfaces;

public class Kreisbogen implements IFunction {

	@Override
	public double f(double x) {
		return Math.sqrt(1 - x * x);

	}
}
