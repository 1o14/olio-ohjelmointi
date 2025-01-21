package Assignment1_3;

import java.util.Scanner;
import java.lang.Math;

public class QuadraticEquationSolver {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Kysytään käyttäjältä kertoimet a, b ja c
        System.out.print("Syötä kertoimen a arvo: ");
        double a = scanner.nextDouble();

        System.out.print("Syötä kertoimen b arvo: ");
        double b = scanner.nextDouble();

        System.out.print("Syötä kertoimen c arvo: ");
        double c = scanner.nextDouble();

        // Lasketaan diskriminantti (b^2 - 4ac)
        double discriminant = b * b - 4 * a * c;

        // Jos diskriminantti on positiivinen, on kaksi juurta
        if (discriminant > 0) {
            // Lasketaan juuret
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a); // Ensimmäinen juuri
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a); // Toinen juuri
            System.out.printf("Juuret ovat: %.2f ja %.2f\n", root1, root2);
        }
        // Jos diskriminantti on nolla, on yksi juuri
        else if (discriminant == 0) {
            double root = -b / (2 * a);  // Yksi juuri
            System.out.printf("Ainoa juuri on: %.2f\n", root);
        }
        // Jos diskriminantti on negatiivinen, ei ole reaalisia juuria
        else {
            System.out.println("Ei reaalisia juuria");
        }

        scanner.close();
    }
}
