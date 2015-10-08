package wbs.principles;

class Base {
	public void m1() {
	}

	public Number m2() {
		return null;
	}
	public void m3() {

	}
}

class Sub extends Base {

	@Override
	public Integer m2(){
		return null;
	}
	
	@Override
	public void m3() throws RuntimeException {
	super.m3();
	}
	
	//	@Override
	//	public void m3() throws Exception {
	//	}

	
	//	 @Override
	//	 public Object m2(){
	//		 return super.m2();
	//	 }

	// @Override
	// protected void m1(){
	// }

}

public class LiskovDemo {

	public static void main(String[] args) {

	}

}
