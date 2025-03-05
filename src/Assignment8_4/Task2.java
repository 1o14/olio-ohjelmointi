package Assignment8_4;

import java.util.Arrays; // Tuodaan tarvittavat luokat
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        // Lista luvuista
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Suodatetaan parilliset pois, kerrotaan luvut kahdella ja lasketaan summa
        int sum = numbers.stream()            // Streamataan lista
                .filter(n -> n % 2 != 0)  // Poistetaan parilliset
                .map(n -> n * 2)          // Kerrotaan luku kahdella
                .mapToInt(Integer::intValue) // Muutetaan int:ksi
                .sum();                   // Lasketaan summa

        // Tulostetaan summa
        System.out.println("Summa on: " + sum);
    }
}
