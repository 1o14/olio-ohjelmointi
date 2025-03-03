package Assignment6_4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        // Ladataan käyttöliittymä FXML-tiedostosta
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Assignment6_4/view/notebook-view.fxml"));
        Parent root = fxmlLoader.load();

        // Luodaan Scene ja asetetaan ikkuna
        Scene scene = new Scene(root);
        primaryStage.setTitle("Notebook App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
