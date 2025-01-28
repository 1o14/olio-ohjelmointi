package Assignment2_3_3;

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

        // Näytetään kaikki kirjat
        library.displayBooks();

        // Tarkistetaan onko tietty kirja saatavilla
        String bookTitleToCheck = "Data Structures and Algorithms";
        if (library.isBookAvailable(bookTitleToCheck)) {
            System.out.println("The book \"" + bookTitleToCheck + "\" is available in the library.");
        } else {
            System.out.println("The book \"" + bookTitleToCheck + "\" is not available in the library.");
        }
    }
}
