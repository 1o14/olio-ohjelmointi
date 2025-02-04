package Assignment3_3_2.model;

import java.util.ArrayList;
import java.util.List;

public class LibraryMember {
    private String name;
    private int memberId;
    private List<Book> borrowedBooks = new ArrayList<>();

    // Konstruktori jäsenelle
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

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Lisää kirja lainattuihin kirjoihin
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    // Palauta kirja lainoista
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
}
