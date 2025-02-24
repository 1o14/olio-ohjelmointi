package Assignment6_2;

// Malliluokka, joka tallentaa valuutan tiedot
public class Currency {
    private String code;  // Valuuttakoodi (esim. EUR, USD)
    private String name;  // Valuutan nimi (esim. Euro, US Dollar)
    private double rateToUSD;  // Vaihtokurssi USD:hen

    public Currency(String code, String name, double rateToUSD) {
        this.code = code;
        this.name = name;
        this.rateToUSD = rateToUSD;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getRateToUSD() {
        return rateToUSD;
    }
}
