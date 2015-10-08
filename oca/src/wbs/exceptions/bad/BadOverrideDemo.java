package wbs.exceptions.bad;

import java.io.IOException;



class BadOverrideBase {

	void m1() throws IOException {}
	void m2() throws IllegalArgumentException {}
}

public class BadOverrideDemo extends BadOverrideBase {
	
	void m1() throws Exception {} // deklariert allgemeinere Exception als Muttermethode
	void m2() throws IOException {} // deklariert allgemeinere Checked Exception als Muttermethode
	
	public static void main(String[] args) {

		

	}

}
