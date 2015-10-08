package wbs.constructors_methods_encapsulation.sub;

import wbs.constructors_methods_encapsulation.Base;

public class Sub extends Base {


	@Override
	protected void m() {
		n = 123;
	}
	
	protected void m2() {
		Base base = new Base();
		
		// base.n = 456;	compilerfehler
		// base.m();		compilerfehler
		
	}


}
