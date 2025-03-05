package Assignment7_2.view;

import Assignment7_2.controller.CurrencyConverterController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverterView {
    private CurrencyConverterController controller;

    public CurrencyConverterView() {
        this.controller = new CurrencyConverterController();

        // Luodaan käyttöliittymä (GUI)
        JFrame frame = new JFrame("Currency Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(4, 2, 10, 10));  // Lisää välejä kenttien väliin

        JTextField amountField = new JTextField();
        JTextField fromField = new JTextField();
        JTextField toField = new JTextField();
        JLabel resultLabel = new JLabel("Tulos: ");
        JButton convertButton = new JButton("Muunna");

        // Lisää komponentit käyttöliittymään
        frame.add(new JLabel("Määrä:"));
        frame.add(amountField);
        frame.add(new JLabel("Lähtövaluutta (USD, EUR...):"));
        frame.add(fromField);
        frame.add(new JLabel("Kohdevaluutta (USD, EUR...):"));
        frame.add(toField);
        frame.add(convertButton);
        frame.add(resultLabel);

        // ActionListener, joka käsittelee konversion
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Haetaan käyttäjän syöttämät tiedot
                    double amount = Double.parseDouble(amountField.getText());
                    String from = fromField.getText().toUpperCase();
                    String to = toField.getText().toUpperCase();

                    // Kutsutaan controllerin konversion metodia
                    double result = controller.convertCurrency(from, to, amount);
                    if (result != -1) {
                        resultLabel.setText("Tulos: " + result);
                    } else {
                        resultLabel.setText("Virhe valuutan hakemisessa!");
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Virheellinen numero!");
                }
            }
        });

        // Asetetaan ikkuna näkyväksi
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CurrencyConverterView();  // Käynnistetään käyttöliittymä
    }
}
