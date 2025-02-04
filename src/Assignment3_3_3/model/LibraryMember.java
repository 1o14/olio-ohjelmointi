package Assignment3_3_3.model;

import java.util.ArrayList;
import java.util.List;

public class LibraryMember {
    private String name;
    private int memberId;
    private List<Book> reservedBooks = new ArrayList<>(); // Lista varatuista kirjoista

    // Konstruktori
    public LibraryMember(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    // Getterit
    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }

    // Lisää kirjan varattuihin
    public void addReservedBook(Book book) {
        reservedBooks.add(book);
    }

    // Poistaa kirjan varatuista
    public void removeReservedBook(Book book) {
        reservedBooks.remove(book);
    }

    // Tarkistaa, onko kirja varattu tälle jäsenelle
    public boolean hasReservedBook(Book book) {
        return reservedBooks.contains(book);
    }

    // Palauttaa varatut kirjat listana
    public List<Book> getReservedBooks() {
        return reservedBooks;
    }
}
