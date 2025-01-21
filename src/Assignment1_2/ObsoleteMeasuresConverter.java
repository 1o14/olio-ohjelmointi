package Assignment1_2;

import java.util.Scanner;

public class ObsoleteMeasuresConverter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Pyydetään käyttäjää syöttämään paino grammoina
        System.out.print("Syötä paino grammoina: ");
        double weightInGrams = scanner.nextDouble();

        // Määritellään mittayksiköiden muunnoskaavat
        double luotiInGrams = 13.28;  // Yksi luoti on 13.28 grammaa
        double naulaInLuoti = 32;    // Yksi naula on 32 luotia
        double leiviskaInNaula = 20; // Yksi leiviskä on 20 naulaa

        // Lasketaan, kuinka monta leiviskää, naulaa ja luotia paino vastaa
        double totalLuoti = weightInGrams / luotiInGrams;  // Lasketaan luotien määrä
        int leiviska = (int)(totalLuoti / (naulaInLuoti * leiviskaInNaula));  // Leivisköiden määrä
        totalLuoti -= leiviska * (naulaInLuoti * leiviskaInNaula);  // Vähennetään leivisköiden vastannut määrä

        int naula = (int)(totalLuoti / naulaInLuoti);  // Naulojen määrä
        totalLuoti -= naula * naulaInLuoti;  // Vähennetään naulojen vastannut määrä

        // Jäljelle jäävä paino on luoti
        double luoti = totalLuoti;

        // Tulostetaan tulokset
        System.out.printf("%.2f gramman paino on %d leiviskää, %d naulaa ja %.2f luotia.\n",
                weightInGrams, leiviska, naula, luoti);

        scanner.close();
    }
}
