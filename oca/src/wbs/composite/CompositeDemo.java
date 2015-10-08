package wbs.composite;

public class CompositeDemo {
	public static void main(String[] args) {
		A a = new A();
		ASub aSub = new ASub();
		
		Composite composite = new Composite(a);
		composite.a();
		
		composite.setA(aSub);
		composite.a();
		
		I i1 = new CI1();
		I i2 = new CI2();
		
		
		composite.setI(i1);
		composite.i();
		
		composite.setI(i2);
		composite.i();
	}
}
