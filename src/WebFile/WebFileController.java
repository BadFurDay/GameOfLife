/**
 * Web Controller is responsible for the controllers in
 * the Web File FXML. This is the "Read Web File" under Menu.
 *
 * @author Ginelle Ignacio
 */

package WebFile;

import Main.PatternFormatException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import Main.FileHandler;
import Main.Board;
import Main.Alerts;

import javax.xml.bind.SchemaOutputResolver;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ResourceBundle;
import java.util.Scanner;
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
            BufferedReader br = new BufferedReader(new InputStreamReader(is));*/


           /* String line;
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
            rleToArray(finalRle);*/

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
        System.out.println("Web pattern");
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
