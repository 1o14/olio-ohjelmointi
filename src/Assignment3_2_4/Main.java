package Assignment3_2_4;

// Pääluokka, jossa testataan ajoneuvoja
public class Main {

    public static void main(String[] args) {
        // Luodaan auto, kuorma-auto ja sähköauto
        Vehicle myCar = new Car(25.5); // 25.5 miles per gallon
        Vehicle myTruck = new Truck(8.2); // 8.2 liters per kilometer
        Vehicle myElectricCar = new ElectricCar(0.15); // 0.15 kWh per kilometer

        // Tulostetaan polttoainetehokkuudet
        System.out.println("Car fuel efficiency: " + myCar.calculateFuelEfficiency() + " miles per gallon");
        System.out.println("Truck fuel efficiency: " + myTruck.calculateFuelEfficiency() + " liters per kilometer");
        System.out.println("Electric Car fuel efficiency: " + myElectricCar.calculateFuelEfficiency() + " kWh per kilometer");
    }
}
