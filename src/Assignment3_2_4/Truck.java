package Assignment3_2_4;

// Luokka Truck, joka perii AbstractVehicle-luokan
public class Truck extends AbstractVehicle {

    public Truck(double fuelEfficiency) {
        super(fuelEfficiency);
    }

    @Override
    public double calculateFuelEfficiency() {
        // Palautetaan polttoainetehokkuus (esimerkiksi liters per kilometer)
        return fuelEfficiency;
    }
}
