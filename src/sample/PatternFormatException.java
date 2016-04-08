package sample;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by OlavMagneSmevoll on 01.04.2016.
 */
public class PatternFormatException extends Exception {

    //Objects
    Stage readWeb;


    public void readURL() {
        try {
            Parent webRoot = FXMLLoader.load(getClass().getClassLoader().getResource("Files/Webfile.fxml"));
            readWeb.setTitle("Read web file");
            readWeb.setScene(new Scene(webRoot));
            readWeb.show();
            //reader.readGameBoardFromURL();
        } catch (MalformedURLException me){
            System.err.println("Invalid web address!");
        } catch (IOException ie){
            System.err.println("Problem opening URL connection");
        }
    }
}
