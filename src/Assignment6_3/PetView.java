package Assignment6_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;

public class PetView extends JPanel {
    private final Pet pet;
    private final Image petImage;
    private boolean mouseInside = false; // Tieto siitä, onko hiiri canvasin sisällä

    public PetView(Pet pet) {
        this.pet = pet;

        // Ladataan kuva annetusta polusta
        petImage = new ImageIcon("C:\\Users\\biank\\Metropolia\\olio-ohjelmointi\\src\\Assignment6_3\\pet.png").getImage();

        // Tarkistetaan, löytyykö kuva
        if (petImage == null) {
            System.out.println("Kuvaa ei löytynyt! Tarkista polku.");
        }

        // Lisätään kuuntelija hiiren liikkeille
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                mouseInside = true;
                PetController.updatePetPosition(pet, e.getX(), e.getY());
                repaint();
            }
        });

        // Lisätään kuuntelija hiiren poistumiselle
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                mouseInside = false; // Pysäyttää liikkeen, kun hiiri poistuu
            }
        });

        // Aikataulutetaan lemmikin piirto 20 millisekunnin välein
        Timer timer = new Timer(20, e -> {
            if (mouseInside) {
                repaint();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.LIGHT_GRAY); // Harmaa tausta, jotta kuva erottuu

        // Jos kuva löytyy, piirretään se
        if (petImage != null) {
            g.drawImage(petImage, pet.getX(), pet.getY(), 50, 50, this);
            System.out.println("Lemmikki piirretty: " + pet.getX() + ", " + pet.getY()); // Debug-tulostus
        } else {
            System.out.println("Kuvaa ei voi piirtää!");
        }
    }
}
