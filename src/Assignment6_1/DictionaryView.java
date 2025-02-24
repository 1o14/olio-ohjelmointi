package Assignment6_1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Pääluokka, jossa käyttöliittymä luodaan
public class DictionaryView extends Application {
    private DictionaryController controller; // Viittaus controlleriin

    @Override
    public void start(Stage primaryStage) {
        controller = new DictionaryController(); // Luodaan ohjain

        // Tekstikenttä sanan hakemiseen
        TextField wordInput = new TextField();
        wordInput.setPromptText("Enter a word");

        // Haku-painike
        Button searchButton = new Button("Search");

        // Tulosalue merkityksen näyttämiseen
        Label resultLabel = new Label();

        // Hakutoiminnallisuus: Kun nappia painetaan, haetaan sana
        searchButton.setOnAction(e -> {
            String word = wordInput.getText(); // Haetaan käyttäjän kirjoittama sana
            String meaning = controller.getMeaning(word); // Haetaan merkitys controllerilta
            resultLabel.setText(meaning); // Näytetään merkitys
        });

        // Layout (VBox asettaa komponentit pystysuunnassa)
        VBox layout = new VBox(10, wordInput, searchButton, resultLabel);
        layout.setStyle("-fx-padding: 20px; -fx-alignment: center;"); // Tyyliä ulkoasuun

        // Luodaan ja näytetään ikkuna
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setTitle("Virtual Dictionary");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // Käynnistetään JavaFX-sovellus
    }
}
