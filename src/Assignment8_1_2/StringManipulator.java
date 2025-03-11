package Assignment8_1_2;

public class StringManipulator {

    // Yhdistetään kaksi merkkijonoa
    public String concatenate(String str1, String str2) {
        return str1 + str2;  // Palautetaan yhdistetty merkkijono
    }

    // Palautetaan merkkijonon pituus
    public int findLength(String str) {
        return str.length();  // Merkkijonon pituus
    }

    // Muutetaan kaikki kirjaimet isoiksi
    public String convertToUpperCase(String str) {
        return str.toUpperCase();  // Palautetaan isoiksi kirjaimiksi muutettu merkkijono
    }

    // Muutetaan kaikki kirjaimet pieniksi
    public String convertToLowerCase(String str) {
        return str.toLowerCase();  // Palautetaan pieniksi kirjaimiksi muutettu merkkijono
    }

    // Tarkistetaan, onko alimerkkijono osa päämerkkijonoa
    public boolean containsSubstring(String str, String subStr) {
        return str.contains(subStr);  // Palautetaan true, jos päämerkkijono sisältää alimerkkijonon
    }
}
