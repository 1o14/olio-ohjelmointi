package Assignment2_2;
import java.util.HashMap;

public class GroceryListManager2 {
    // HashMap, jossa tallennetaan tuotenimi ja hinta
    private HashMap<String, Double> groceryList = new HashMap<>();

    // Lisää kohde ja sen hinta ostoslistalle
    public void addItem(String item, double cost) {
        if (!groceryList.containsKey(item)) { // Tarkistaa, ettei kohde ole jo listalla
            groceryList.put(item, cost);
        }
    }

    // Näyttää kaikki kohteet ja niiden hinnat
    public void displayList() {
        System.out.println("Grocery List:");
        int index = 1;
        for (String item : groceryList.keySet()) {
            System.out.println(index + ". " + item + " - $" + groceryList.get(item));
            index++;
        }
    }

    // Laskee kaikkien kohteiden hinnan yhteensä
    public double calculateTotalCost() {
        double totalCost = 0.0;
        for (double cost : groceryList.values()) {
            totalCost += cost;
        }
        return totalCost;
    }

    // Pääohjelma
    public static void main(String[] args) {
        GroceryListManager2 manager = new GroceryListManager2();

        // Lisätään kohteita listalle
        manager.addItem("Apples", 1.99);
        manager.addItem("Milk", 2.49);
        manager.addItem("Bread", 3.19);

        // Näytetään ostoslista ja hinnat
        manager.displayList();

        // Lasketaan ja näytetään kokonaishinta
        System.out.println("\nTotal cost: $" + manager.calculateTotalCost());
    }
}
