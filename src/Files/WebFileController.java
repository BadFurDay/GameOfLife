/**
 * Web Controller is responsible for the controllers in
 * the "Read Web File" under Menu.
 *
 * @author Ginelle Ignacio
 */

package Files;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;



public class WebFileController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }

    //Data field
    @FXML private TextField field;
    @FXML private Button submit;
    @FXML private Button clear;
    @FXML private Label label;


    /**
     *
     * @param actionEvent represents an Action Event used to
     *                    when a button has been fired.
     */
    public void fieldEvent(ActionEvent actionEvent){

    }

    /**
     * Method called when user submits a URL to be read.
     *
     * @param actionEvent represents an Action Event used to
     *                    when a button has been fired.
     */
    @FXML
    public void submitEvent(ActionEvent actionEvent){

    }


    /**
     * Method called to clear the text in the text field.
     *
     * @author Ginelle Ignacio
     * @param actionEvent represents an Action Event used to
     *                    when a button has been fired.
     */
    @FXML
    public void clearEvent(ActionEvent actionEvent){
        field.clear();
    }

    /**
     * Label shows a message of the current situation of the file.
     * Certain messages will appear when the user submits the URL
     * or when the text field submitted is empty.
     *
     * @author Ginelle Ignacio
     * @param actionEvent represents an Action Event used to
     *                    when a button has been fired.
     */
    @FXML
    public void label (ActionEvent actionEvent){
        if(field.getText() != null && !field.getText().isEmpty()) {
            label.setText("Reading file from web..");
        } else {
            label.setText("Text field is empty! No URL was inserted.");
        }
    }

}
