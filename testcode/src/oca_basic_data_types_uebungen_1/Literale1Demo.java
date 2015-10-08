package oca_basic_data_types_uebungen_1;

public class Literale1Demo {
	
	public static void main(String[] args) {

// 1 System.out.println(0b123); // Compilerfehler - 0b ist eine dualzahl, daher nur eine 0 oder eine 1 erlaubt
// 2  System.out.println(05678); // literal is out of range
 System.out.println(12.34);
// 3 System.out.println(_12.34);
 System.out.println(12.3_4);
 System.out.println(0xF_F); // literal hexadezimal - unterstrich nur zur formatierung
// 4 System.out.println('ab');
 System.out.println("ab");
 System.out.println("a" + 0);
 System.out.println('a' + 0);
// 5 System.out.println(0b1f);
// 6 System.out.println(123_123_123_123_123);
	
	}
}