package Assignment3_3_2.model;

public class Book {
    private String title;
    private String author;
    private String isbn;

    // Konstruktori kirjan tiedoille
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Getterit kirjan tiedoille
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    // Tulostaa kirjan tiedot
    @Override
    public String toString() {
        return title + " by " + author + " (ISBN: " + isbn + ")";
    }
}
