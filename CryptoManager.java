package assignment3;

/*
 * Class: CMSC203 
 * Instructor:Farnaz Eivazi 
 * Description: encrypt and decrypt values  using techniques. 
 * Due: 3/17/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Ifte Maksud
*/


/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple “substitution cipher” where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Ifte Maksud
 * @version 3/17/2024
 */
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		for(int i= 0;i<plainText.length();i++)
		{
			char letter = plainText.charAt(i);
			
			if(letter < LOWER_RANGE || letter > UPPER_RANGE)
			{
				return false;
			}
		}
		return true;
	}
	

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		String encryptedText = "";
		
		//loops through each character in the plainText String
		for(int i=0;i<plainText.length();i++)
		{
			char character = plainText.charAt(i);
			
			character +=key;
			
			// if by adding the unicode with the key goes over the upperbound,
			// the character's uniCode will decrease by the range to get back between the range
			while(character > UPPER_RANGE)
			{
				character-=64;
			}
			
			encryptedText +=character;
			
		}
		
		//If the given text is out of the bounds, the method will return an error message
		if(isStringInBounds(plainText)==false)
		{
			return "The selected string is not in bounds, Try again.";
		}
		
		
		return encryptedText;
	}
	
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {
		String encryptedText = "";
		
		// tracks the index of the alternate text
		int counter = 0;
		for(int i=0;i<plainText.length();i++)
		{
			// retrieves the uniCode of the text and the alternate text
			int uniCode = plainText.charAt(i);
			
			int keyUniCode = bellasoStr.charAt(counter);
			
			char character = (char)(uniCode + keyUniCode);
			
			//if by adding both uniCodes goes over the upperbound,
			//the character's unicode will decrease by the range to bring it back to the range
			while(character > UPPER_RANGE)
			{
				character -= RANGE;
			}
			
			encryptedText += character;
			
			//adds the counter after each iteration
			counter++;
			
			//if by addding the counter equals the length of the alternate text,
			// counter will reset to zero
			if(counter == bellasoStr.length())
			{
				counter =0;
			}
				
		}
		
		return encryptedText;
		
		
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		
		String decryptText = "";
		
		for(int i=0;i<encryptedText.length();i++)
		{
			
			char character = encryptedText.charAt(i);
			
			// if by decreasing the character's unicode with key drops below 0
			if(character - key < 0)
			{
				// a place holder will equal the negative
				int checkForNegatives = character - key;
				
				//while the placeholder is lower than the lowerbound,
				// its unicode will be increased by 64 to get it back to the range
				while(checkForNegatives < LOWER_RANGE)
				{
					checkForNegatives +=64;
				}
				
				// the character will equal the placeHolder after it's in range
				character = (char)(checkForNegatives);
			}
			
			//else, add the character's unicode until above lowerange
			else
			{
				character = (char)(character-key);
				while(character < LOWER_RANGE)
				{
					character += RANGE;
				}
			}
			
			decryptText +=character;
			
			
		}
		
		return decryptText;
		
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		String decryptedText = "";
		
		int counter = 0;
		for(int i=0;i<encryptedText.length();i++)
		{
			int uniCode = encryptedText.charAt(i);
			
			int keyUniCode = bellasoStr.charAt(counter);
			
			char character;
			if((uniCode - keyUniCode) < 0)
			{
				int checkForNegatives = uniCode - keyUniCode;
				
				while(checkForNegatives < LOWER_RANGE)
				{
					checkForNegatives +=64;
				}
				
				character = (char)(checkForNegatives);
				
			}
			else
			{
				character = (char)(uniCode-keyUniCode);
				while(character < LOWER_RANGE)
				{
					character += RANGE;
				}
			}
			
			
			decryptedText += character;
			counter++;
			
			if(counter == bellasoStr.length())
			{
				counter =0;
			}
				
		}
		
		return decryptedText;
	}
}

