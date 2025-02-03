package Assignment3_2_4;

// Luokka ElectricCar, joka perii AbstractVehicle-luokan
public class ElectricCar extends AbstractVehicle {

    public ElectricCar(double fuelEfficiency) {
        super(fuelEfficiency);
    }

    @Override
    public double calculateFuelEfficiency() {
        // Palautetaan polttoainetehokkuus (esimerkiksi kWh per kilometer)
        return fuelEfficiency;
    }
}
