package Assignment8_2_1;

import org.junit.Test;
import static org.junit.Assert.*;

// Testiluokka PalindromeChecker-luokalle
public class PalindromeCheckerTest {
    @Test
    public void testIsPalindrome() {
        PalindromeChecker checker = new PalindromeChecker();

        // Testataan palindromit
        assertTrue(checker.isPalindrome("radar"));
        assertTrue(checker.isPalindrome("A man, a plan, a canal, Panama"));
        assertTrue(checker.isPalindrome("No lemon, no melon"));

        // Testataan ei-palindromit
        assertFalse(checker.isPalindrome("hello"));
        assertFalse(checker.isPalindrome("openai"));
    }
}
