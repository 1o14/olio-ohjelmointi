package Assignment2_1;

// CoffeeMaker-luokka
class CoffeeMaker {
    private boolean isOn;           // Tietää, onko laite päällä vai ei
    private String coffeeType;      // Kahvin tyyppi (normal tai espresso)
    private int coffeeAmount;       // Kahvin määrä (10-80 ml)

    // Rakentaja, joka alustaa laite pois päältä ja valitsee oletusasetukset
    public CoffeeMaker() {
        this.isOn = false;          // Laite on aluksi pois päältä
        this.coffeeType = "normal"; // Oletus kahvin tyyppi on normal
        this.coffeeAmount = 10;     // Oletus kahvin määrä on 10 ml
    }

    // Metodi, joka kytkee laitteen päälle tai pois
    public void togglePower() {
        this.isOn = !this.isOn;     // Kytkee laitteelle päälle tai pois päältä
    }

    // Metodi, joka asettaa kahvin tyypin vain, jos laite on päällä
    public void setCoffeeType(String coffeeType) {
        if (isOn) {                  // Vain jos laite on päällä
            this.coffeeType = coffeeType;
        }
    }

    // Metodi, joka asettaa kahvin määrän vain, jos laite on päällä
    public void setCoffeeAmount(int coffeeAmount) {
        if (isOn && coffeeAmount >= 10 && coffeeAmount <= 80) {  // Vain jos laite on päällä ja määrä on välillä 10-80 ml
            this.coffeeAmount = coffeeAmount;
        }
    }

    // Metodi, joka tulostaa laitteen tilan ja valitut asetukset
    public void displayStatus() {
        if (isOn) {
            System.out.println("Coffee maker is on");
            System.out.println("Coffee type is " + coffeeType);
            System.out.println("Coffee amount is " + coffeeAmount + " ml");
        } else {
            System.out.println("Coffee maker is off");
        }
    }
}

// CoffeeMakerDriver-luokka, joka testaa CoffeeMaker-luokan toiminnallisuutta
public class CoffeeMakerDriver {
    public static void main(String[] args) {
        // Luodaan CoffeeMaker-olio
        CoffeeMaker coffeeMaker = new CoffeeMaker();

        // Kytketään laite päälle
        coffeeMaker.togglePower();
        coffeeMaker.setCoffeeType("espresso");    // Asetetaan kahvin tyyppi
        coffeeMaker.setCoffeeAmount(50);          // Asetetaan kahvin määrä
        coffeeMaker.displayStatus();              // Näytetään tilanne

        // Kytketään laite pois päältä
        coffeeMaker.togglePower();
        coffeeMaker.displayStatus();              // Näytetään tilanne laitteen ollessa pois päältä
    }
}
