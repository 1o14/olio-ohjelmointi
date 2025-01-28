package Assignment2_3_1;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    // Lisää kirja kirjastoon
    public void addBook(Book book) {
        books.add(book);
    }

    // Näyttää kaikki kirjat
    public void displayBooks() {
        System.out.println("Library Catalog:");
        int index = 1;
        for (Book book : books) {
            System.out.println(index + ". Title: \"" + book.getTitle() + "\", Author: \"" + book.getAuthor() + "\", Year: " + book.getPublicationYear());
            index++;
        }
    }

    // Etsii kirjoja tietyn kirjailijan mukaan
    public void findBooksByAuthor(String author) {
        System.out.println("\nBooks by Author \"" + author + "\":");
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println("Title: \"" + book.getTitle() + "\", Year: " + book.getPublicationYear());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found by author \"" + author + "\".");
        }
    }
}
