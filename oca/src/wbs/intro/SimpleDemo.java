package wbs.intro;

// definition einer klasse
// eine klasse, die als public deklariert ist, ist überall erreichbar
// eine klasse, die nicht public ist, ist nur innerhalb desselben packages sichtbar

// es folgt ein javadoc- kommentar

/**
 * 
 * @author args
 */

public class SimpleDemo

{
	// es folgt die definition der methode main()
	// eine ausführbare java-klasse muss eine main() -methode definieren
	// die main()- methode muss static sein und einen parameter deklarieren
	// vom typ String[] (oder String...)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// System ist eine klasse aus dem package java.lang
		// diese klasse hat ein statisches feld namens out
		// das feld out ist vom typ PrintStream
		// PrintStream ist eine klasse aus dem package java.io
		// println() ist eine vielfach überladenen methode der klasse PrintStream
		// die methode println wird mit einem als literal gegebenen string als
		// argument aufgerufen
		System.out.println("wir legen los"); // dies ist die Anweisung
	}

}
