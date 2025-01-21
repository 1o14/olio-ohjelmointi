package Assignment1_2;

import java.util.Scanner;
import java.lang.Math;

public class RightTriangleHypotenuse {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Pyydetään käyttäjää syöttämään suorakulmaisen kolmion ensimmäisen kateetin pituus
        System.out.print("Syötä ensimmäisen kateetin pituus: ");
        double a = scanner.nextDouble();

        System.out.print("Syötä toisen kateetin pituus: ");
        double b = scanner.nextDouble();

        // Lasketaan hypotenuusan pituus käyttämällä Pythagoran kaavaa: c = sqrt(a^2 + b^2)
        double c = Math.sqrt(a * a + b * b);

        // Tulostetaan hypotenuusan pituus
        System.out.printf("Hypotenuusan pituus on: %.2f\n", c);

        scanner.close();
    }
}
