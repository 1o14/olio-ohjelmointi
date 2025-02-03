package Assignment3_2_4;

// Luokka Car, joka perii AbstractVehicle-luokan
public class Car extends AbstractVehicle {

    public Car(double fuelEfficiency) {
        super(fuelEfficiency); // Kutsutaan yläluokan konstruktoria
    }

    // Toteutetaan polttoainetehokkuuden laskeminen
    @Override
    public double calculateFuelEfficiency() {
        // Palautetaan polttoainetehokkuus (esimerkiksi miles per gallon)
        return fuelEfficiency;
    }
}
