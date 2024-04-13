package assignment4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ManagementCompanyTestStudent {
	
	private ManagementCompany testCompany;
	private Property property;
	private Property [] propertyArray;
	@BeforeEach
	void setUp() throws Exception {
		testCompany = new ManagementCompany("hilton","37341",8);
		propertyArray = new Property[5];
	}

	@AfterEach
	void tearDown() throws Exception {
		testCompany = null;
		property = null;
		propertyArray = null;
	}

	@Test
	void testAddProperty() {
		//adds a property into the array successfully and checks if it returns the correct index 
		assertEquals(testCompany.addProperty("firstHouse","springbrook", 745.43, "shameer",1,2,4,3),0);
		
		assertEquals(testCompany.getPropertiesCount(),1);
		assertEquals(testCompany.getName(),"hilton");
		assertEquals(testCompany.getTaxID(),"37341");
		assertEquals(testCompany.getMgmFeePer(),8);
		//checks if the management fee between the correct boundaries
		assertTrue(testCompany.isManagementFeeValid());
		

		
		
	}
	
	@Test
	void testTotalRent() {
		property = new Property("testProperty","lessburg",215.43,"jose",2,4,1,2);
		
		assertEquals(testCompany.addProperty(property),0);
		
		//copies the returned array from the original array
		propertyArray = testCompany.getProperties();
		
		//checks if the copied array is equal to the original
		assertEquals(testCompany.getProperties(),propertyArray);
		assertEquals(testCompany.getTotalRent(),215.43);
		
		assertEquals(testCompany.getPlot(), testCompany.getPlot());
		assertEquals(testCompany.getNumberOfProperties(),0);
		
	}
	
	@Test
	void testMoreProperty() {
		Property highestProperty = new Property("firstHouse","springbrook", 745.43, "shameer",1,2,4,3);
		assertEquals(testCompany.addProperty("secondHouse","rockyhill",300.21,"alex"),0);
		
		assertEquals(testCompany.addProperty(highestProperty),1);
		propertyArray = testCompany.getProperties();
		
		//checks if the highest property matches with the correct index
		assertEquals(testCompany.getHighestRentPropperty(),propertyArray[1]);
		assertFalse(testCompany.isPropertiesFull());
		
		//removes the last index of the property array and compare with the original copy array
		testCompany.removeLastProperty();
		assertNotEquals(testCompany.getProperties(), propertyArray);
	}
	
	@Test
	void testToString() {
		assertEquals(testCompany.addProperty("secondHouse","rockyhill",300.21,"alex"),0);
		String companyFormat = "List of the properties for hilton, taxID: 37341\n"
				+ "______________________________________________________\n"
				+ "secondHouse,rockyhill,alex,300.21\n"
				+ "______________________________________________________\n"
				+"\n"
				+ " total management Fee: 24.0168";
		
		assertEquals(testCompany.toString(), companyFormat);

	}
	
	
}
