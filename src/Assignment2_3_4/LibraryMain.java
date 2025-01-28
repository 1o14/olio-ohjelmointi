package Assignment2_3_4;

public class LibraryMain {
    public static void main(String[] args) {
        // Luodaan kirjoja
        Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020);
        Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
        Book book3 = new Book("The Art of Fiction", "Alice Johnson", 2019);

        // Luodaan kirjasto ja lisätään kirjat
        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Asetetaan kirjan arvosanoja
        book1.setRating(4.5);
        book2.setRating(3.8);
        book3.setRating(4.2);

        // Lisätään arvosteluja kirjoille
        book1.addReview("Excellent introduction to Java.");
        book2.addReview("A bit too theoretical, but useful.");
        book3.addReview("An insightful look into fiction writing.");

        // Näytetään kirjat ja niiden tiedot
        library.displayBooks();

        // Näytetään kirjan arvostelut
        library.displayBookReviews(book1);
        library.displayBookReviews(book2);
        library.displayBookReviews(book3);

        // Tarkistetaan, onko tietty kirja saatavilla
        String bookTitleToCheck = "Data Structures and Algorithms";
        if (library.isBookAvailable(bookTitleToCheck)) {
            System.out.println("The book \"" + bookTitleToCheck + "\" is available in the library.");
        } else {
            System.out.println("The book \"" + bookTitleToCheck + "\" is not available in the library.");
        }
    }
}
