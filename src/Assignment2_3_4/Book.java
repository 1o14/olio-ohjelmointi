package Assignment2_3_4;

import java.util.ArrayList;

public class Book {
    private String title;
    private String author;
    private int year;
    private double rating;
    private ArrayList<String> reviews;

    // Konstruktorin määrittely
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.rating = 0.0; // Oletusarvo on 0.0
        this.reviews = new ArrayList<>();
    }

    // Getterit
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public double getRating() {
        return rating;
    }

    public ArrayList<String> getReviews() {
        return reviews;
    }

    // Metodi, joka asettaa kirjan arvioinnin
    public void setRating(double rating) {
        if (rating >= 0.0 && rating <= 5.0) {
            this.rating = rating;
        } else {
            System.out.println("Rating must be between 0 and 5.");
        }
    }

    // Metodi, joka lisää arvostelun kirjaan
    public void addReview(String review) {
        reviews.add(review);
    }
}
