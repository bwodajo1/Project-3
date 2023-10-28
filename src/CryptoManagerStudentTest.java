import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import project.CryptoManager;

class CryptoManagerTest {

    @Test
    void testIsStringInBounds() {
        assertTrue(CryptoManager.isStringInBounds("Hello_World"));
        assertFalse(CryptoManager.isStringInBounds("Hello World")); // contains a space
        assertFalse(CryptoManager.isStringInBounds("123")); // contains a digit
        assertFalse(CryptoManager.isStringInBounds("!@#")); // contains special characters
    }

    @Test
    void testCaesarEncryption() {
        assertEquals("Uifsf JT B TFDSFU EBUB", CryptoManager.caesarEncryption("This IS A SECURE TEXT", 1));
        assertEquals("Xmjmf Jy", CryptoManager.caesarEncryption("Hello My", 5));
    }

    @Test
    void testBellasoEncryption() {
        assertEquals("Yi`mp$]Ip", CryptoManager.bellasoEncryption("Hello World", "abc"));
        assertEquals("Wsv'zj*Q", CryptoManager.bellasoEncryption("Java Test", "xyz"));
    }

    @Test
    void testCaesarDecryption() {
        assertEquals("This IS A SECURE TEXT", CryptoManager.caesarDecryption("Uifsf JT B TFDSFU EBUB", 1));
        assertEquals("Hello My", CryptoManager.caesarDecryption("Xmjmf Jy", 5));
    }

    @Test
    void testBellasoDecryption() {
        assertEquals("Hello World", CryptoManager.bellasoDecryption("Yi`mp$]Ip", "abc"));
        assertEquals("Java Test", CryptoManager.bellasoDecryption("Wsv'zj*Q", "xyz"));
    }
}
