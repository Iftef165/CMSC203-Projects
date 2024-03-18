package assignment3;

/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi 
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

class CryptoManagerTestPublic {
	CryptoManager cryptoManager;

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("JAVA"));
		assertTrue(CryptoManager.isStringInBounds("\"JAVA IS FUN\""));
		assertFalse(CryptoManager.isStringInBounds("java"));
		assertFalse(CryptoManager.isStringInBounds("{JAVA"));
		assertFalse(CryptoManager.isStringInBounds("\"THIS TEST THAT SHOULD FAIL BECAUSE { IS OUTSIDE THE RANGE\""));
	}
	
	@Test
	public void testEncryptCaesar() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("bye", 3));
		assertEquals("DEF", CryptoManager.caesarEncryption("ABC", 3));
		assertEquals("!\"#", CryptoManager.caesarEncryption("ABC", 96));
		assertEquals("1.558", CryptoManager.caesarEncryption("HELLO", 105));
		assertEquals("UFTUJOH", CryptoManager.caesarEncryption("TESTING", 1));
		assertEquals("WKLV#LV#DQRWKHU#WHVW", CryptoManager.caesarEncryption("THIS IS ANOTHER TEST", 3));
	}
	
	@Test
	public void testDecryptCaesar() {
		assertEquals("TESTING", CryptoManager.caesarDecryption("UFTUJOH", 1));
		assertEquals("TESTING ANOTHER STRING", CryptoManager.caesarDecryption(";,:;05.G(56;/,9G:;905.", 999));
		assertEquals("HELLO WORLD", CryptoManager.caesarDecryption("4188;LC;>80", 300));
		assertEquals("THIS IS ANOTHER TEST", CryptoManager.caesarDecryption("WKLV#LV#DQRWKHU#WHVW", 3));
		
		
	}
	
	@Test
	public void testDecryptBellaso() {
		assertEquals("TESTING", CryptoManager.bellasoDecryption("WN#\\N &", "CIPHER_IS_LONGER_THAN_THE_PLAIN_TEXT"));
		assertEquals("MERRY CHRISTMAS", CryptoManager.bellasoDecryption("UJ^^((HT^X[YYM\"", "HELLO"));
		assertEquals("THIS IS ANOTHER TEST", CryptoManager.bellasoDecryption("WU\\VR9F#N!RF88U-'HED", "CMSC203"));

	}

	
	


	





}
