package wbs.operators_decisions;

public class SwitchCaseDemo {

	// aufruf mit 2 argumenten
	
	// das 1. argument muss 2, 8, 10 oder 16 sein
	// das 2. argument eine dezimal codierte zahl
	
	// die zahl wird entsprechend dem 1. argument dual, oktal,... dargestellt
	
	// im fehlerfall geben wir brauchbare fehlermeldungen aus
	
	public static void main(String[] args) {

		
		int stellensystem = 0;
		
		if (args.length < 2) {
			System.out.println("Falsche Anzahl Argumente! 2 Argumente notwendig!");
		}	else	{
		
		switch (args[0]) {
		
		case "2":
			stellensystem = 2;
			break;
		case "8":
			stellensystem = 8;
			break;
		case "10":
			stellensystem = 10;
			break;
		case "16":
			stellensystem = 16;
			break;
		default:
			break;		
		}
		if (stellensystem == 0){
		System.out.println("Sie haben kein valides Stellenwertsystem angegeben! (2, 8, 10 oder 16)");
		} else {
		System.out.println(Integer.toString(Integer.parseInt(args[1]), stellensystem));
		}
		}

	}

}
