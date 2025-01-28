package Assignment2_3_5;

public class LibraryMain {
    public static void main(String[] args) {
        // Luodaan kirjoja
        Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020);
        Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
        Book book3 = new Book("The Art of Fiction", "Alice Johnson", 2019);

        // Asetetaan arvosanoja
        book1.setRating(4.5);
        book2.setRating(4.0);
        book3.setRating(5.0);

        // Luodaan kirjasto ja lisätään kirjoja siihen
        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Lasketaan keskimääräinen arvosana
        System.out.println("Average book rating: " + library.getAverageBookRating());

        // Haetaan eniten arvosteltu kirja
        Book mostReviewedBook = library.getMostReviewedBook();
        if (mostReviewedBook != null) {
            System.out.println("Most reviewed book: " + mostReviewedBook.getTitle());
        }
    }
}
