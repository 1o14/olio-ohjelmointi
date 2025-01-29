package Assignment3_1_3;

// Circle-luokka, joka perii Shape-luokan
class Circle extends Shape {
    private double radius;

    // Konstruktori
    public Circle(double radius) {
        this.radius = radius;
    }

    // Pinta-alan laskenta
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Tulostuksen muotoilu
    public String toString() {
        return "Area of Circle with radius " + radius + ": " + calculateArea();
    }
}
