package test;

import static org.junit.Assert.*;
import org.junit.Test;
import javax.lang.model.element.VariableElement;
import main.MainPanel;

public class MainPanelTest {
	
	// Test value as 10
	@Test
	public void test1() {

		MainPanel mp = new MainPanel(15);
		assertEquals(mp.convertToInt(10), 10);

	}

	// Test zero value
	@Test
	public void test2() {

		MainPanel mp = new MainPanel(15);
		assertEquals(mp.convertToInt(0), 0);
	
	}

	// Test max value
	@Test
	public void test3() {

		MainPanel mp = new MainPanel(15);
		assertEquals(mp.convertToInt(Integer.MAX_VALUE), Integer.MAX_VALUE);

	}

}