package Assignment3_3_3.model;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean reserved = false; // Onko kirja varattu?

    // Konstruktori
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Getterit
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isReserved() {
        return reserved;
    }

    // Asetetaan varauksen tila
    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    // Kirjan tiedot tekstinä
    @Override
    public String toString() {
        return title + " by " + author + " (ISBN: " + isbn + ")";
    }
}
