package Assignment3_1_3;

// Rectangle-luokka, joka perii Shape-luokan
class Rectangle extends Shape {
    private double width, height;

    // Konstruktori
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Pinta-alan laskenta
    @Override
    public double calculateArea() {
        return width * height;
    }

    // Tulostuksen muotoilu
    public String toString() {
        return "Area of Rectangle with width " + width + " and height " + height + ": " + calculateArea();
    }
}
