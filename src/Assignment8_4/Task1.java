package Assignment8_4;

import java.util.Arrays;  // Tuodaan tarvittavat luokat

public class Task1 {
    public static void main(String[] args) {
        // Taulukko luvuilla
        int[] numbers = {1, 2, 3, 4, 5};

        // Lasketaan keskiarvo
        double mean = Arrays.stream(numbers)      // Streamataan taulukko
                .average()           // Lasketaan keskiarvo
                .orElse(0);          // Jos tyhjä, palautetaan 0

        // Tulostetaan keskiarvo
        System.out.println("Keskiarvo on: " + mean);
    }
}
