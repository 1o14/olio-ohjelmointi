package Assignment2_2;

import java.util.HashMap;
import java.util.ArrayList;

public class GroceryListManager4 {
    // HashMap, jossa avaimena kategoria ja arvona lista tuotteista
    private HashMap<String, ArrayList<String>> groceryListByCategory = new HashMap<>();
    private HashMap<String, Double> itemCosts = new HashMap<>(); // Säilyttää tuotteen hinnan
    private HashMap<String, Integer> itemQuantities = new HashMap<>(); // Säilyttää tuotteen määrän

    // Lisää kohde, sen hinta, kategoria ja määrä ostoslistalle
    public void addItem(String item, double cost, String category, int quantity) {
        // Tarkistetaan, onko kategoria jo olemassa, jos ei, luodaan uusi lista
        groceryListByCategory.putIfAbsent(category, new ArrayList<>());
        groceryListByCategory.get(category).add(item);
        itemCosts.put(item, cost);
        itemQuantities.put(item, quantity);
    }

    // Päivittää tuotteen määrän ostoslistalla
    public void updateQuantity(String item, int newQuantity) {
        if (itemQuantities.containsKey(item)) {
            itemQuantities.put(item, newQuantity);
            System.out.println("Updated quantity of " + item + " to " + newQuantity);
        } else {
            System.out.println("Item " + item + " not found in the list.");
        }
    }

    // Näyttää kaikki tuotteet, joiden määrä on positiivinen
    public void displayAvailableItems() {
        System.out.println("Available items with positive quantities:");
        boolean found = false;
        for (String item : itemQuantities.keySet()) {
            int quantity = itemQuantities.get(item);
            if (quantity > 0) {
                System.out.println(item + " - Quantity: " + quantity + " - $" + itemCosts.get(item));
                found = true;
            }
        }
        if (!found) {
            System.out.println("No items with positive quantities.");
        }
    }

    // Pääohjelma
    public static void main(String[] args) {
        GroceryListManager4 manager = new GroceryListManager4();

        // Lisätään kohteita, niiden hinnat, kategoriat ja määrät
        manager.addItem("Apples", 1.99, "Fruits", 10);
        manager.addItem("Bananas", 2.49, "Fruits", 5);
        manager.addItem("Milk", 2.49, "Dairy", 0); // Ei saatavilla
        manager.addItem("Bread", 3.19, "Bakery", 3);

        // Näytetään kaikki saatavilla olevat tuotteet
        manager.displayAvailableItems();

        // Päivitetään tuotteen määrä
        manager.updateQuantity("Milk", 8); // Päivitetään "Milk" saataville

        // Näytetään päivitetty saatavilla oleva lista
        manager.displayAvailableItems();
    }
}
