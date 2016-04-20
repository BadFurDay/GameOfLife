/**
 * Main class is responsible for all of the classes.
 * The main window of Game of Life will appear once the
 * programs starts running. Other classes connected to
 * this class will be called when needed.
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

            try {
                Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
                primaryStage.setTitle("Game of Life");
                primaryStage.setScene(new Scene(root));
                primaryStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
