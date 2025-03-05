package Assignment8_3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        // Luodaan lista Person-olioita
        List<Person> people = new ArrayList<>();
        people.add(new Person("John", 25, "New York"));
        people.add(new Person("Alice", 30, "Los Angeles"));
        people.add(new Person("Bob", 22, "New York"));
        people.add(new Person("David", 28, "Chicago"));
        people.add(new Person("Eva", 35, "New York"));

        // Lajitellaan lista iän mukaan nousevassa järjestyksessä
        people.sort(Comparator.comparingInt(Person::getAge));

        // Suodatetaan lista niin, että jäljelle jää vain "New York"ista tulevat henkilöt
        people.removeIf(person -> !person.getCity().equals("New York"));

        // Tulostetaan tulokset
        System.out.println("People from New York, sorted by age:");
        for (Person person : people) {
            System.out.println(person);
        }
    }
}

// Person-luokka
class Person {
    private String name;
    private int age;
    private String city;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", City: " + city;
    }
}
