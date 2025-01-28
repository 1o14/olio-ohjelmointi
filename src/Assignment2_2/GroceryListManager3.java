package Assignment2_2;

import java.util.HashMap;
import java.util.ArrayList;

public class GroceryListManager3 {
    // HashMap, jossa avaimena kategoria ja arvona lista tuotteista
    private HashMap<String, ArrayList<String>> groceryListByCategory = new HashMap<>();
    private HashMap<String, Double> itemCosts = new HashMap<>(); // Säilyttää tuotteen hinnan

    // Lisää kohde, sen hinta ja kategoria ostoslistalle
    public void addItem(String item, double cost, String category) {
        // Tarkistetaan, onko kategoria jo olemassa, jos ei, luodaan uusi lista
        groceryListByCategory.putIfAbsent(category, new ArrayList<>());
        groceryListByCategory.get(category).add(item);
        itemCosts.put(item, cost);
    }

    // Näyttää kaikki kohteet annetussa kategoriassa
    public void displayByCategory(String category) {
        if (groceryListByCategory.containsKey(category)) {
            System.out.println(category + " category items:");
            int index = 1;
            for (String item : groceryListByCategory.get(category)) {
                System.out.println(index + ". " + item + " - $" + itemCosts.get(item));
                index++;
            }
        } else {
            System.out.println("No items found in the " + category + " category.");
        }
    }

    // Pääohjelma
    public static void main(String[] args) {
        GroceryListManager3 manager = new GroceryListManager3();

        // Lisätään kohteita ja kategorioita
        manager.addItem("Apples", 1.99, "Fruits");
        manager.addItem("Bananas", 2.49, "Fruits");
        manager.addItem("Milk", 2.49, "Dairy");
        manager.addItem("Bread", 3.19, "Bakery");

        // Näytetään tuotteet kategorian mukaan
        manager.displayByCategory("Fruits");
        manager.displayByCategory("Dairy");
        manager.displayByCategory("Bakery");
        manager.displayByCategory("Vegetables"); // Esimerkki, kun kategoriaa ei löydy
    }
}
