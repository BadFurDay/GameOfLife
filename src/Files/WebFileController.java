package Files;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Ginelle on 4/5/2016.
 */

public class WebFileController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }

    @FXML private TextField field;
    @FXML private Button submit;
    @FXML private Button clear;
    @FXML private Label label;


    public void fieldEvent(ActionEvent actionEvent){

    }

    @FXML
    public void submitEvent(ActionEvent actionEvent){

    }


    @FXML
    public void clearEvent(ActionEvent actionEvent){
        field.clear();
    }

    @FXML
    public void label (ActionEvent actionEvent){
        if(field.getText() != null && !field.getText().isEmpty()) {
            label.setText("Reading file from web..");
        } else {
            label.setText("No URL was inserted!");
        }
    }

}
