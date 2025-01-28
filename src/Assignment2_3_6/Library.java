package Assignment2_3_6;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    // Lisää kirja kirjastoon
    public void addBook(Book book) {
        books.add(book);
    }

    // Lisää käyttäjä kirjastoon
    public void addUser(User user) {
        users.add(user);
    }

    // Lisää kirja käyttäjälle
    public void borrowBook(User user, String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title) && !user.getBorrowedBooks().contains(book)) {
                user.borrowBook(book);
                System.out.println(user.getName() + " has borrowed: " + title);
                return;
            }
        }
        System.out.println("Book " + title + " is not available.");
    }

    // Palauta kirja käyttäjältä
    public void returnBook(User user, String title) {
        for (Book book : user.getBorrowedBooks()) {
            if (book.getTitle().equals(title)) {
                user.returnBook(book);
                System.out.println(user.getName() + " has returned: " + title);
                return;
            }
        }
        System.out.println(user.getName() + " does not have the book: " + title);
    }

    // Näytä kaikki kirjat
    public void displayBooks() {
        System.out.println("Library Catalog:");
        for (Book book : books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor() + ", " + book.getYear());
        }
    }

    // Näytä käyttäjät
    public void displayUsers() {
        System.out.println("Library Users:");
        for (User user : users) {
            System.out.println(user.getName() + ", Age: " + user.getAge());
        }
    }
}
