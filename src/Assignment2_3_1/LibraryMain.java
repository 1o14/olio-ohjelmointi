package Assignment2_3_1;

public class LibraryMain {
    public static void main(String[] args) {
        // Luodaan kirjaston instanssi
        Library library = new Library();

        // Luodaan kirja-instansseja
        Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020);
        Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
        Book book3 = new Book("The Art of Fiction", "Alice Johnson", 2019);

        // Lisätään kirjat kirjastoon
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Näytetään kaikki kirjat
        library.displayBooks();

        // Etsitään kirjoja kirjailijan mukaan
        library.findBooksByAuthor("Jane Doe");
    }
}
