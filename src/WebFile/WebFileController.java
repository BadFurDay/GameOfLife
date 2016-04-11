/**
 * Web Controller is responsible for the controllers in
 * the Web File FXML. This is the "Read Web File" under Menu.
 *
 * @author Ginelle Ignacio
 */

package WebFile;

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
    @FXML protected TextField field;
    protected Button submit;
    @FXML protected Button clear;
    @FXML protected Label label;

    /**
     *
     * @param actionEvent represents an Action Event used to
     *                    when a button has been fired.
     */
    public void fieldEvent(ActionEvent actionEvent){
        field.getText();
    }

    /**
     * Method called when user submits a URL to be read.
     *
     * @param actionEvent represents an Action Event used to
     *                    when a button has been fired.
     */
    public void submitEvent (ActionEvent actionEvent){
        if (field.getText() != null && !field.getText().isEmpty()) {
            label.setText("Reading file from web..");
        } else {
            label.setText("Text field is empty! No URL was inserted.");
        }
    }


    /**
     * Method called to clear the text in the text field.
     *
     * @author Ginelle Ignacio
     * @param actionEvent represents an Action Event used to
     *                    when a button has been fired.
     */
    public void clearEvent(ActionEvent actionEvent){
    if(clear.isPressed()) {
        field.clear();
        label.setText(null);
        }
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
    public void label (ActionEvent actionEvent){

    }

}
