package wbs.nim;

import java.util.Stack;

public class UndoableNim extends Nim {
	@Override
	public Nim ziehen(NimZug zug) throws NimException {
		int index = zug.getIndex();
		int steineVorher = reihen[index];
		
		stack.push(new NimZug(index,steineVorher));
		return super.ziehen(zug);
	}

	@Override
	public NimZug zugVorschlag() throws NimException {
		// TODO Auto-generated method stub
		return super.zugVorschlag();
	}

	private Stack<NimZug> stack = new Stack<NimZug>();

	public UndoableNim(int[] reihen) throws NimException {
		super(reihen);
		// TODO Auto-generated constructor stub
	}

	public void undo(int i) {
		for (int j = 0; j < i && !(stack.empty()); j++) {
			NimZug zug = stack.pop();
			int index = zug.getIndex();
			int anzahlSteine = zug.getAnzahlSteine();
			int anzahlSteineVorher = super.reihen[index];
			if (anzahlSteineVorher == 0) {
				restReihen++;
			}		
			// bitMuster aktualisieren
			bitMuster ^= reihen[index];
			// wie ändert sich bitMuster, wenn eine reihe hinzugefügt wird?
			bitMuster ^= anzahlSteine;
			reihen[index] = anzahlSteine;
		}
	}

	public void reset() {
		while(!stack.empty()){
			undo(1);
		}
	}

}
