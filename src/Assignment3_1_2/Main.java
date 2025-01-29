package Assignment3_1_2;

// Perusautoluokka
class Car {
    protected int speed; // Nopeus km/h
    protected int fuel;  // Polttoaine litraa

    public Car() {
        this.speed = 0;
        this.fuel = 100; // Täysi tankki alussa
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

// Bussiluokka
class Bus extends Car {
    private int passengers;      // Matkustajien määrä
    private final int capacity;  // Maksimikapasiteetti

    public Bus(int capacity) {
        super(); // Kutsuu Car-luokan konstruktoria
        this.capacity = capacity;
        this.passengers = 0;
    }

    // Matkustaja nousee bussiin
    public void passengerEnter() {
        if (passengers < capacity) {
            passengers++;
            System.out.println("Passenger entered. Passengers: " + passengers);
        } else {
            System.out.println("Bus is full!");
        }
    }

    // Matkustaja poistuu bussista
    public void passengerExit() {
        if (passengers > 0) {
            passengers--;
            System.out.println("Passenger exited. Passengers: " + passengers);
        } else {
            System.out.println("No passengers to exit.");
        }
    }

    // Näyttää bussin tilan
    @Override
    public void displayStatus() {
        System.out.println("Speed: " + speed + " km/h, Fuel: " + fuel + " L, Passengers: " + passengers + "/" + capacity);
    }
}

public class Main {
    public static void main(String[] args) {
        Bus cityBus = new Bus(5); // Luodaan bussi, jossa 5 matkustajapaikkaa

        cityBus.passengerEnter();
        cityBus.passengerEnter();
        cityBus.displayStatus();

        cityBus.accelerate();
        cityBus.displayStatus();

        cityBus.passengerExit();
        cityBus.displayStatus();
    }
}
