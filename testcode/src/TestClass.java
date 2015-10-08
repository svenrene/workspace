
public class TestClass {

	static Integer i;
	
	public static void main(String[] args) {
		
		someMethod(i);

	}
	
	static void someMethod(Object parameter){
		System.out.println(parameter);
	}

}
