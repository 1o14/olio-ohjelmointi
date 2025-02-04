package Assignment3_3_1;

public class BankAccount {
    // Staattinen muuttuja, joka pitää kirjaa tilien kokonaismäärästä
    private static int totalAccounts = 0;

    // Tilikohtaiset muuttujat: tilinumero ja saldo
    private int accountNumber;
    private double balance;

    // Konstruktori uuden tilin luomiseen
    public BankAccount(double initialBalance) {
        this.accountNumber = ++totalAccounts; // Jokaiselle uudelle tilille annetaan numero
        this.balance = initialBalance; // Asetetaan aloitussaldo
    }

    // Metodi talletuksen tekemiseen
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Talletettu " + amount + " tilille " + accountNumber);
        } else {
            System.out.println("Virheellinen talletussumma!");
        }
    }

    // Metodi noston tekemiseen
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Nostettu " + amount + " tililtä " + accountNumber);
        } else {
            System.out.println("Virheellinen nostosumma tai saldo ei riitä!");
        }
    }

    // Metodi palauttaa tilinumeron
    public int getAccountNumber() {
        return accountNumber;
    }

    // Metodi palauttaa saldon
    public double getBalance() {
        return balance;
    }

    // Staattinen metodi palauttaa tilien kokonaismäärän
    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static void main(String[] args) {
        // Luodaan kaksi pankkitiliä
        BankAccount account1 = new BankAccount(1000);
        BankAccount account2 = new BankAccount(2000);

        // Suoritetaan tilitapahtumia
        account1.deposit(500);
        account2.withdraw(800);

        // Tulostetaan tilitiedot
        System.out.println("Tili " + account1.getAccountNumber() + " saldo: " + account1.getBalance());
        System.out.println("Tili " + account2.getAccountNumber() + " saldo: " + account2.getBalance());

        // Tulostetaan tilien kokonaismäärä
        System.out.println("Tilien kokonaismäärä: " + BankAccount.getTotalAccounts());
    }
}
