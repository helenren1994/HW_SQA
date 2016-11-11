package test;

import static org.junit.Assert.*;
import org.junit.Test;
import main.Cell;

public class CellTest {

	// Test when the method returns "X" when cell is alive.
	@Test
	public void test1() {

		Cell cell = new Cell();
		cell.setAlive(true);
		assertEquals(cell.toString(), "X");

	}

	// Test when the method returns "." when cell is dead.
	@Test
	public void test2() {

		Cell cell = new Cell(false);
		cell.setAlive(false);
		assertEquals(cell.toString(), ".");

	}

	// Test the method return "." when cell is not alive.
	@Test
	public void test3() {

		Cell cell = new Cell();
		assertEquals(cell.toString(), ".");

	}

}
