package Assignment2_1;

// Car-luokka
class Car {
    private String model;  // Auton malli
    private int year;      // Auton valmistusvuosi
    private double fuelCapacity;  // Bensatankin kapasiteetti litroina
    private double topSpeed;      // Huippunopeus km/h

    // Alkuperäinen rakentaja, joka asettaa vain mallin ja vuoden
    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    // Uusi rakentaja, joka ottaa vastaan mallin, vuoden, bensatankin kapasiteetin ja huippunopeuden
    public Car(String model, int year, double fuelCapacity, double topSpeed) {
        this.model = model;
        this.year = year;
        this.fuelCapacity = fuelCapacity;
        this.topSpeed = topSpeed;
    }

    // Getterit ja setterit
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(double topSpeed) {
        this.topSpeed = topSpeed;
    }

    // Metodi, joka tulostaa auton tiedot
    public void displayCarInfo() {
        System.out.println("Car model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Fuel Capacity: " + fuelCapacity + " liters");
        System.out.println("Top Speed: " + topSpeed + " km/h");
    }
}

// Pääohjelma
public class CarMain {
    public static void main(String[] args) {
        // Käytetään alkuperäistä rakentajaa
        Car car1 = new Car("Toyota Corolla", 2020);
        car1.displayCarInfo();  // Tulostetaan auton tiedot

        // Käytetään uutta rakentajaa, jossa on mukana bensatankin kapasiteetti ja huippunopeus
        Car car2 = new Car("Tesla Model 3", 2022, 50.0, 261);
        car2.displayCarInfo();  // Tulostetaan auton tiedot
    }
}
