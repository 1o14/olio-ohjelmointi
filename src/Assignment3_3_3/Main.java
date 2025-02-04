package Assignment3_3_3;

import Assignment3_3_3.model.Book;
import Assignment3_3_3.model.LibraryMember;
import Assignment3_3_3.system.Library;

public class Main {
    public static void main(String[] args) {
        // Luodaan kirjasto
        Library library = new Library();

        // Luodaan kirjoja
        Book book1 = new Book("1984", "George Orwell", "12345");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "67890");

        // Luodaan jäsen
        LibraryMember member = new LibraryMember("John Doe", 101);

        // Kirjan varaaminen
        library.reserveBook(member, book1);
        library.reserveBook(member, book2);

        // Näytetään varatut kirjat
        library.displayReservedBooks(member);

        // Perutaan varaus
        library.cancelReservation(member, book1);

        // Näytetään jäljellä olevat varaukset
        library.displayReservedBooks(member);
    }
}
