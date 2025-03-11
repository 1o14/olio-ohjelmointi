package Assignment7_4.controller;

import Assignment7_4.dao.CurrencyDao;
import Assignment7_4.dao.TransactionDao;
import Assignment7_4.model.Currency;
import Assignment7_4.model.Transaction;

public class CurrencyConverterController {
    private CurrencyDao currencyDao;
    private TransactionDao transactionDao;

    public CurrencyConverterController() {
        this.currencyDao = new CurrencyDao();
        this.transactionDao = new TransactionDao();
    }

    // Muuntaa annetun summan valuutasta toiseen ja tallentaa transaktion tietokantaan
    public double convertCurrency(String from, String to, double amount) {
        Currency fromCurrency = currencyDao.getCurrencyByCode(from);
        Currency toCurrency = currencyDao.getCurrencyByCode(to);

        // Jos valuuttaa ei löydy, palautetaan virhe
        if (fromCurrency == null || toCurrency == null) {
            System.err.println("Error: Currency not found in the database!");
            return -1;
        }

        // Lasketaan muunnettu summa
        double convertedAmount = (amount / fromCurrency.getRateToUsd()) * toCurrency.getRateToUsd();

        // Tallennetaan transaktio tietokantaan
        Transaction transaction = new Transaction(fromCurrency, toCurrency, amount, convertedAmount);
        transactionDao.addTransaction(transaction);

        return convertedAmount;
    }
}
