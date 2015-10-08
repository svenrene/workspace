package wbs.generics_collections;

import java.util.Stack;

public class StackDemo {
	// wir erzeugen ein Undoable- Objekt
	// wir führen einige zustandsänderungen herbei
	// wir machen sukzessive alle zustandsänderungen wieder rückgängig
	public static void main(String[] args) {
	Undoable undoable = new Undoable(1);
	undoable.setState(2);
	undoable.setState(3);
	undoable.setState(4);
	System.out.println(undoable);
	while(undoable.undo()) {
	System.out.println(undoable);
	}
	}
	}

class Undoable {
	// ein Undoable- Objekt speichert alle seine zustandsänderungen
	// der zustand eines Undoable- Dinges
	private int state;
	private Stack<Integer> states = new Stack<>();

	public Undoable(int state) {
		this.state = state;
	}

	public int getState() {
		return state;
	}

	public void setState(int newState) {
		if (newState != state) {
			states.push(state);
			this.state = newState;
		}
	}

	// macht die letzte zustandsänderung rückgängig
	public boolean undo() {
		boolean result = false;
		if (!states.empty()) {
			this.state = states.pop();
			result = true;
		}
		return result;
	}

	@Override
	public String toString() {
		return String.valueOf(state);
	}
}