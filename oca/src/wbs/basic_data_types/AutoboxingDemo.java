package wbs.basic_data_types;

import java.util.Vector;

public class AutoboxingDemo {
	public static void main(String[] args) {
		
		// wir erzeugen 2 Integer- Objekte, die wertmässig gleich sind aber nicht identisch
		Integer i11 = new Integer(100);
		Integer i12 = new Integer(100);
		
		// autoboxing
		// der compiler ruft impliziet folgendes auf:
		// Integer i21 = Integer.valueOf(100)
		// Integer i22 = Integer.valueOf(100)
		// die klasse Integer baut intern einen cache von Integern auf, z. z. von -128 bis 127
		// die valueOf()- methode liefert referenzen auf integer- objekte aus diesem cache.
		// sofern der wert zwischen -128 und 127 liegt
		
		// i21 und i22 referenzieren dasselbe Integer- objekt
		Integer i21 = 100;
		Integer i22 = 100;
		
		Integer i31 = Integer.valueOf(100);
		Integer i32 = Integer.valueOf(100);
		
		// da 200 z.z. nicht im cache liegt, wird hier 2 mal new aufgerufen,
		// wir bekommen referenzen auf gleich, aber nicht identische objekte
		//
		Integer i41 = 200;
		Integer i42 = 200;
		
		Integer i51 = Integer.valueOf(200);
		Integer i52 = Integer.valueOf(200);
		System.out.println(i11 == i12); // false !
		System.out.println(i21 == i22); // true !
		System.out.println(i31 == i32); // true !
		System.out.println(i41 == i42); // false !
		System.out.println(i51 == i52); // false !
		
		// Vector<int> wäre nicht erlaubt
		Vector<Integer> v = new Vector<Integer>();
		// autoboxing
		v.add(100);
		// autounboxing
		// der compiler ruft implizit die methode intValue() der klasse Integer auf
		int n = v.get(0);
		System.out.println(n);
	}
}