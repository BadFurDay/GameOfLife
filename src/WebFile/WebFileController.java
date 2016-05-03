/**
 * Web Controller is responsible for the controllers in
 * the Web File FXML. This is the "Read Web File" under Menu.
 *
 * @author Olav Smevoll
 * @author Ginelle Ignacio
 */

package WebFile;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import sample.FileHandler;
import sample.Alerts;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;




public class WebFileController implements Initializable {

    //Data field
    @FXML private TextField field;
    @FXML private Button submit;
    @FXML private Button clear;
    @FXML private Label label;

    //Objects
    FileHandler fileHandler = new FileHandler();
    Alerts error = new Alerts();


    /**
     * Web File Controller has a default constructor
     * that receives no arguments.
     */
    public WebFileController(){

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void fieldEvent(ActionEvent actionEvent){
        field.getText();
    }

    /**
     * * Method called when user submits a URL to read.
     * Label will change and show a message of the
     * current situation of the file. Method also includes
     * exceptions.
     *
     * @author Olav Smevoll
     * @author Ginelle Ignacio
     * @param actionEvent represents an Action Event used to
     *                    when a button has been fired.
     */
    @FXML
    public void submitEvent (ActionEvent actionEvent) {
        //Changes the label text
        if (field.getText() != null && !field.getText().isEmpty()) {
            label.setText("Reading file from web..");
        } else {
            label.setText("No URL was inserted!");
        }

        //Reads the content of the URL to convert to RLE file
        try {
            URL url = new URL(field.getText());
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String readFromWeb;
            String rleCode = "";

            while ((readFromWeb = in.readLine()) != null) {
                if ((readFromWeb.matches("[b, o, $, !, 0-9]*"))) {
                    rleCode = rleCode.concat(readFromWeb + "\n");
                }
            }
            //fileHandler.createLoadBoard();
            fileHandler.fromRleToSimplified(rleCode);
        } catch (IOException ie) {
            error.invalidURL();
        } /*catch (NullPointerException ne){
            error.nullException();
        }*/
    }



    /**
     * Method called to clear the text in the text field
     * and removes the text at the bottom of the text field.
     *
     * @author Ginelle Ignacio
     * @param actionEvent represents an Action Event used to
     *                    when a button has been fired.
     */
    @FXML
    public void clearEvent(ActionEvent actionEvent){
        field.clear();
        label.setText(null);
    }

}
