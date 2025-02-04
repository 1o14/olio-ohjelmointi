package Assignment3_3_2.system;

import Assignment3_3_2.model.Book;
import Assignment3_3_2.model.LibraryMember;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<LibraryMember> members = new ArrayList<>();

    // Lisää kirja kirjastoon
    public void addBook(Book book) {
        books.add(book);
    }

    // Lisää jäsen kirjastoon
    public void addMember(LibraryMember member) {
        members.add(member);
    }

    // Laina kirja jäsenelle
    public void borrowBook(LibraryMember member, Book book) {
        if (books.contains(book)) {
            member.borrowBook(book);
            books.remove(book);
            System.out.println(member.getName() + " has borrowed the book: " + book);
        } else {
            System.out.println("Book not available.");
        }
    }

    // Palauta kirja kirjastoon
    public void returnBook(LibraryMember member, Book book) {
        if (member.getBorrowedBooks().contains(book)) {
            member.returnBook(book);
            books.add(book);
            System.out.println(member.getName() + " has returned the book: " + book);
        } else {
            System.out.println("This book was not borrowed by the member.");
        }
    }
}
