package Assignment7_2.model;

public class Currency {
    private String abbreviation;
    private String name;
    private double rateToUsd;

    // Konstruktorin avulla luodaan valuutta
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
