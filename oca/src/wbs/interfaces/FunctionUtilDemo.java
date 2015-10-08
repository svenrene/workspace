package wbs.interfaces;

public class FunctionUtilDemo {

	public static void main(String[] args) {

		IFunction function = new Quadrat();

		double flaeche;

		flaeche = FunctionUtil.flaecheUnterGraph(function, 0, 1, 0.0001);

		System.out.println(flaeche);

		// wir berechnen den flächeninhalt unter dem graphen der funktion
		// y = sqrt(1 - x * x) im intervall von 0 bis 1

		function = new Kreisbogen();

		flaeche = FunctionUtil.flaecheUnterGraph(function, 0, 1, 0.0001);

		System.out.println(flaeche);

	}

}
