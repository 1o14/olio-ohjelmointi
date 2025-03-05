package Assignment8_3;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        // Luodaan lista kokonaislukuja
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(5);
        numbers.add(8);
        numbers.add(20);
        numbers.add(15);
        numbers.add(3);
        numbers.add(12);

        // Poistetaan parilliset luvut (suodatetaan pois)
        numbers.removeIf(n -> n % 2 == 0);

        // Tuplataan parittomat luvut
        numbers.replaceAll(n -> n * 2);

        // Lasketaan kaikkien numeroiden summa ilman Stream API:ta
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        // Tulostetaan lopullinen lista ja summa
        System.out.println("Updated List: " + numbers);
        System.out.println("Sum of numbers: " + sum);
    }
}
