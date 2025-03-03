package Assignment6_4.model;

// Tämä luokka edustaa yksittäistä muistiinpanoa
public class Note {
    private String title;  // Muistiinpanon otsikko
    private String content; // Muistiinpanon sisältö

    // Konstruktori luo uuden muistiinpanon
    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Getterit
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    // Setterit päivitystä varten
    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Palautetaan muistiinpano merkkijonona (näkyy ListView:ssä)
    @Override
    public String toString() {
        return title + ": " + content;
    }
}
