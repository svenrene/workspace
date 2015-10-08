package wbs.interfaces;

public class FunctionUtil {

	private FunctionUtil() {
	}

	public static double flaecheUnterGraph(IFunction function, double from,
			double to, double intervall) {

		double flaeche = 0.0;
		for (double x = from + intervall / 2.0; x < to; x += intervall) {
			flaeche += (intervall * function.f(x));

		}
		return flaeche;
	}

}
