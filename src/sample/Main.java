/**
 * Main class is responsible for all of the class.
 * The stage of the FXML, Controller and other classes
 * will be called once the program is running.
 *
 * @author Rudi Andre Dahle
 * @author Ginelle Ignacio
 * @author Olav Smevoll
 */
package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    @FXML
    public void start(Stage primaryStage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
            primaryStage.setTitle("Game of Life");
            primaryStage.setScene(new Scene(root));

            primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
