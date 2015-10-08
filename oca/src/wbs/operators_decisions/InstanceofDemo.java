package wbs.operators_decisions;

import java.util.AbstractList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

// instanceof hat 3 mögliche ausgänge:
// true
// false
// compilerfehler

// für dieselbe variable (al) und denselben typ (ArrayList) kann instanceof
// zu verschiedenen zeitpunkten verschiedene ergebnisse liefern da der object-type
// von al immer wieder ein anderer sein kann

interface I1{
}

class C11{
}

final class C12{
}

public class InstanceofDemo {
	
	public static void main(String[] args) {
		Vector<?> v = new Vector<>();
		AbstractList<?> al = new LinkedList<>();
		System.out.println(v instanceof AbstractList); // true
		System.out.println(v instanceof List); // true
		System.out.println(v instanceof Collection); // true
		System.out.println(v instanceof Object); // true
		// System.out.println(v instanceof String); // Compilerfehler
		System.out.println(al instanceof LinkedList); // true
		al = v;
		System.out.println(al instanceof LinkedList); // false
		
		C11 c11 = new C11();
		@SuppressWarnings("unused")
		C12 c12 = new C12();
		System.out.println(c11 instanceof I1); // false
        // System.out.println(c12 instanceof I1);
	}
}
