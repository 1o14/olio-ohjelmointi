package Assignment1_3;

import java.util.Scanner;

public class PrimeNumberGenerator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Kysytään käyttäjältä alku- ja loppuluku
        System.out.print("Syötä alkuarvo (start): ");
        int start = scanner.nextInt();

        System.out.print("Syötä loppuarvo (end): ");
        int end = scanner.nextInt();

        System.out.println("Alkuluvut välillä " + start + " - " + end + " ovat:");

        // Käydään läpi kaikki numerot startista endiin
        for (int num = start; num <= end; num++) {
            // Tarkistetaan onko num alkuluku
            if (isPrime(num)) {
                System.out.println(num);  // Tulostetaan alkuluku
            }
        }

        scanner.close();
    }

    // Metodi tarkistaa, onko luku alkuluku
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;  // Luku ei ole alkuluku
        }

        // Tarkistetaan, onko luku jaettavissa jollain muulla kuin 1 ja itsellään
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;  // Ei ole alkuluku
            }
        }

        return true;  // Luku on alkuluku
    }
}

