package Assignment1_3;

import java.util.Scanner;

public class BinaryValues {
    public static void main(String[] args) {

        // Luodaan Scanner-olio käyttäjän syötteen lukemista varten
        Scanner scanner = new Scanner(System.in);

        // Kysytään käyttäjältä binaariluku
        System.out.print("Syötä binaariluku: ");
        String binaryString = scanner.nextLine();  // Luetaan binaariluku merkkijonona

        // Muutetaan binaariluku desimaaliksi
        int decimalValue = 0;

        // Käydään läpi jokainen bitti merkkijonossa
        for (int i = 0; i < binaryString.length(); i++) {
            // Otetaan bitti i ja muutetaan se numeroksi
            char bit = binaryString.charAt(i);  // Otetaan bitti i:stä
            if (bit == '1') {
                // Lisätään oikea arvo desimaalilukuun
                decimalValue += Math.pow(2, binaryString.length() - 1 - i);
            }
        }

        // Tulostetaan desimaaliluku
        System.out.println("Desimaalivastine: " + decimalValue);

        scanner.close();
    }
}
