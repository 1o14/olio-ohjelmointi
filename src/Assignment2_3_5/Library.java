package Assignment2_3_5;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    // Lasketaan keskimääräinen arvosana
    public double getAverageBookRating() {
        if (books.isEmpty()) {
            return 0.0;
        }

        double totalRating = 0;
        int count = 0;

        for (Book book : books) {
            if (book.getRating() > 0) {
                totalRating += book.getRating();
                count++;
            }
        }

        return count > 0 ? totalRating / count : 0.0;
    }

    // Palautetaan kirja, jolla on eniten arvosteluja
    public Book getMostReviewedBook() {
        if (books.isEmpty()) {
            return null;
        }

        Book mostReviewed = books.get(0);

        for (Book book : books) {
            if (book.getReviews().size() > mostReviewed.getReviews().size()) {
                mostReviewed = book;
            }
        }

        return mostReviewed;
    }
}
