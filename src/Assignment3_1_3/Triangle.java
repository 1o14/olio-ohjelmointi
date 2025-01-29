package Assignment3_1_3;

// Triangle-luokka, joka perii Shape-luokan
class Triangle extends Shape {
    private double base, height;

    // Konstruktori
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    // Pinta-alan laskenta
    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    // Tulostuksen muotoilu
    public String toString() {
        return "Area of Triangle with base " + base + " and height " + height + ": " + calculateArea();
    }
}
