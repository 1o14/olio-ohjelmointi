package Assignment1_3;

import java.util.Random;
import java.util.Scanner;

public class MultiplicationTableExam {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            int score = 0;  // Lasketaan oikein vastatut kysymykset

            // Esitetään 10 satunnaista kertolaskukysymystä
            for (int i = 0; i < 10; i++) {
                // Satunnaiset luvut 1-10
                int num1 = random.nextInt(10) + 1;
                int num2 = random.nextInt(10) + 1;

                // Kysytään käyttäjältä vastausta
                System.out.print("Mikä on " + num1 + " * " + num2 + "? ");
                int answer = scanner.nextInt();

                // Tarkistetaan, oliko vastaus oikein
                if (answer == num1 * num2) {
                    System.out.println("Oikein!");
                    score++;  // Lisätään piste oikein vastatuista
                } else {
                    System.out.println("Väärin. Oikea vastaus on: " + (num1 * num2));
                }
            }

            // Tarkistetaan, onko käyttäjä saanut täydet pisteet
            if (score == 10) {
                System.out.println("Onnittelut! Olet oppinut kertotaulut!");
                break;  // Lopetetaan ohjelma
            } else {
                System.out.println("Sait " + score + " pistettä. Yritä uudelleen!");
            }
        }

        scanner.close();
    }
}
