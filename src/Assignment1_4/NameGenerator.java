package Assignment1_4;

import java.util.Random;
import java.util.Scanner;

public class NameGenerator {
    public static void main(String[] args) {
        // Etu- ja sukunimi taulukot
        String[] firstNames = {"John", "Jane", "Alex", "Emily", "Michael", "Sarah"};
        String[] lastNames = {"Smith", "Doe", "Johnson", "Brown", "Davis", "Miller"};

        // Kysytään käyttäjältä kuinka monta nimeä hän haluaa generoida
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many random names would you like to generate? ");
        int numberOfNames = scanner.nextInt();

        // Luodaan Random-olio satunnaisten valintojen tekemiseen
        Random random = new Random();

        // Generoidaan ja tulostetaan pyydetty määrä nimiä
        for (int i = 0; i < numberOfNames; i++) {
            // Valitaan satunnaiset indeksit etu- ja sukunimille
            int firstNameIndex = random.nextInt(firstNames.length);
            int lastNameIndex = random.nextInt(lastNames.length);

            // Yhdistetään etunimi ja sukunimi
            String fullName = firstNames[firstNameIndex] + " " + lastNames[lastNameIndex];

            // Tulostetaan koko nimi
            System.out.println(fullName);
        }

        scanner.close();
    }
}
