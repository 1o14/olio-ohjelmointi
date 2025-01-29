package Assignment3_1_4;

// Triangle-luokka, joka perii Shape-luokan
class Triangle extends Shape {
    private double base, height;

    // Konstruktori, joka ottaa kannan, korkeuden ja värin
    public Triangle(double base, double height, String color) {
        super(color);
        this.base = base;
        this.height = height;
    }

    // Pinta-alan laskenta
    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    // Tulostus oikeassa muodossa
    public String toString() {
        return "Area of " + color + " Triangle with base " + base + " and height " + height + ": " + calculateArea();
    }
}
