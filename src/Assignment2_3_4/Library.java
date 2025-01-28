package Assignment2_3_4;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    // Lisää kirja kirjastoon
    public void addBook(Book book) {
        books.add(book);
    }

    // Näytä kaikki kirjat
    public void displayBooks() {
        System.out.println("Library Catalog:");
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            System.out.println((i + 1) + ". Title: \"" + book.getTitle() + "\", Author: \"" + book.getAuthor() + "\", Year: " + book.getYear());
        }
    }

    // Tarkistaa onko kirja saatavilla
    public boolean isBookAvailable(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return true; // Kirja löytyy
            }
        }
        return false; // Kirjaa ei löydy
    }

    // Näytä kirjan arvostelut
    public void displayBookReviews(Book book) {
        System.out.println("Reviews for \"" + book.getTitle() + "\":");
        if (book.getReviews().isEmpty()) {
            System.out.println("No reviews yet.");
        } else {
            for (String review : book.getReviews()) {
                System.out.println("- " + review);
            }
        }
    }
}
