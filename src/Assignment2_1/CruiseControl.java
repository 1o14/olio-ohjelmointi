package Assignment2_1;

// Vehicle class with cruise control feature
class Vehicle {
    private String carModel;
    private int carYear;
    private double fuelTankCapacity;
    private double maxSpeed;
    private double currentSpeed;
    private double cruiseTargetSpeed;
    private boolean isCruiseControlActive;
    private final double minAllowedSpeed = 10.0;   // Minimum speed that can be set
    private final double maxAllowedSpeed = 180.0;  // Maximum speed that can be set

    // Constructor that initializes vehicle details
    public Vehicle(String carModel, int carYear, double fuelTankCapacity, double maxSpeed) {
        this.carModel = carModel;
        this.carYear = carYear;
        this.fuelTankCapacity = fuelTankCapacity;
        this.maxSpeed = maxSpeed;
        this.currentSpeed = 0;  // Initially, the vehicle is stationary
        this.cruiseTargetSpeed = 0;   // Initially, no cruise target speed
        this.isCruiseControlActive = false; // Cruise control is off initially
    }

    // Method to turn on cruise control if the target speed is within the allowed range
    public boolean activateCruiseControl() {
        if (cruiseTargetSpeed >= minAllowedSpeed && cruiseTargetSpeed <= maxAllowedSpeed) {
            isCruiseControlActive = true;
            accelerateToCruiseTargetSpeed();
            return true;  // Success
        } else {
            isCruiseControlActive = false;
            return false; // Target speed is out of allowed range
        }
    }

    // Method to set the cruise target speed, but only if it's within the allowed range
    public void setCruiseTargetSpeed(double speed) {
        if (speed >= minAllowedSpeed && speed <= maxAllowedSpeed) {
            cruiseTargetSpeed = speed;
            System.out.println("Cruise target speed set to " + cruiseTargetSpeed + " km/h");
        } else {
            System.out.println("Invalid speed. Please set a speed between " + minAllowedSpeed + " and " + maxAllowedSpeed + " km/h.");
        }
    }

    // Internal method to accelerate the vehicle towards the target speed
    private void accelerateToCruiseTargetSpeed() {
        if (isCruiseControlActive) {
            while (currentSpeed < cruiseTargetSpeed) {
                currentSpeed += 5;  // Accelerate by 5 km/h at a time
                System.out.println("Accelerating... Current speed: " + currentSpeed + " km/h");
            }
            System.out.println("Cruise control is now at target speed: " + cruiseTargetSpeed + " km/h");
        }
    }

    // Method to turn off cruise control
    public void deactivateCruiseControl() {
        isCruiseControlActive = false;
        System.out.println("Cruise control turned off.");
    }

    // Method to get the current speed of the vehicle
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    // Method to get the current cruise target speed
    public double getCruiseTargetSpeed() {
        return cruiseTargetSpeed;
    }

    // Method to display the vehicle information
    public void displayVehicleInfo() {
        System.out.println("Vehicle model: " + carModel);
        System.out.println("Year: " + carYear);
        System.out.println("Fuel Tank Capacity: " + fuelTankCapacity + " liters");
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

// Main class that tests the Vehicle class with cruise control functionality
public class CruiseControl {
    public static void main(String[] args) {
        // Creating a Vehicle object
        Vehicle myVehicle = new Vehicle("Audi Q7", 2020, 65.0, 220);

        // Displaying the vehicle details
        myVehicle.displayVehicleInfo();

        // Setting the target speed and turning on cruise control
        myVehicle.setCruiseTargetSpeed(130);  // Setting target speed to 130 km/h
        boolean cruiseControlStatus = myVehicle.activateCruiseControl();

        // Checking if cruise control was successfully activated
        if (cruiseControlStatus) {
            System.out.println("Cruise control is on, vehicle is accelerating...");
        } else {
            System.out.println("Failed to activate cruise control. Target speed not valid.");
        }

        // Displaying the current speed
        System.out.println("Current speed: " + myVehicle.getCurrentSpeed() + " km/h");

        // Turning off cruise control
        myVehicle.deactivateCruiseControl();

        // Displaying the current speed after cruise control is turned off
        System.out.println("Current speed after cruise control off: " + myVehicle.getCurrentSpeed() + " km/h");
    }
}
