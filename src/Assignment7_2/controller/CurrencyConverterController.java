package Assignment7_2.controller;

import Assignment7_2.dao.CurrencyDao;

public class CurrencyConverterController {
    private CurrencyDao currencyDao;

    public CurrencyConverterController() {
        this.currencyDao = new CurrencyDao();
    }

    // Muuntaa annetun summan valuutasta toiseen
    public double convertCurrency(String from, String to, double amount) {
        // Haetaan valuuttojen vaihtoarvot tietokannasta
        double fromRate = currencyDao.getExchangeRate(from);
        double toRate = currencyDao.getExchangeRate(to);

        // Jos jompikumpi valuutta ei löytynyt tietokannasta, palauta virhe
        if (fromRate == -1 || toRate == -1) {
            System.err.println("Virhe: Valuuttaa ei löydy tietokannasta!");
            return -1;
        }

        // Muunna summa
        return (amount / fromRate) * toRate;
    }
}
