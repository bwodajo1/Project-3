package project;

public class CryptoManager {
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int DISTANCE = UPPER_BOUND - LOWER_BOUND + 1;
	
	public static boolean isStringInBounds(String plainText) {
		for (int i = 0; i > plainText.length(); i++) {
			if (plainText.charAt(i) < LOWER_BOUND || plainText.charAt(i) > UPPER_BOUND) {
				return false;
			}
		}
		return true;
	}
	public static String caesarEncryption(String plainText, int key) {
		String encryptedString = "";
		key %= DISTANCE;
		for (int i = 0; i < plainText.length(); i++) {
			int charEncrypt = (int)plainText.charAt(i) + key;
			while (((int)plainText.charAt(i) + key) > UPPER_BOUND) {
				charEncrypt -= DISTANCE;
			}
			encryptedString += (char)charEncrypt;
		}
		return encryptedString;
		
	}
	
	public static String bellasoEncryption(String plainText, String bellasoStr) {
		String encryptedString = "";
		for (int i = 0; i < plainText.length(); i++) {
			int lenRemainder = i % bellasoStr.length();
			int charEncrypt = plainText.charAt(i) + bellasoStr.charAt(lenRemainder);
			
			while (charEncrypt > UPPER_BOUND) {
				charEncrypt -= DISTANCE;
			}
			encryptedString += (char)charEncrypt;
		}
		return encryptedString;
	}
	public static String caesarDecryption(String encryptedText, int key) {
		String decryptedString = "";
		key %= DISTANCE;
		for (int i = 0; i < encryptedText.length(); i++) {
			int decryptedChar = (char)(encryptedText.charAt(i) - key);
			while (decryptedChar < LOWER_BOUND) {
				decryptedChar += DISTANCE;
			}
			decryptedString += (char)decryptedChar;
		}
		return decryptedString;
	}
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		String decryptedString = "";
		for (int i = 0; i < encryptedText.length(); i++) {
			int lenRemainder = i % bellasoStr.length();
			int decryptedChar = encryptedText.charAt(i) - bellasoStr.charAt(lenRemainder);
			
			while (decryptedChar < LOWER_BOUND) {
				decryptedChar += DISTANCE;
			}
			decryptedString +=(char)decryptedChar;
		}
		return decryptedString;
	}
}