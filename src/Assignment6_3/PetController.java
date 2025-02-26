package Assignment6_3;

import javax.swing.*;

public class PetController {
    public static void updatePetPosition(Pet pet, int mouseX, int mouseY) {
        pet.moveTowards(mouseX, mouseY); // Päivittää lemmikin sijainnin
    }

    public static void main(String[] args) {
        // Luodaan lemmikki aloituspaikkaan (100,100)
        Pet pet = new Pet(100, 100);
        JFrame frame = new JFrame("Virtual Pet"); // Luodaan ikkuna
        PetView petView = new PetView(pet); // Luodaan näkymä

        frame.add(petView);
        frame.setSize(500, 500); // Ikkunan koko
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); // Ei voi muuttaa kokoa
        frame.setVisible(true); // Näytetään ikkuna
        frame.repaint(); // Pakottaa ruudun piirtämisen
    }
}