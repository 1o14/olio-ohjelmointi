package Assignment7_4.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity // Määritetään JPA-entiteetiksi
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automaattinen ID
    private Long id;

    @ManyToOne // Moni transaktio voi liittyä yhteen valuuttaan
    @JoinColumn(name = "source_currency_id") // Viittaa lähdevaluuttaan
    private Currency sourceCurrency;

    @ManyToOne
    @JoinColumn(name = "target_currency_id") // Viittaa kohdevaluuttaan
    private Currency targetCurrency;

    private double amount; // Muunnettava määrä
    private double convertedAmount; // Muunnoksen tulos
    private LocalDateTime timestamp; // Tallennetaan tapahtuman aikaleima

    // Tyhjä konstruktori JPA:lle
    public Transaction() {}

    // Konstruktori uuden transaktion luomiseksi
    public Transaction(Currency sourceCurrency, Currency targetCurrency, double amount, double convertedAmount) {
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
        this.amount = amount;
        this.convertedAmount = convertedAmount;
        this.timestamp = LocalDateTime.now(); // Aikaleima luodaan automaattisesti
    }
}
