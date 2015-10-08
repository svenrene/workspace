package oca_enthuware.working_with_inheritance;

class C1{
	int i = 5;
	static int i_static = 10;
}

public class Vererbung extends C1{
	int j =15;
	public static void main(String[] args) {
		
		int h = Vererbung.j + i_static;
		
		
	}
	
}
