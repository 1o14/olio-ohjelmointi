package Assignment7_4.model;

import jakarta.persistence.*;

@Entity // Määritetään JPA-entiteetiksi
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tietokanta generoi ID:n automaattisesti
    private Long id;
    private String abbreviation;
    private String name;
    private double rateToUsd;

    // Tyhjä konstruktori JPA:lle
    public Currency() {}

    // Konstruktori uuden valuutan luomiseksi
    public Currency(String abbreviation, String name, double rateToUsd) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.rateToUsd = rateToUsd;
    }

    // Getterit
    public String getAbbreviation() { return abbreviation; }
    public String getName() { return name; }
    public double getRateToUsd() { return rateToUsd; }
}
