package wbs.operators_decisions;

public class KonvertiereZahlDemo {

	/*
	 *  die anwendung wird mit 3 argumenten aufgerufen
	 *  
	 *  das 1. argument ist ein string mit ziffernzeichen (ein zahl)
	 *  
	 *  das 2. argument ist ebenfalls ein string mit ziffernzeichen (eine basis
	 *  eines stellenwertsystems)
	 *  
	 *  das 3. argument ist ebenfalls ein string mit ziffernzeichen (eine basis
	 *  eines stellenwertsystems)
	 *  
	 *  das 1. argument wird als zahl im stellenwertsystem mit der 1. basis interpretiert
	 *  und in dem stellenwertsystem ausgegeben, das der 2. basis entspricht
	 *  
	 *  bsp.: KonvertiereZahlDemo 1010 2 10	   ->   10
	 *  bsp.: KonvertiereZahlDemo 222 3 10	   ->   26
	 *  bsp.: KonvertiereZahlDemo FF 16 2	   ->   11111111
	 *  
	 *  mögliche fehler:
	 *  ein oder mehrere string(s) enthält ungültige (ziffern)zeichen
	 *  der aufrufer liefert zu wenig argumente
	 *  
	 *  hinweise:
	 *  gültige basen bitter der API-dokumentation der klasse Integer entnehmen
	 *  
	 *  die anzahl der aufrufargumente kann mit args.length ermittelt werden
	 *  
	 *  bitte try ... catch verwenden und der API-dokumentation entnehmen, welche
	 *  exception ggf geworfen werden 
	 *  
	 *  API: parseInt() von Integer und diverse Überladungen von toString() von Integer
	 */
	
	public static void main(String[] args) {

		if (args.length < 3) {
			System.out.println("Falsche Anzahl Argumente! 3 Argumente notwendig!");
		} else {
			try {
				System.out.println(Integer.toString((Integer.parseInt(args[0], Integer.parseInt(args[1]))), Integer.parseInt(args[2])));
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

}
