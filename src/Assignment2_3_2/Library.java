package Assignment2_3_2;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Book> borrowedBooks = new ArrayList<>(); // Lista lainatuista kirjoista

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

    // Kirjan lainaaminen
    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                books.remove(book); // Poistetaan kirja kirjastosta
                borrowedBooks.add(book); // Lisätään lainatut kirjat -listalle
                System.out.println("You have borrowed: \"" + book.getTitle() + "\"");
                return;
            }
        }
        System.out.println("The book \"" + title + "\" is not available in the library.");
    }

    // Kirjan palauttaminen
    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book); // Poistetaan palautettu kirja lainatut kirjoista
            books.add(book); // Lisätään kirja takaisin kirjaston kokoelmaan
            System.out.println("You have returned: \"" + book.getTitle() + "\"");
        } else {
            System.out.println("This book was not borrowed from the library.");
        }
    }
}
