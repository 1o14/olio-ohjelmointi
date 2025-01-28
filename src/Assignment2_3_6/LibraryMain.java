package Assignment2_3_6;

public class LibraryMain {
    public static void main(String[] args) {
        // Luodaan kirjoja
        Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020);
        Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
        Book book3 = new Book("The Art of Fiction", "Alice Johnson", 2019);

        // Luodaan käyttäjiä
        User user1 = new User("Alice", 25);
        User user2 = new User("Bob", 30);

        // Luodaan kirjasto ja lisätään kirjat ja käyttäjät
        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.addUser(user1);
        library.addUser(user2);

        // Näytetään kaikki kirjat ja käyttäjät
        library.displayBooks();
        System.out.println(); // Tyhjä rivi
        library.displayUsers();
        System.out.println();

        // Käyttäjät lainaavat ja palauttavat kirjoja
        library.borrowBook(user1, "Data Structures and Algorithms");
        library.borrowBook(user2, "The Art of Fiction");

        // Näytetään käyttäjien lainaamat kirjat
        System.out.println(user1.getName() + " borrowed: " + user1.getBorrowedBooks().size() + " books.");
        System.out.println(user2.getName() + " borrowed: " + user2.getBorrowedBooks().size() + " books.");
        System.out.println();

        // Käyttäjät palauttavat kirjoja
        library.returnBook(user1, "Data Structures and Algorithms");
        library.returnBook(user2, "The Art of Fiction");
        System.out.println();

        // Näytetään taas kirjat
        library.displayBooks();
        System.out.println();
    }
}
