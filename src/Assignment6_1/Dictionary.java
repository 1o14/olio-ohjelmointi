package Assignment6_1;

import java.util.HashMap;
import java.util.Map;

// Sanakirjamalli, jossa on sanat ja merkitykset
public class Dictionary {
    private Map<String, String> words; // HashMap, joka tallentaa sanat ja niiden merkitykset

    public Dictionary() {
        words = new HashMap<>();
        // Esimerkkisanat (voit lisätä lisää)
        words.put("hello", "A greeting or expression of goodwill");
        words.put("java", "A popular programming language");
        words.put("world", "The earth, together with all of its countries and peoples");
    }

    // Lisää sana ja merkitys sanakirjaan
    public void addWord(String word, String meaning) {
        words.put(word.toLowerCase(), meaning); // Tallennetaan pienillä kirjaimilla, jotta haku toimii oikein
    }

    // Hakee sanan merkityksen, palauttaa null jos sanaa ei löydy
    public String searchWord(String word) {
        return words.get(word.toLowerCase());
    }
}
