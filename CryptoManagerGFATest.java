package assignment3;

/*
 * Class: CMSC203 
 * Instructor:Farnaz Eivazi 
 * Description: Test out each method in the cryptoManager class
 * Due: 3/17/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Ifte Maksud
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CryptoManagerGFATest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("THIS TEST SHOULD SUCCEED"));
	}
	
	@Test
	public void testEncryptCaesar() {
		assertEquals("IFMMP!XPSME", CryptoManager.caesarEncryption("HELLO WORLD", 1));
	}
	
	@Test
	public void testDecryptCaesar() {
		assertEquals("HELLO WORLD", CryptoManager.caesarDecryption("IFMMP!XPSME", 1));
	}




}
