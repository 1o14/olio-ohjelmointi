package Assignment8_1_1;

public class Pen {

    // Värit, joita kynällä voi olla
    public enum Color {
        RED("red"), GREEN("green"), BLUE("blue");

        private final String color;

        // Konstruktori määrittää värin merkkijonoksi
        Color(String color) {
            this.color = color;
        }

        // Muuttaa värin merkkijonoksi
        @Override
        public String toString() {
            return color;
        }
    }

    private Color color;  // Kynän nykyinen väri
    private boolean capOn; // Onko kansi päällä vai ei

    // Oletuskonstruktori, asettaa väriksi punaisen ja kannen päälle
    public Pen() {
        this.color = Color.RED;
        this.capOn = true;
    }

    // Konstruktori, jossa voi valita värin
    public Pen(Color color) {
        this.color = color;
        this.capOn = true;
    }

    // Metodi kannen avaamiseen
    public void capOff() {
        this.capOn = false;
    }

    // Metodi kannen sulkemiseen
    public void capOn() {
        this.capOn = true;
    }

    // Piirtometodi, palauttaa viestin värin mukaan, jos kansi on auki
    public String draw() {
        if (capOn) {
            return ""; // Ei voi piirtää, jos kansi on päällä
        } else {
            return "Drawing " + color.toString();
        }
    }

    // Vaihtaa kynän värin, mutta vain jos kansi on kiinni
    public void changeColor(Color newColor) {
        if (capOn) {
            this.color = newColor;
        }
    }
}
