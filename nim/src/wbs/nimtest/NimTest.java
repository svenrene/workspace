package wbs.nimtest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import wbs.nim.Nim;
import wbs.nim.NimException;
import wbs.nim.NimZug;

public class NimTest {

	@Test
	public void testNimIntArray() {
		boolean isOK_1 = false;
		boolean isOK_2 = false;
		try {
			new Nim(new int[] { 0, 0, 0 });
		} catch (NimException e) {
			isOK_1 = true;
		}
		try {
			new Nim(new int[] { 5, 5, -1 });
		} catch (NimException e) {
			isOK_2 = true;
		}
		assertTrue(isOK_1 && isOK_2);
	}

	@Test
	public void testZiehen() {
		boolean isOK = false;
		try {
			Nim nim = new Nim(new int[] { 1, 2, 3, 4, 5 });
			nim.ziehen(new NimZug(0, 2));
		} catch (NimException e) {
			isOK = true;
		}
		assertTrue(isOK);
	}

	@Test
	public void testZugVorschlag() {
		// brute force...
		Nim nim;
		boolean isOK = true;
		try {
			for (int i = 0; i < 100; i++) {
				nim = new Nim();
				while (!nim.isOver()) {
					nim.ziehen(nim.zugVorschlag());
				}
			}
		} catch (NimException e) {
			isOK = false;
		}
		assertTrue(isOK);
	}

	@Test
	public void testIsLegalMove() {
		Nim nim = new Nim(new int[] { 1, 2, 3, 4, 5 });
		boolean isOK_1 = nim.isLegalMove(new NimZug(0, 0));
		boolean isOK_2 = nim.isLegalMove(new NimZug(2, 3));
		assertTrue(isOK_1 && ! isOK_2);
	}

}
