package Assignment1_4;

import java.util.Scanner;

public class RemoveDublicates {
    public static void main(String[] args) {
        // Kysytään käyttäjältä, kuinka monta numeroa käsitellään
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        // Luodaan taulukko ja pyydetään käyttäjältä numeroita
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        // Luodaan uusi taulukko duplikaattien poistamiseksi
        int[] result = new int[n];
        int index = 0;

        // Käydään läpi alkuperäinen taulukko ja lisätään vain ensimmäinen esiintyminen
        for (int i = 0; i < n; i++) {
            boolean isDuplicate = false;

            // Tarkistetaan, onko numero jo lisätty tulostaulukkoon
            for (int j = 0; j < index; j++) {
                if (arr[i] == result[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            // Jos numeroa ei ole vielä lisätty, lisätään se tulostaulukkoon
            if (!isDuplicate) {
                result[index] = arr[i];
                index++;
            }
        }

        // Tulostetaan taulukko ilman duplikaatteja
        System.out.println("\nThe array without duplicates:");
        for (int i = 0; i < index; i++) {
            System.out.print(result[i] + " ");
        }

        // Suljetaan scanner
        scanner.close();
    }
}
