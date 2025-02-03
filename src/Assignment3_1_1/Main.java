package Assignment3_1_1;

// Perusautoluokka
class Car {
    protected int speed; // Nopeus km/h
    protected int fuel;  // Polttoaine litroina

    public Car() {
        this.speed = 0;
        this.fuel = 100; // Aloitetaan täydellä tankilla
    }

    // Kiihdytys
    public void accelerate() {
        if (fuel > 0) {
            speed += 10; // Lisää nopeutta 10 km/h
            fuel -= 5;   // Kuluttaa polttoainetta 5 litraa
        } else {
            System.out.println("Out of fuel!");
        }
    }

    // Hidastus
    public void brake() {
        if (speed >= 10) {
            speed -= 10; // Vähentää nopeutta 10 km/h
        } else {
            speed = 0;   // Auto pysähtyy
        }
    }

    // Näyttää auton tiedot
    public void displayStatus() {
        System.out.println("Speed: " + speed + " km/h, Fuel: " + fuel + " L");
    }
}

// Urheiluautoluokka
class SportsCar extends Car {

    public SportsCar() {
        super();
    }

    // Parempi kiihdytys, mutta kuluttaa enemmän polttoainetta
    @Override
    public void accelerate() {
        if (fuel > 0) {
            speed += 20; // Lisää nopeutta 20 km/h
            fuel -= 10;  // Kuluttaa polttoainetta 10 litraa
        } else {
            System.out.println("Out of fuel!");
        }
    }

    // Hidastuminen voi pysyä samana kuin tavallisessa autossa
}

public class Main {
    public static void main(String[] args) {
        Car normalCar = new Car();
        SportsCar fastCar = new SportsCar();

        System.out.println("Normal Car:");
        normalCar.accelerate();
        normalCar.displayStatus();

        System.out.println("\nSports Car:");
        fastCar.accelerate();
        fastCar.displayStatus();
    }
}
