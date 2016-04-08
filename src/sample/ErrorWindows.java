package sample;

import javafx.scene.control.Alert;

/**
 * Compilation of Error Dialogs that will appear after identifying
 * exceptions when choosing files from disc and web.
 *
 * Created by Ginelle on 4/8/2016.
 */

public class ErrorWindows {

    /**
     * Error dialog to notify user that the chosen file is not found.
     *
     * @author Ginelle
     */
    public void fileNotFound(){
        Alert fnf = new Alert(Alert.AlertType.ERROR);
        fnf.setTitle("Error");
        fnf.setHeaderText("File not found!");
        fnf.setContentText("The file may be empty or does not exist." +
                "Choose another file.");
    }


    /**
     * Error dialog to notify user that a problem occured opening the file.
     *
     * @author Ginelle
     */
    public void errorOpeningfile(){
        Alert eof = new Alert (Alert.AlertType.ERROR);
        eof.setTitle("Error");
        eof.setHeaderText("Error opening file!");
        eof.setContentText("There was a error in opening the file." +
                "Choose another file.");
    }


    /**
     * Error dialog to notify user that the file chosen is not a RLE format.
     *
     * @author Ginelle
     */
    public void incorrectMatch(){
        Alert incorrect = new Alert(Alert.AlertType.ERROR);
        incorrect.setTitle("Error");
        incorrect.setHeaderText("File format does not match!");
        incorrect.setContentText("File format must be RLE. Choose another file.");
    }


    /**
     * Error dialog to notify user that a problem occurred
     * from reading the file.
     *
     * @author Ginelle
     */
    public void errorReading(){
        Alert er = new Alert(Alert.AlertType.ERROR);
        er.setTitle("Error");
        er.setHeaderText("Error reading from file!");
        er.setContentText("There was an error reading from the file." +
                "Check if file content is correct or choose another file.");
    }


    /**
     * Error dialog to notify the user that URL submitted is invalid.
     *
     * @author Ginelle
     */
    public void invalidURL(){
        Alert invalid = new Alert(Alert.AlertType.ERROR);
        invalid.setTitle("Error");
        invalid.setHeaderText("Invalid web address!");
        invalid.setContentText("The URL that you entered may no longer exist or is invalid." +
                "Enter a valid web address.");
    }


    /**
     * Error dialog to notify the user that a problem occurred
     * from reading the web address.
     *
     * @author Ginelle
     */
    public void errorConnection(){
        Alert ec = new Alert(Alert.AlertType.ERROR);
        ec.setTitle("Error");
        ec.setHeaderText("Problem opening URL connection!");
        ec.setContentText("There was an error connecting to the web address you entered.");
    }

}
