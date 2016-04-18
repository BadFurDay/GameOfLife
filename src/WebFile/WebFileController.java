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

import sample.FileHandler;
import sample.Board;
import sample.Alerts;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
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
    FileHandler fileHandler;
    Board gameBoard;
    Alerts error;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Objects
        fileHandler = new FileHandler(gameBoard);
        error = new Alerts();
    }

    @FXML
    public void fieldEvent() {
        field.getText();
    }


    /**
     * Method called to read a URL file submitted by the user.
     * Label will change and show a message of the current
     * situation of the file. Method also includes exceptions.
     *
     * @author Olav Smevoll
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
            /*URL url = new URL(field.getText());
            System.out.println(url.openStream());*/
            String url = field.getText();
            URL destination = new URL(url);
            URLConnection conn = destination.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn
                    .getInputStream()));

            /**String url = field.getText();
            URL destination = new URL(url);
            InputStream is = destination.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

             check*/

            //same method from readGameBoardFromDisk 
            //Located on Package: sample, Class: FileHandler
            String line;
            String rleCode = "";

            while((line = br.readLine()) != null){
                if((line.matches("[b, o, $, !, 0-9]*"))){
                    rleCode = rleCode.concat(line + "\n");
                }
            }

            String finalRle = "";

            Pattern pattern = Pattern.compile("\\d+|[ob]|\\$");
            Matcher matcher = pattern.matcher(rleCode);
            while(matcher.find()){
                int num = 1;
                if(matcher.group().matches("\\d+")){
                    num = Integer.parseInt(matcher.group());
                    System.out.print(num);
                    matcher.find();
                }
                for(int i = 0; i < num; i++){
                    finalRle += matcher.group();
                }
            }
            rleToArray(finalRle);

        } catch (MalformedURLException me){
            error.invalidURL();
        } catch (IOException ie) {
            error.errorConnection();
        } catch (NullPointerException ne){
            error.nullException();
        }
    }


    public void rleToArray(String rle){

        gameBoard.clearBoard();
        int yCounter = 0;
        int xCounter = 0;

        for(int i = 0; i < rle.length(); i++){
            if (rle.charAt(i) == '$'){
                yCounter++;
                xCounter = 0;
            }
            if(rle.charAt(i) == 'b'){
                gameBoard.gameBoard[xCounter][yCounter] = false;
                xCounter++;
            }
            if(rle.charAt(i) == 'o'){
                gameBoard.gameBoard[xCounter][yCounter] = true;
                xCounter++;
            }
        }
        System.out.println("Pattern from web");
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
