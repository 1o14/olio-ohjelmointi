package Assignment2_3_6;

import java.util.ArrayList;

public class User {
    private String name;
    private int age;
    private ArrayList<Book> borrowedBooks;

    // Konstruktorin määrittely
    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getterit
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Metodi lainatun kirjan lisäämiseksi
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    // Metodi palautetun kirjan poistamiseksi
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
}
