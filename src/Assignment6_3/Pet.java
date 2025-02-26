package Assignment6_3;

public class Pet {
    private int x, y; // Lemmikin x- ja y-koordinaatit
    private final int speed = 3; // Lemmikin nopeus (rajoitettu)

    public Pet(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }

    // Palauttaa lemmikin X-koordinaatin
    public int getX() { return x; }

    // Palauttaa lemmikin Y-koordinaatin
    public int getY() { return y; }

    // Metodi, joka liikuttaa lemmikkiä kohti hiiren kursoria
    public void moveTowards(int targetX, int targetY) {
        int dx = targetX - x;
        int dy = targetY - y;
        double distance = Math.sqrt(dx * dx + dy * dy); // Lasketaan etäisyys

        if (distance > speed) { // Liikkuu vain, jos ei ole liian lähellä
            x += (int) (speed * (dx / distance));
            y += (int) (speed * (dy / distance));
        }
    }
}
