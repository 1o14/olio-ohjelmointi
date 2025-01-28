package Assignment2_2;

import java.util.ArrayList;

public class GroceryListManager {
    // Luodaan lista ostoslistan kohteille
    private ArrayList<String> groceryList = new ArrayList<>();

    // Lisää kohteen ostoslistalle
    public void addItem(String item) {
        if (!groceryList.contains(item)) { // Tarkistaa, ettei kohde ole jo listalla
            groceryList.add(item);
        }
    }

    // Poistaa kohteen ostoslistalta
    public void removeItem(String item) {
        if (groceryList.contains(item)) { // Tarkistaa, että kohde löytyy listalta
            groceryList.remove(item);
        }
    }

    // Näyttää kaikki kohteet ostoslistalta
    public void displayList() {
        System.out.println("Grocery List:");
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + ". " + groceryList.get(i));
        }
    }

    // Tarkistaa, onko kohde ostoslistalla
    public boolean checkItem(String item) {
        return groceryList.contains(item);
    }

    // Pääohjelma
    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();

        // Lisätään muutama kohde
        manager.addItem("Apples");
        manager.addItem("Milk");
        manager.addItem("Bread");

        // Näytetään ostoslista
        manager.displayList();

        // Tarkistetaan, onko tietty kohde listalla
        System.out.println("\nIs \"Milk\" in the grocery list? " + manager.checkItem("Milk"));

        // Poistetaan kohde
        System.out.println("\nRemoving \"Milk\" from the list...");
        manager.removeItem("Milk");

        // Näytetään päivitetty ostoslista
        System.out.println("\nUpdated Grocery List:");
        manager.displayList();
    }
}
