package Assignment6_2;

import java.util.HashMap;
import java.util.Map;

// Malli, joka hallinnoi valuuttakursseja
public class CurrencyModel {
    private Map<String, Currency> currencies; // Tallentaa valuutat

    public CurrencyModel() {
        currencies = new HashMap<>();
        // Lisätään esimerkkivaluutat (vaihtokurssi suhteessa USD:hen)
        currencies.put("USD", new Currency("USD", "US Dollar", 1.0));
        currencies.put("EUR", new Currency("EUR", "Euro", 0.92));
        currencies.put("GBP", new Currency("GBP", "British Pound", 0.78));
        currencies.put("JPY", new Currency("JPY", "Japanese Yen", 130.5));
        currencies.put("CAD", new Currency("CAD", "Canadian Dollar", 1.34));
    }

    // Hakee valuutan tiedot koodin perusteella
    public Currency getCurrency(String code) {
        return currencies.get(code);
    }

    // Palauttaa kaikki valuutat
    public Map<String, Currency> getAllCurrencies() {
        return currencies;
    }

    // Laskee muunnoksen kahden valuutan välillä
    public double convert(double amount, String fromCode, String toCode) {
        Currency fromCurrency = getCurrency(fromCode);
        Currency toCurrency = getCurrency(toCode);

        if (fromCurrency == null || toCurrency == null) {
            throw new IllegalArgumentException("Invalid currency code");
        }

        // Muunnetaan ensin USD:ksi ja sitten kohdevaluutaksi
        double amountInUSD = amount / fromCurrency.getRateToUSD();
        return amountInUSD * toCurrency.getRateToUSD();
    }
}

