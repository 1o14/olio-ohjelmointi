package Assignment8_2_2;

import java.util.HashMap;
import java.util.Map;

// Ostoskori-luokka, joka mahdollistaa tuotteiden lisäyksen, poiston ja kokonaishinnan laskemisen
public class ShoppingCart {
    private Map<String, Double> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    // Lisää tuote ostoskoriin
    public void addItem(String itemName, double price) {
        items.put(itemName, price);
    }

    // Poistaa tuotteen ostoskorista
    public void removeItem(String itemName) {
        items.remove(itemName);
    }

    // Laskee ostoskorin kokonaishinnan
    public double calculateTotal() {
        double total = 0.0;
        for (double price : items.values()) {
            total += price;
        }
        return total;
    }

    // Palauttaa ostoskorissa olevien tuotteiden määrän
    public int getItemCount() {
        return items.size();
    }
}
