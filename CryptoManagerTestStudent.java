package assignment3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CryptoManagerTestStudent {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void testStringInBounds() {
		assertFalse(CryptoManager.isStringInBounds("abcd"));
		assertTrue(CryptoManager.isStringInBounds("GRID"));
		assertFalse(CryptoManager.isStringInBounds("java"));
		assertFalse(CryptoManager.isStringInBounds("DIg"));
	}
	
	@Test
	public void testEncryptCaesar() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("HEllo", 3));
		assertEquals("RST", CryptoManager.caesarEncryption("HIJ", 10));
		assertEquals("#&$", CryptoManager.caesarEncryption("^!_", 5));
		
	}
	
	@Test
	public void testDecryptCaesar() {
		assertEquals("EGH", CryptoManager.caesarDecryption("GIJ", 2));
		assertEquals("-L/", CryptoManager.caesarDecryption("A C", 20));		
		
	}
	
	@Test
	public void testDecryptBellaso() {
		assertEquals("AB", CryptoManager.bellasoDecryption("BJ", "AH"));

	}
	

}
