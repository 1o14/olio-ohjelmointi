package Assignment5_1_1;

class NumberPrinter {
    private int number = 1; // Aloitetaan numerosta 1
    private int max; // Suurin tulostettava numero
    private boolean isOddTurn = true; // Määrittää, onko parittoman numeron vuoro

    public NumberPrinter(int max) {
        this.max = max;
    }

    // Metodi parittomien numeroiden tulostukseen
    public synchronized void printOdd() {
        while (number <= max) {
            while (!isOddTurn) {
                try {
                    wait(); // Odotetaan kunnes on parittoman numeron vuoro
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (number <= max) {
                System.out.println("Odd Thread: " + number);
                number++;
                isOddTurn = false;
                notify(); // Ilmoitetaan parillisen numeron säikeelle
            }
        }
    }

    // Metodi parillisten numeroiden tulostukseen
    public synchronized void printEven() {
        while (number <= max) {
            while (isOddTurn) {
                try {
                    wait(); // Odotetaan kunnes on parillisen numeron vuoro
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (number <= max) {
                System.out.println("Even Thread: " + number);
                number++;
                isOddTurn = true;
                notify(); // Ilmoitetaan parittoman numeron säikeelle
            }
        }
    }
}

public class MultiThreadNumberPrinting {
    public static void main(String[] args) {
        int max = 20; // Määritellään tulostettava lukualue
        NumberPrinter printer = new NumberPrinter(max);

        // Luodaan ja käynnistetään pariton säie
        Thread oddThread = new Thread(() -> printer.printOdd());

        // Luodaan ja käynnistetään parillinen säie
        Thread evenThread = new Thread(() -> printer.printEven());

        oddThread.start();
        evenThread.start();

        // Odotetaan, että molemmat säikeet lopettavat
        try {
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Printing complete.");
    }
}
