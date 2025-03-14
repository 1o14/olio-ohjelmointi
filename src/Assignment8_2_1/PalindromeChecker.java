package Assignment8_2_1;

// Luokka, joka tarkistaa, onko merkkijono palindromi
public class PalindromeChecker {
    public boolean isPalindrome(String str) {
        // Poistetaan erikoismerkit ja välilyönnit, muutetaan pieniksi kirjaimiksi
        String cleaned = str.replaceAll("[^a-zA-Z]", "").toLowerCase();

        // Käännetään merkkijono ja verrataan alkuperäiseen
        return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }
}
