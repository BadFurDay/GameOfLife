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


    /**
     * Error dialog to notify the user that an error occurred
     * while opening the window.
     *
     * @author Ginelle Ignacio
     */
    public void notLoading(){
        Alert window = new Alert(Alert.AlertType.ERROR);
        window.setTitle("Error");
        window.setHeaderText("An error just occurred");
        window.setContentText("An error occurred while opening the window. " +
                "Try restarting the program.\t");
        window.show();
    }


    /**
     *  Error dialog to notify the user that the program
     *  catched an Index Out of Bounds Exception.
     *
     * @author Ginelle Ignacio
     */
    public void indexOutOfBounds(){
        Alert ib = new Alert(Alert.AlertType.ERROR);
        ib.setTitle("Error");
        ib.setHeaderText("The cell pattern is defined outside of the board!");
        ib.setContentText("The current board is a static class and can not be changed" +
                " to a bigger board. You may want to choose to change the board into" +
                " dynamic to suit the chosen cell pattern. \t");
        ib.show();
    }
}
