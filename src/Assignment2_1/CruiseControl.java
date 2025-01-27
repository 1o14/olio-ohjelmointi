package Assignment2_1;

// Ajoneuvo-luokka, jossa on cruise control -toiminto
class Vehicle {
    private String carModel;  // Auton malli
    private int carYear;  // Auton vuosimalli
    private double fuelTankCapacity;  // Polttoainetankin kapasiteetti
    private double maxSpeed;  // Auton maksiminopeus
    private double currentSpeed;  // Nykyinen nopeus
    private double cruiseTargetSpeed;  // Kohdenopeus cruise controlille
    private boolean isCruiseControlActive;  // Onko cruise control päällä
    private final double minAllowedSpeed = 10.0;   // Miniminopeus, jonka voi asettaa
    private final double maxAllowedSpeed = 180.0;  // Maksiminopeus, jonka voi asettaa

    // Konstruktori, joka alustaa ajoneuvon tiedot
    public Vehicle(String carModel, int carYear, double fuelTankCapacity, double maxSpeed) {
        this.carModel = carModel;
        this.carYear = carYear;
        this.fuelTankCapacity = fuelTankCapacity;
        this.maxSpeed = maxSpeed;
        this.currentSpeed = 0;  // Aluksi auto on paikallaan
        this.cruiseTargetSpeed = 0;   // Aluksi ei ole asetettu kohdenopeutta
        this.isCruiseControlActive = false; // Cruise control on aluksi pois päältä
    }

    // Metodi käynnistää cruise controlin, jos kohdenopeus on sallittujen rajojen sisällä
    public boolean activateCruiseControl() {
        if (cruiseTargetSpeed >= minAllowedSpeed && cruiseTargetSpeed <= maxAllowedSpeed) {
            isCruiseControlActive = true;
            accelerateToCruiseTargetSpeed();  // Käynnistää kiihdytyksen kohdenopeuteen
            return true;  // Onnistunut aktivointi
        } else {
            isCruiseControlActive = false;
            return false; // Kohdenopeus on liian suuri tai pieni
        }
    }

    // Metodi asettaa cruise controlin kohdenopeuden, mutta vain jos se on sallittujen rajojen sisällä
    public void setCruiseTargetSpeed(double speed) {
        if (speed >= minAllowedSpeed && speed <= maxAllowedSpeed) {
            cruiseTargetSpeed = speed;
            System.out.println("Cruise kohdenopeus asetettu: " + cruiseTargetSpeed + " km/h");
        } else {
            System.out.println("Virheellinen nopeus. Aseta nopeus välillä " + minAllowedSpeed + " ja " + maxAllowedSpeed + " km/h.");
        }
    }

    // Sisäinen metodi, joka kiihdyttää ajoneuvoa kohti kohdenopeutta
    private void accelerateToCruiseTargetSpeed() {
        if (isCruiseControlActive) {
            while (currentSpeed < cruiseTargetSpeed) {
                currentSpeed += 5;  // Kiihdytetään 5 km/h joka kerta
                System.out.println("Kiihdytetään... Nykyinen nopeus: " + currentSpeed + " km/h");
            }
            System.out.println("Cruise control on nyt kohdenopeudessa: " + cruiseTargetSpeed + " km/h");
        }
    }

    // Metodi sammuttamaan cruise controlin
    public void deactivateCruiseControl() {
        isCruiseControlActive = false;
        System.out.println("Cruise control pois päältä.");
    }

    // Metodi palauttaa nykyisen nopeuden
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    // Metodi palauttaa kohdenopeuden
    public double getCruiseTargetSpeed() {
        return cruiseTargetSpeed;
    }

    // Metodi tulostaa ajoneuvon tiedot
    public void displayVehicleInfo() {
        System.out.println("Ajoneuvon malli: " + carModel);
        System.out.println("Vuosi: " + carYear);
        System.out.println("Polttoainetankin kapasiteetti: " + fuelTankCapacity + " litraa");
        System.out.println("Maksiminopeus: " + maxSpeed + " km/h");
    }
}

// Pääohjelma, joka testaa ajoneuvo-luokan cruise control -toimintoa
public class CruiseControl {
    public static void main(String[] args) {
        // Luodaan ajoneuvo-objekti
        Vehicle myVehicle = new Vehicle("Audi Q7", 2020, 65.0, 220);

        // Tulostetaan ajoneuvon tiedot
        myVehicle.displayVehicleInfo();

        // Asetetaan kohdenopeus ja käynnistetään cruise control
        myVehicle.setCruiseTargetSpeed(130);  // Asetetaan kohdenopeus 130 km/h
        boolean cruiseControlStatus = myVehicle.activateCruiseControl();

        // Tarkistetaan, käynnistettiinkö cruise control onnistuneesti
        if (cruiseControlStatus) {
            System.out.println("Cruise control päällä, ajoneuvo kiihdyttää...");
        } else {
            System.out.println("Cruise controlin käynnistys epäonnistui. Kohdenopeus ei kelpaa.");
        }

        // Tulostetaan nykyinen nopeus
        System.out.println("Nykyinen nopeus: " + myVehicle.getCurrentSpeed() + " km/h");

        // Sammutetaan cruise control
        myVehicle.deactivateCruiseControl();

        // Tulostetaan nykyinen nopeus cruise controlin sammuttamisen jälkeen
        System.out.println("Nykyinen nopeus cruise controlin sammuttamisen jälkeen: " + myVehicle.getCurrentSpeed() + " km/h");
    }
}
