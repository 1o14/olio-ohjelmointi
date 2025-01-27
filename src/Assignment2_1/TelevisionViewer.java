package Assignment2_1;

class Television {
    private int channel;  // Muuttuja, joka tallentaa nykyisen kanavan numeron

    // Rakentaja, joka asettaa kanavan numeroksi 1 alussa
    public Television() {
        this.channel = 1;
    }

    // Metodi, joka katsoo nykyistä kanavaa ja siirtyy seuraavaan
    public void watch() {
        System.out.println("Watching channel " + channel);
        channel++;  // Siirrytään seuraavalle kanavalle
        if (channel > 10) {
            channel = 1;  // Jos kanava menee yli 10, palataan takaisin kanavaan 1
        }
    }
}

public class TelevisionViewer {
    public static void main(String[] args) {
        Television tv = new Television();  // Luodaan uusi Television-olio

        // Silmukka, joka toistaa 10 päivää
        for (int day = 1; day <= 10; day++) {
            System.out.println("Woke up, day " + day);  // Tulostetaan heräämisviesti

            // Jos päivä on pariton, katsotaan 3 kanavaa, jos parillinen, katsotaan 4 kanavaa
            if (day % 2 == 1) {
                for (int i = 0; i < 3; i++) {
                    tv.watch();  // Katsotaan 3 kanavaa
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    tv.watch();  // Katsotaan 4 kanavaa
                }
            }

            System.out.println("Falling asleep");  // Tulostetaan nukahdusviesti päivän päätteeksi
        }
    }
}
