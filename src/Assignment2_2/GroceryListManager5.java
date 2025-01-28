package Assignment2_2;

import java.util.HashMap;
import java.util.ArrayList;

public class GroceryListManager5 {
    // HashMap, jossa avaimena kategoria ja arvona lista tuotteista
    private HashMap<String, ArrayList<String>> groceryListByCategory = new HashMap<>();
    private HashMap<String, Double> itemCosts = new HashMap<>(); // Säilyttää tuotteen hinnan
    private HashMap<String, Integer> itemQuantities = new HashMap<>(); // Seuraa tuotteen määrää

    // Lisää kohde, sen hinta, kategoria ja määrä ostoslistalle
    public void addItem(String item, double cost, String category, int quantity) {
        // Tarkistetaan, onko kategoria jo olemassa, jos ei, luodaan uusi lista
        groceryListByCategory.putIfAbsent(category, new ArrayList<>());
        groceryListByCategory.get(category).add(item);
        itemCosts.put(item, cost);
        itemQuantities.put(item, quantity);
    }

    // Päivittää tuotteen määrän
    public void updateQuantity(String item, int newQuantity) {
        if (itemQuantities.containsKey(item)) {
            itemQuantities.put(item, newQuantity);
            System.out.println("Updated quantity of " + item + " to " + newQuantity);
        } else {
            System.out.println("Item " + item + " not found in the list.");
        }
    }

    // Laskee kaikkien kohteiden hinnan yhteensä (mukaan lukien määrä)
    public double calculateTotalCost() {
        double totalCost = 0.0;
        // Käydään läpi kaikki tuotteet ja lisätään niiden hinnat ja määrät
        for (String item : itemCosts.keySet()) {
            int quantity = itemQuantities.get(item);
            totalCost += itemCosts.get(item) * quantity; // Hinta * määrä
        }
        return totalCost;
    }

    // Näyttää kaikki kohteet annetussa kategoriassa
    public void displayByCategory(String category) {
        if (groceryListByCategory.containsKey(category)) {
            System.out.println(category + " category items:");
            int index = 1;
            for (String item : groceryListByCategory.get(category)) {
                System.out.println(index + ". " + item + " - $" + itemCosts.get(item) + " - Quantity: " + itemQuantities.get(item));
                index++;
            }
        } else {
            System.out.println("No items found in the " + category + " category.");
        }
    }

    // Pääohjelma (Testaa kaikki toiminnot)
    public static void main(String[] args) {
        GroceryListManager5 manager = new GroceryListManager5();

        // Lisätään kohteita eri kategorioihin ja eri määrillä
        manager.addItem("Apples", 1.99, "Fruits", 10);
        manager.addItem("Bananas", 2.49, "Fruits", 8);
        manager.addItem("Milk", 2.49, "Dairy", 5);
        manager.addItem("Bread", 3.19, "Bakery", 3);
        manager.addItem("Cheese", 4.99, "Dairy", 2);

        // Näytetään tuotteet kategorian mukaan
        System.out.println("Original list:");
        manager.displayByCategory("Fruits");
        manager.displayByCategory("Dairy");
        manager.displayByCategory("Bakery");
        manager.displayByCategory("Vegetables"); // Esimerkki, kun kategoriaa ei löydy

        // Lasketaan ja näytetään kokonaishinta
        System.out.println("\nTotal cost: $" + manager.calculateTotalCost());

        // Päivitetään tuotteen määrä ja lasketaan kokonaishinta uudestaan
        manager.updateQuantity("Milk", 10);
        manager.updateQuantity("Apples", 15);

        // Näytetään päivitetty lista ja kokonaishinta
        System.out.println("\nUpdated Grocery List:");
        manager.displayByCategory("Fruits");
        manager.displayByCategory("Dairy");
        manager.displayByCategory("Bakery");

        System.out.println("\nTotal cost after updates: $" + manager.calculateTotalCost());
    }
}
