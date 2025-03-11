package Assignment7_3.view;

import Assignment7_3.controller.CurrencyConverterController;
import Assignment7_3.dao.CurrencyDao;
import Assignment7_3.model.Currency;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.List;

public class CurrencyConverterView extends Application {
    private CurrencyConverterController controller = new CurrencyConverterController();
    private ComboBox<String> fromCurrencyBox = new ComboBox<>();
    private ComboBox<String> toCurrencyBox = new ComboBox<>();
    private TextField amountField = new TextField();
    private Label resultLabel = new Label();

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Convert currency:");
        Button convertButton = new Button("Convert");
        Button addCurrencyButton = new Button("Add Currency");

        updateCurrencyList();

        convertButton.setOnAction(e -> convertCurrency());
        addCurrencyButton.setOnAction(e -> openAddCurrencyWindow());

        VBox vbox = new VBox(10, label, fromCurrencyBox, toCurrencyBox, amountField, convertButton, resultLabel, addCurrencyButton);
        vbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vbox, 300, 250);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Currency Converter");
        primaryStage.show();
    }

    private void convertCurrency() {
        try {
            String from = fromCurrencyBox.getValue();
            String to = toCurrencyBox.getValue();
            double amount = Double.parseDouble(amountField.getText());

            if (from == null || to == null) {
                resultLabel.setText("Error: Select currencies.");
                return;
            }

            double result = controller.convertCurrency(from, to, amount);
            resultLabel.setText("Converted Amount: " + result);
        } catch (NumberFormatException e) {
            resultLabel.setText("Error: Enter a valid number.");
        }
    }

    private void openAddCurrencyWindow() {
        Stage newStage = new Stage();
        TextField abbreviationField = new TextField();
        TextField nameField = new TextField();
        TextField rateField = new TextField();
        Button saveButton = new Button("Save");

        saveButton.setOnAction(e -> {
            controller.addCurrency(abbreviationField.getText(), nameField.getText(), Double.parseDouble(rateField.getText()));
            updateCurrencyList();
            newStage.close();
        });

        VBox vbox = new VBox(10, new Label("Abbreviation:"), abbreviationField,
                new Label("Name:"), nameField, new Label("Rate to USD:"), rateField, saveButton);
        vbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vbox, 300, 250);

        newStage.setScene(scene);
        newStage.setTitle("Add Currency");
        newStage.showAndWait();
    }

    private void updateCurrencyList() {
        CurrencyDao dao = new CurrencyDao();
        List<Currency> currencies = dao.getAllCurrencies();

        fromCurrencyBox.getItems().clear();
        toCurrencyBox.getItems().clear();
        for (Currency currency : currencies) {
            fromCurrencyBox.getItems().add(currency.getAbbreviation());
            toCurrencyBox.getItems().add(currency.getAbbreviation());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
