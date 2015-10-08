package wbs.operators_decisions;

class Base {
	void m1() {
		System.out.println("m1()");
	}
}

class Sub extends Base {
	void m2() {
		System.out.println("m2()");
	}
}

public class TypeCastDemo {

	public static void main(String[] args) {

		int z1 = 10;
		int z2 = 7;

		double x1;
		double x2;

		x1 = z1 / z2;
		System.out.println(x1);

		x2 = (double) z1 / z2;
		System.out.println(x2);

		Base b = new Sub();
		// Base b = new Base(); // ergibt eine ClassCassException 
		b.m1();
		
		// über eine referenzvariable darf nur auf member des deklarierten typs
		// zugegriffen werden. der deklarierte typ von b ist Base, m2() ist aber kein
		// member von Base;
		// member ist der oberbegriff für: methoden, konstruktoren und felder
		//b.m2(); // compilerfehler
		
		// durch den cast ist der reference-type nun Sub, und m2() gehört zur schnittstelle 
		// der klasse Base
		
		// ein cast nach unten wird als downcast bezeichnet und kann schiefgehen.
		// wenn der cast schiefgeht, gibt es eine ClassCastException.
		
		// ein cast nach unten sollte daher in der regel abgesichert werden unter verwendung 
		// des operators instanceof
		
		((Sub) b).m2();
		
		// casts sollten so selten wie möglich verwendet werden und, wenn sie doch 
		// verwendet werden, abgesichert werden (instanceof)
		
	}

}
