package Assignment1_1;

import java.util.Scanner;

public class SumOfThreeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Kysyy ensimmäisen numeron
        System.out.println("Give the first number:");
        int first = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the second number:");
        int second = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the third number:");
        int third = Integer.parseInt(scanner.nextLine());

        //Laskee summan ja tulostaa sen
        int sum = first + second + third;
        System.out.println("The sum of the numbers is " + sum);

        //Laskee tulon ja tulostaa sen
        int product = first * second * third;
        System.out.println("The product of the numbers is " + product);

        //Laskee keskiarvon ja tulostaa sen
        double average = (first + second + third) / 3.0;  // Käytetään 3.0, jotta saadaan desimaalinen tulos
        System.out.println("The average of the numbers is " + average);
    }
}
