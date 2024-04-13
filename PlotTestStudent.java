package assignment4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlotTestStudent {
	
	private Plot testPlot, overlapPlot, encompassPlot;

	@BeforeEach
	void setUp() throws Exception {
		testPlot = new Plot(1,3,4,5);
		overlapPlot = new Plot(0,1,5,3);
		encompassPlot = new Plot(2,4,2,3);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		testPlot = null;
		overlapPlot= null;
		encompassPlot = null;
	}

	@Test
	void testGetters() {
		assertEquals(testPlot.getX(),1);
		assertEquals(testPlot.getY(),3);
	}
	
	@Test
	void testSettersFirst() {
		testPlot.setX(6);
		assertEquals(testPlot.getX(), 6);
		
		testPlot.setY(0);
		assertEquals(testPlot.getY(),0);
	}
	
	@Test
	void testSettersSecond() {
		testPlot.setWidth(3);
		assertEquals(testPlot.getWidth(), 3);
		
		testPlot.setDepth(1);
		assertEquals(testPlot.getDepth(),1);
	}
	
	@Test
	void testOverlaps() {
		
		assertTrue(testPlot.overlaps(overlapPlot));
		
	}
	
	@Test
	void testEncompass() {
		
		assertTrue(testPlot.overlaps(encompassPlot));
		
	}

}
