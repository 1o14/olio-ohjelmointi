package Assignment6_2;

import java.util.Map;

// Ohjain, joka käsittelee valuuttamuunnokset
public class CurrencyController {
    private CurrencyModel model; // Viittaus malliin

    public CurrencyController() {
        model = new CurrencyModel(); // Luodaan valuuttamalli
    }

    // Hakee kaikki valuutat valintalaatikoille
    public Map<String, Currency> getCurrencies() {
        return model.getAllCurrencies();
    }

    // Suorittaa muunnoksen annetulla summalla ja valuutoilla
    public double convert(double amount, String fromCurrency, String toCurrency) {
        return model.convert(amount, fromCurrency, toCurrency);
    }
}

