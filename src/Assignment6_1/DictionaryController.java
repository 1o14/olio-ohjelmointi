package Assignment6_1;

// Hallitsee sanakirjan toimintalogiikkaa
public class DictionaryController {
    private Dictionary dictionary; // Viittaus sanakirjaan

    public DictionaryController() {
        dictionary = new Dictionary(); // Luodaan uusi sanakirja
    }

    // Hakee sanan merkityksen ja palauttaa sen, jos löytyy
    public String getMeaning(String word) {
        if (word == null || word.trim().isEmpty()) {
            return "Please enter a word."; // Jos käyttäjä ei kirjoittanut mitään
        }

        String meaning = dictionary.searchWord(word);
        return (meaning != null) ? meaning : "Word not found."; // Jos sanaa ei löydy
    }

    // Lisää uuden sanan sanakirjaan
    public void addNewWord(String word, String meaning) {
        if (word == null || word.trim().isEmpty() || meaning == null || meaning.trim().isEmpty()) {
            return; // Ei tehdä mitään, jos syötteet ovat tyhjiä
        }
        dictionary.addWord(word, meaning);
    }
}
