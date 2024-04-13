package assignment4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyTestStudent {
	
	private Property testProperty;

	@BeforeEach
	void setUp() throws Exception {
		testProperty = new Property("firstHouse","rockyhill",300.21,"daniel",3,5,2,1);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		testProperty = null;
	}

	@Test
	void testProperty() {
		assertEquals(testProperty.getPropertyName(),"firstHouse");
	}
	
	@Test
	void testCity() {
		assertEquals(testProperty.getCity(),"rockyhill");
	}
	
	@Test
	void testRent() {
		assertEquals(testProperty.getRentAmount(),300.21);
	}
	
	@Test
	void testOwner() {
		assertEquals(testProperty.getOwner(),"daniel");
	}
	
	@Test
	void testPlot() {
		Plot plot = testProperty.getPlot();
		assertEquals(testProperty.getPlot(),plot);
	}
	
	@Test
	void testToString() {
		String propertyInfo = "firstHouse,rockyhill,daniel,"+300.21;
		assertEquals(testProperty.toString(),propertyInfo);
	}
	
	
	

}
