package Assignment5_2_1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Random;

class Theater {
    private int availableSeats;
    private final Lock lock = new ReentrantLock(); // Lukko varauksien hallintaan

    public Theater(int seats) {
        this.availableSeats = seats;
    }

    public void reserveSeat(String customer, int tickets) {
        lock.lock(); // Lukitaan ennen varausta
        try {
            if (availableSeats >= tickets) {
                availableSeats -= tickets; // Vähennetään varattujen paikkojen määrä
                System.out.println(customer + " reserved " + tickets + " tickets.");
            } else {
                System.out.println(customer + " couldn't reserve " + tickets + " tickets.");
            }
        } finally {
            lock.unlock(); // Vapautetaan lukko
        }
    }
}

class Customer extends Thread {
    private final Theater theater;
    private final String name;
    private final int tickets;

    public Customer(Theater theater, String name, int tickets) {
        this.theater = theater;
        this.name = name;
        this.tickets = tickets;
    }

    @Override
    public void run() {
        theater.reserveSeat(name, tickets); // Asiakas yrittää varata paikan
    }
}

public class TicketReservationSystem {
    public static void main(String[] args) {
        Theater theater = new Theater(5); // Luodaan teatteri, jossa on 5 paikkaa
        Random random = new Random();

        // Luodaan useita asiakkaita, jotka yrittävät varata paikkoja
        for (int i = 1; i <= 15; i++) {
            int ticketsToReserve = random.nextInt(4) + 1; // Jokainen asiakas yrittää varata 1-4 lippua
            new Customer(theater, "Customer " + i, ticketsToReserve).start();
        }
    }
}
