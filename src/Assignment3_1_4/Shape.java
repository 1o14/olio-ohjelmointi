package Assignment3_1_4;

// Shape-luokka, perusmuoto
class Shape {
    protected String color; // Väriominaisuus

    // Konstruktori, joka ottaa värin
    public Shape(String color) {
        this.color = color;
    }

    // Metodi, joka laskee pinta-alan (oletus 0)
    public double calculateArea() {
        return 0;
    }
}
