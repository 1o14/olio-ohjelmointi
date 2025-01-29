package Assignment3_1_4;

// Circle-luokka, joka perii Shape-luokan
class Circle extends Shape {
    private double radius;

    // Konstruktori, joka ottaa säteen ja värin
    public Circle(double radius, String color) {
        super(color); // Kutsuu Shape-luokan konstruktoria
        this.radius = radius;
    }

    // Pinta-alan laskenta
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Tulostus oikeassa muodossa
    public String toString() {
        return "Area of " + color + " Circle with radius " + radius + ": " + calculateArea();
    }
}
