package Assignment7_3.controller;

import Assignment7_3.dao.CurrencyDao;
import Assignment7_3.model.Currency;

public class CurrencyConverterController {
    private CurrencyDao currencyDao;

    // Konstruktorissa luodaan CurrencyDao-olio
    public CurrencyConverterController() {
        this.currencyDao = new CurrencyDao();
    }

    // Muuntaa annetun summan valuutasta toiseen
    public double convertCurrency(String from, String to, double amount) {
        Currency fromCurrency = currencyDao.getCurrencyByCode(from);
        Currency toCurrency = currencyDao.getCurrencyByCode(to);

        // Jos valuuttaa ei löydy tietokannasta, palautetaan virhe
        if (fromCurrency == null || toCurrency == null) {
            System.err.println("Error: Currency not found in the database!");
            return -1;
        }

        // Lasketaan muunnettu summa ja palautetaan se
        return (amount / fromCurrency.getRateToUsd()) * toCurrency.getRateToUsd();
    }

    // Lisää uuden valuutan tietokantaan
    public void addCurrency(String abbreviation, String name, double rateToUsd) {
        Currency newCurrency = new Currency(abbreviation, name, rateToUsd);
        currencyDao.addCurrency(newCurrency);
    }
}
