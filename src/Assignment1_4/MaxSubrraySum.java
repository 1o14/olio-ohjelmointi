package Assignment1_4;

import java.util.Scanner;

public class MaxSubrraySum {
    public static void main(String[] args) {
        // Kysytään käyttäjältä, kuinka monta numeroa käsitellään
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        // Luodaan "taulukko" ja pyydetään käyttäjältä numeroita
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        // Muuttujat suurimman summan, sen alun ja lopun muistamiseen
        int maxSum = Integer.MIN_VALUE;
        int start = 0, end = 0;

        // Käydään läpi kaikki mahdolliset alimuodot (subarrays)
        for (int i = 0; i < n; i++) {
            int currentSum = 0;

            for (int j = i; j < n; j++) {
                // Lasketaan alimuodon summa
                currentSum += arr[j];

                // Jos löydetään suurempi summa, päivitetään maxSum ja sen alut ja loput
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    start = i;
                    end = j;
                }
            }
        }

        // Tulostetaan suurin summa ja sen indeksit
        System.out.println("\nMaximum sum: " + maxSum);
        System.out.println("Integers: " + (start + 1) + "-" + (end + 1));

        scanner.close();
    }
}
