package Assignment3_1_3;

// ShapeCalculator-luokka, joka testaa polymorfismin
public class ShapeCalculator {
    public static void main(String[] args) {
        // Tulostetaan otsikko
        System.out.println("Shape Calculator\n");

        // Luodaan taulukko muodoista
        Shape[] shapes = {
                new Circle(5.0),
                new Rectangle(4.0, 6.0),
                new Triangle(3.0, 8.0)
        };

        // Käydään taulukko läpi ja tulostetaan jokaisen muodon tiedot
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }
}
