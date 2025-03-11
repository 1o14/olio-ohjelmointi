package Assignment7_4.view;

import Assignment7_4.controller.CurrencyConverterController;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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

        convertButton.setOnAction(e -> convertCurrency());

        VBox vbox = new VBox(10, label, fromCurrencyBox, toCurrencyBox, amountField, convertButton, resultLabel);
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

            double result = controller.convertCurrency(from, to, amount);
            resultLabel.setText("Converted Amount: " + result);
        } catch (NumberFormatException e) {
            resultLabel.setText("Error: Enter a valid number.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
