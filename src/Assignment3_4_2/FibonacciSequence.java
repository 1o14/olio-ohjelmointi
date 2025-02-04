package Assignment3_4_2;

import java.io.FileWriter;  // For writing files
import java.io.IOException;  // For handling exceptions
import java.io.PrintWriter;  // For writing to files
import java.util.ArrayList;  // For using lists

public class FibonacciSequence {

    public static void main(String[] args) {
        // Generoi Fibonacci-sekvenssin 60 ensimmäiselle luvulle
        ArrayList<Long> fibonacciSequence = generateFibonacci(60);

        // Määritellään tiedoston nimi
        String filename = "fibonacci_sequence.csv";

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            // Kirjoitetaan tiedoston otsikkorivi
            writer.println("Index,Fibonacci Number");

            // Kirjoitetaan kaikki Fibonacci-luvut tiedostoon
            for (int i = 0; i < fibonacciSequence.size(); i++) {
                writer.println(i + "," + fibonacciSequence.get(i)); // Kirjoitetaan indeksi ja luku
            }

            // Ilmoitetaan, että tiedosto on tallennettu
            System.out.println("Fibonacci sequence has been saved to the file: " + filename);
        } catch (IOException e) {
            // Jos tulee virhe tiedoston kirjoittamisessa
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }

    // Funktio, joka laskee Fibonacci-sekvenssin
    public static ArrayList<Long> generateFibonacci(int n) {
        ArrayList<Long> fibonacciSequence = new ArrayList<>();

        // Lisätään ensimmäiset kaksi lukua, jotka ovat 0 ja 1
        fibonacciSequence.add(0L);
        fibonacciSequence.add(1L);

        // Lasketaan seuraavat Fibonacci-luvut
        for (int i = 2; i < n; i++) {
            long nextNumber = fibonacciSequence.get(i - 1) + fibonacciSequence.get(i - 2);
            fibonacciSequence.add(nextNumber);
        }

        // Palautetaan laskettu sekvenssi
        return fibonacciSequence;
    }
}
