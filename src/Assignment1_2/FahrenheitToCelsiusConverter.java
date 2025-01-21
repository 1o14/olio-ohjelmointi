package Assignment1_2;

import java.util.Scanner;

public class FahrenheitToCelsiusConverter {
    public static void main(String[] args) {

        // Luodaan Scanner-olio käyttäjän syötteen lukemista varten
        Scanner scanner = new Scanner(System.in);

        // Pyydetään käyttäjää syöttämään lämpötila Fahrenheit-asteina
        System.out.print("Syötä lämpötila Fahrenheit-asteina: ");
        double fahrenheit = scanner.nextDouble();  // Luetaan käyttäjän syöte ja tallennetaan se double-tyyppiseksi muuttujaksi

        // Lasketaan Celsius-asteet käyttämällä kaavaa: C = (F - 32) * 5/9
        double celsius = (fahrenheit - 32) * 5/9;

        // Tulostetaan Celsius-asteet käyttäjälle yhden desimaalin tarkkuudella
        System.out.printf("Lämpötila Celsius-asteina: %.1f\n", celsius);

        scanner.close();
    }
}
