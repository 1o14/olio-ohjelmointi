package Assignment6_2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Map;

public class CurrencyView extends Application {
    private CurrencyController controller;

    @Override
    public void start(Stage primaryStage) {
        controller = new CurrencyController();

        // Käyttöliittymän komponentit
        Label titleLabel = new Label("Currency Converter");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        TextField amountField = new TextField();
        amountField.setPromptText("Enter amount");

        ComboBox<String> fromCurrencyBox = new ComboBox<>();
        ComboBox<String> toCurrencyBox = new ComboBox<>();

        // Täytetään valuuttalistat
        Map<String, Currency> currencies = controller.getCurrencies();
        fromCurrencyBox.getItems().addAll(currencies.keySet());
        toCurrencyBox.getItems().addAll(currencies.keySet());

        fromCurrencyBox.setValue("USD"); // Oletuksena USD
        toCurrencyBox.setValue("EUR"); // Oletuksena EUR

        Button convertButton = new Button("Convert");
        Label resultLabel = new Label();

        // Muuntolaskennan käsittely
        convertButton.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                String fromCurrency = fromCurrencyBox.getValue();
                String toCurrency = toCurrencyBox.getValue();

                double convertedAmount = controller.convert(amount, fromCurrency, toCurrency);
                resultLabel.setText(String.format("%.2f %s = %.2f %s",
                        amount, fromCurrency, convertedAmount, toCurrency));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid amount. Enter a valid number.");
            } catch (Exception ex) {
                resultLabel.setText("Error: " + ex.getMessage());
            }
        });

        // Käyttöliittymän asettelu
        VBox layout = new VBox(10, titleLabel, amountField, fromCurrencyBox, toCurrencyBox, convertButton, resultLabel);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-padding: 20px; -fx-font-size: 14px;");

        Scene scene = new Scene(layout, 350, 300);
        primaryStage.setTitle("Currency Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
