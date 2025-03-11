package Assignment8_1_2;

import static org.junit.Assert.*;
import org.junit.Test;

public class StringManipulatorTest {

    @Test
    public void testConcatenate() {
        // Testataan, että merkkijonot yhdistyvät oikein
        StringManipulator sm = new StringManipulator();
        String result = sm.concatenate("Hello", "World");
        // Tarkistetaan, että tulos on "HelloWorld"
        assertEquals("HelloWorld", result);
    }

    @Test
    public void testFindLength() {
        StringManipulator sm = new StringManipulator();
        int result = sm.findLength("Hello");
        // Odotetaan, että pituus on 5
        assertEquals(5, result);
    }

    @Test
    public void testConvertToUpperCase() {
        StringManipulator sm = new StringManipulator();
        String result = sm.convertToUpperCase("hello");
        // Testataan, että kaikki kirjaimet muuttuvat isoiksi
        assertEquals("HELLO", result);
    }

    @Test
    public void testConvertToLowerCase() {
        StringManipulator sm = new StringManipulator();
        String result = sm.convertToLowerCase("HELLO");
        // Testataan, että kaikki kirjaimet muuttuvat pieniksi
        assertEquals("hello", result);
    }

    @Test
    public void testContainsSubstring() {
        StringManipulator sm = new StringManipulator();
        boolean result = sm.containsSubstring("Hello World", "World");
        // Testataan, että "World" löytyy merkkijonosta
        assertTrue(result);
    }
}

