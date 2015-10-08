package wbs.schleifen;

import java.util.Iterator;
import java.util.NoSuchElementException;

// bitte skizzieren, was alles getan werden muss, damit dieser code
// funktioniert

// retroanalyse is fun

// MyString implementiert Iterable<Character>

// My String hat einen konstruktor, der ein string-argument akzeptiert

// MyString implementiert die methode iterator(), die als return-typ
// Iterator<Character> deklariert

// wir brauchen eine hilfsklasse (MyStringItr), die Iterator<Character>
// implementiert
// die iterator()- methode liefert ein objekt vom typ dieser hilfsklasse
// dieses iterator-objekt muss eine referenz haben auf das MyString- objekt
// und wissen,
// auf welchem zeichen des MyString-objektes es aktuell steht

class MyStringItr implements Iterator<Character> {

	private String s;
	private int pos = 0;

	@Override
	public boolean hasNext() {
		return pos < s.length();
	}

	@Override
	public Character next() {
		if (!hasNext()) {
			throw new NoSuchElementException("no more element...");
		}
		return s.charAt(pos++);
	}

	@Override
	public void remove() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("remove not supported...");
	}

	MyStringItr(String s) {
		this.s = s;
		this.pos = 0;
	}

}

class MyString implements Iterable<Character> {

	private String s;

	public MyString(String s) {

		this.s = s;
	}

	@Override
	public Iterator<Character> iterator() {
		return new MyStringItr(this.s);
	}

}

public class MyStringDemo {

	public static void main(String[] args) {
		MyString myString = new MyString("abc");
		for (Character c : myString) {
			System.out.println(c);
		}
	}
}
