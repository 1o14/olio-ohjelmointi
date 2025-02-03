package Assignment3_2_1;

// Ajoneuvojen rajapinta ja toteutukset

// Määritellään Vehicle-rajapinta
interface Vehicle {
    void start(); // Käynnistää ajoneuvon
    void stop(); // Pysäyttää ajoneuvon
    String getInfo(); // Palauttaa ajoneuvon tiedot
}

// Car-luokka toteuttaa Vehicle-rajapinnan
class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Car is stopping...");
    }

    @Override
    public String getInfo() {
        return "Type: Car\nFuel: Petrol\nColor: Red";
    }
}

// Motorcycle-luokka toteuttaa Vehicle-rajapinnan
class Motorcycle implements Vehicle {
    @Override
    public void start() {
        System.out.println("Motorcycle is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Motorcycle is stopping...");
    }

    @Override
    public String getInfo() {
        return "Type: Motorcycle\nFuel: Gasoline\nColor: Black";
    }
}

// Bus-luokka toteuttaa Vehicle-rajapinnan
class Bus implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bus is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Bus is stopping...");
    }

    @Override
    public String getInfo() {
        return "Type: Bus\nFuel: Diesel\nCapacity: 40 passengers";
    }
}

// VehicleDemo-luokka, jossa testataan ajoneuvoja
public class VehicleDemo {
    public static void main(String[] args) {
        System.out.println("Vehicle Demonstration\n");

        Vehicle car = new Car(); // Luodaan Car-olio
        car.start();
        car.stop();
        System.out.println("Car Information:\n" + car.getInfo() + "\n");

        Vehicle motorcycle = new Motorcycle(); // Luodaan Motorcycle-olio
        motorcycle.start();
        motorcycle.stop();
        System.out.println("Motorcycle Information:\n" + motorcycle.getInfo() + "\n");

        Vehicle bus = new Bus(); // Luodaan Bus-olio
        bus.start();
        bus.stop();
        System.out.println("Bus Information:\n" + bus.getInfo());
    }
}
