package Assignment3_3_3.system;

import Assignment3_3_3.model.Book;
import Assignment3_3_3.model.LibraryMember;

public class Library {

    // Metodi kirjan varaamiseen
    public void reserveBook(LibraryMember member, Book book) {
        if (!book.isReserved()) { // Jos kirja ei ole varattu
            book.setReserved(true); // Merkitään varatuksi
            member.addReservedBook(book); // Lisätään jäsenen varattuihin kirjoihin
            System.out.println("Book reserved successfully.");
        } else {
            System.out.println("Book is already reserved.");
        }
    }

    // Metodi varauksen peruuttamiseen
    public void cancelReservation(LibraryMember member, Book book) {
        if (book.isReserved() && member.hasReservedBook(book)) { // Jos kirja on varattu tälle jäsenelle
            book.setReserved(false); // Poistetaan varaus
            member.removeReservedBook(book); // Poistetaan jäsenen varattujen listalta
            System.out.println("Reservation canceled successfully.");
        } else {
            System.out.println("Book was not reserved by this member.");
        }
    }

    // Metodi varattujen kirjojen näyttämiseksi
    public void displayReservedBooks(LibraryMember member) {
        System.out.println("Reserved books for " + member.getName() + ":");
        for (Book book : member.getReservedBooks()) {
            System.out.println(book.getTitle()); // Näyttää jäsenen varatut kirjat
        }
    }
}
