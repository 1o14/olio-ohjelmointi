package Assignment3_2_3;

// Ajoneuvojen perintähierarkia sähköajoneuvoilla

// Määritellään Vehicle-rajapinta
interface Vehicle {
    void start(); // Käynnistää ajoneuvon
    void stop(); // Pysäyttää ajoneuvon
    String getInfo(); // Palauttaa ajoneuvon tiedot
}

// Määritellään ElectricVehicle-rajapinta
interface ElectricVehicle {
    void charge(); // Lataa sähköajoneuvon
}

// Abstrakti luokka, joka toteuttaa Vehicle-rajapinnan
abstract class AbstractVehicle implements Vehicle, ElectricVehicle {
    protected String type; // Ajoneuvon tyyppi
    protected String fuel; // Polttoaineen tyyppi

    public AbstractVehicle(String type, String fuel) {
        this.type = type;
        this.fuel = fuel;
    }

    @Override
    public void start() {
        System.out.println(type + " is starting...");
    }

    @Override
    public void stop() {
        System.out.println(type + " is stopping...");
    }

    @Override
    public String getInfo() {
        return "Type: " + type + "\nFuel: " + fuel;
    }

    @Override
    public void charge() {
        System.out.println("Charging is not possible for " + type + ".");
    }
}

// Car-luokka perii AbstractVehicle-luokan
class Car extends AbstractVehicle {
    private String color;

    public Car() {
        super("Car", "Petrol");
        this.color = "Red";
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\nColor: " + color;
    }
}

// Motorcycle-luokka perii AbstractVehicle-luokan
class Motorcycle extends AbstractVehicle {
    private String color;

    public Motorcycle() {
        super("Motorcycle", "Gasoline");
        this.color = "Black";
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\nColor: " + color;
    }
}

// Bus-luokka perii AbstractVehicle-luokan
class Bus extends AbstractVehicle {
    private int capacity;

    public Bus() {
        super("Bus", "Diesel");
        this.capacity = 40;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\nCapacity: " + capacity + " passengers";
    }
}

// ElectricCar-luokka perii AbstractVehicle-luokan ja tukee latausta
class ElectricCar extends AbstractVehicle {
    private int batteryCapacity;

    public ElectricCar() {
        super("Electric Car", "Electricity");
        this.batteryCapacity = 75;
    }

    @Override
    public void charge() {
        System.out.println("Electric Car is charging...");
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\nBattery Capacity: " + batteryCapacity + " kWh";
    }
}

// ElectricMotorcycle-luokka perii AbstractVehicle-luokan ja tukee latausta
class ElectricMotorcycle extends AbstractVehicle {
    private int batteryCapacity;

    public ElectricMotorcycle() {
        super("Electric Motorcycle", "Electricity");
        this.batteryCapacity = 20;
    }

    @Override
    public void charge() {
        System.out.println("Electric Motorcycle is charging...");
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\nBattery Capacity: " + batteryCapacity + " kWh";
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
        System.out.println("Bus Information:\n" + bus.getInfo() + "\n");

        ElectricVehicle electricCar = new ElectricCar(); // Luodaan ElectricCar-olio
        electricCar.charge();
        System.out.println("Electric Car Information:\n" + ((Vehicle) electricCar).getInfo() + "\n");

        ElectricVehicle electricMotorcycle = new ElectricMotorcycle(); // Luodaan ElectricMotorcycle-olio
        electricMotorcycle.charge();
        System.out.println("Electric Motorcycle Information:\n" + ((Vehicle) electricMotorcycle).getInfo());
    }
}
