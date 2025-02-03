package Assignment3_2_4;

// Abstrakti luokka, joka toteuttaa Vehicle-rajapinnan ja sisältää polttoainetehokkuuden
public abstract class AbstractVehicle implements Vehicle {
    // Instanssimuuttuja polttoainetehokkuudelle
    protected double fuelEfficiency;

    // Konstruktori, joka ottaa polttoainetehokkuuden arvon
    public AbstractVehicle(double fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }
}
