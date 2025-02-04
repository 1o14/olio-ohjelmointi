package Assignment3_3_2;

import Assignment3_3_2.model.Book;
import Assignment3_3_2.model.LibraryMember;
import Assignment3_3_2.system.Library;

public class Main {
    public static void main(String[] args) {
        // Luo uusi kirjasto
        Library library = new Library();

        // Luo kirjoja
        Book book1 = new Book("1984", "George Orwell", "12345");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "67890");

        // Lisää kirjoja kirjastoon
        library.addBook(book1);
        library.addBook(book2);

        // Luo jäsen
        LibraryMember member = new LibraryMember("John Doe", 101);

        // Lisää jäsen kirjastoon
        library.addMember(member);

        // Lainaa kirja jäsenelle
        library.borrowBook(member, book1);

        // Yritetään palauttaa kirja
        library.returnBook(member, book1);

        // Yritetään lainata uudelleen
        library.borrowBook(member, book2);
    }
}
