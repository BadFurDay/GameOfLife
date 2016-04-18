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

import sample.Controller;
import sample.FileHandler;
import sample.Board;
import sample.Alerts;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.Buffer;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class WebFileController implements Initializable {



    //Data field
    @FXML protected TextField field;
    @FXML protected Button submit;
    @FXML protected Button clear;
    @FXML protected Label label;

    //Objects
    FileHandler fileHandler = new FileHandler();
    Alerts error;
    //Controller controller;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Objects
        error = new Alerts();
    }

    @FXML
    public void fieldEvent() {
        field.getText();
    }


    /**
     * Method called when user submits a URL to read.
     * Label will change and show a message of the
     * current situation of the file.
     *
     * @author Ginelle Ignacio
     * @param actionEvent represents an Action Event used to
     *                    when a button has been fired.
     */
    @FXML
    public void submitEvent (ActionEvent actionEvent) throws IOException {
        if (field.getText() != null && !field.getText().isEmpty()) {
            label.setText("Reading file from web..");
        } else {
            label.setText("No URL was inserted!");
        }

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
            fileHandler.fromRleToSimplified(rleCode);

        } catch (MalformedURLException me){
            error.invalidURL();
        } catch (IOException ie) {
            error.errorConnection();
        } catch (NullPointerException ne){

            error.nullException();
            ne.printStackTrace();
        }
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
