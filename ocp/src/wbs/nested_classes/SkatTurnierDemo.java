package wbs.nested_classes;

import java.util.Arrays;
import java.util.List;

public class SkatTurnierDemo {

	
	/*
	 * an einem skatturnier nehmen 10 spieler teil
	 * 
	 * wir listen alle möglichen zusammenstellungen von 3 spielern
	 * zu einer skatpartie auf
	 */
	public static void main(String[] args) {
		
		String[] spieler = {"agathe", "anastasia", "angelika", "angelina",
				"zorro", "behemoth", "aaron", "der täufer", "beatrice",
				"adelheid"};
		
		MyList<String> mySpielerList = new MyList<>(Arrays.asList(spieler));
		
		for(List<String> subList : mySpielerList) {
			if(subList.size() == 3) {
				System.out.println(subList);
			}
		}

	}

}
