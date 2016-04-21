/**
 * Compilation of Error Windows that will appear when
 * the program catches an error when choosing files
 * from disc and web.
 *
 * @author Ginelle Ignacio
 */

package sample;

import javafx.scene.control.Alert;


public class Alerts {

    /**
     * Alert's default constructor receives no argument.
     *
     * @author Ginelle Ignacio
     */
    public Alerts(){

    }



    /**
     * Error dialog to notify user that the chosen file is not found.
     *
     * @author Ginelle Ignacio
     */
    public void fileNotFound(){
        Alert fnf = new Alert(Alert.AlertType.ERROR);
        fnf.setTitle("Error");
        fnf.setHeaderText("File not found!");
        fnf.setContentText("The file may be empty or does not exist." +
                " Choose another file.\t");
        fnf.show();
     }


    /**
     * Error dialog to notify user that a problem occurred
     * opening the file.
     *
     * @author Ginelle Ignacio
     */
    public void errorOpeningfile(){
        Alert eof = new Alert (Alert.AlertType.ERROR);
        eof.setTitle("Error");
        eof.setHeaderText("Error opening file!");
        eof.setContentText("There was a error in opening the file." +
                " Choose another file.\t");
        eof.show();
    }


    /**
     * Error dialog to notify user that the file chosen
     * is not a RLE format.
     *
     * @author Ginelle Ignacio
     */
    public void incorrectMatch(){
        Alert incorrect = new Alert(Alert.AlertType.ERROR);
        incorrect.setTitle("Error");
        incorrect.setHeaderText("File format does not match!");
        incorrect.setContentText("File format must be RLE. Choose another file.\t");
        incorrect.show();
    }


    /**
     * Error dialog to notify user that a problem occurred
     * from reading the file.
     *
     * @author Ginelle Ignacio
     */
    public void errorReading(){
        Alert er = new Alert(Alert.AlertType.ERROR);
        er.setTitle("Error");
        er.setHeaderText("Error reading from file!");
        er.setContentText("There was an error reading from the file." +
                " Check if file content is correct or choose another file.\t");
        er.show();
    }


    /**
     * Error dialog to notify the user that URL submitted
     * is invalid.
     *
     * @author Ginelle Ignacio
     */
    public void invalidURL(){
        Alert invalid = new Alert(Alert.AlertType.ERROR);
        invalid.setTitle("Error");
        invalid.setHeaderText("Error reading web address!");
        invalid.setContentText("The URL that you entered may no longer exist or is invalid." +
                " Enter a new web address.\t");
        invalid.show();
    }


    /**
     * Error dialog to notify the user that a problem occurred
     * from reading the web address.
     *
     * @author Ginelle Ignacio
     */
    public void errorConnection(){
        Alert ec = new Alert(Alert.AlertType.ERROR);
        ec.setTitle("Error");
        ec.setHeaderText("Problem opening URL connection!");
        ec.setContentText("There was an error connecting to the web address you entered.\t");
        ec.show();
    }


    /**
     * Error dialog to notify the user that an Array Index Out of Bounds
     * Exception has occurred while reading the file.
     *
     * @author Ginelle Ignacio
     */
    public void arrayException(){
        Alert arrayE = new Alert(Alert.AlertType.ERROR);
        arrayE.setTitle("Error");
        arrayE.setHeaderText("An array exception has been found!");
        arrayE.setContentText("The program is trying to access an element at an index that" +
                " is outside of the array bounds causing the program to crash. " +
                "You may want to choose another file. \t");
        arrayE.show();
    }

    /**
     * Error dialog to notify the user that a Null Pointer Exception
     * has occurred.
     *
     * @author Ginelle Ignacio
     */
    public void nullException(){
        Alert nullPointer = new Alert(Alert.AlertType.ERROR);
        nullPointer.setTitle("Error");
        nullPointer.setHeaderText("A null pointer exception has been found!");
        nullPointer.setContentText("The program is accessing a null element causing the " +
                "program to crash. You may want to choose another URL. \t");
        nullPointer.show();
    }


    /**
     * Error dialog to notify the user that there were
     * no file chosen.
     *
     * @author Ginelle Ignacio
     */
    public void noFile(){
        Alert nf = new Alert(Alert.AlertType.ERROR);
        nf.setTitle("Error");
        nf.setHeaderText(null);
        nf.setContentText("No file was chosen!");
        nf.show();
    }

}
