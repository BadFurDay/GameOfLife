/**
 * This class is responsible for catching exceptions
 * related to the RLE format which makes it possible
 * for the user to upload files containing the pattern.
 *
 * @author Ginelle Ignacio
 */

package sample;


public class PatternFormatExceptions extends Exception {


    /**
     * Pattern Format Exception has a default constructor
     * that receives no arguments.
     */
    public PatternFormatExceptions(){

    }

    /**
     * Constructor receives a string message of the alerts
     * that occurred
     *
     * @param message String message of the exception
     */
    public PatternFormatExceptions(String message){
        super(message);
    }

}
