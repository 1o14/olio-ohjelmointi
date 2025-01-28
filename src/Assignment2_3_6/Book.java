package Assignment2_3_6;

public class Book {
    private String title;
    private String author;
    private int year;

    // Konstruktorin määrittely
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // Getterit
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
}
