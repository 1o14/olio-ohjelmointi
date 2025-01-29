package Assignment3_1_4;

// ShapeCalculator-luokka, joka testaa polymorfismin
public class ShapeCalculator {
    public static void main(String[] args) {
        // Tulostetaan otsikko
        System.out.println("Shape Calculator\n");

        // Luodaan taulukko muodoista (nyt myös väri mukana)
        Shape[] shapes = {
                new Circle(5.0, "Red"),
                new Rectangle(4.0, 6.0, "Blue"),
                new Triangle(3.0, 8.0, "Green")
        };

        // Käydään taulukko läpi ja tulostetaan jokaisen muodon tiedot
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }
}
