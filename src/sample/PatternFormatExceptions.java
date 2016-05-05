/**
 * This class is responsible for catching exceptions
 * related to the RLE format.
 *
 * @author Ginelle Ignacio
 * @coauthor Olav Smevoll
 * @coauthor Ginelle Ignacio
 */

package sample;


public class PatternFormatExceptions extends Exception {


    /**
     * Pattern Format Exception has a default constructor
     * that receives no arguments.
     *
     * @author Ginelle Ignacio
     * @coauthor Rudi André Dahle
     * @coauthor Olav Smevoll
     */
    public PatternFormatExceptions(){

    }

    /**
     * Constructor receives a string message of the alerts
     * that occurred
     *
     * @author Ginelle Ignacio
     * @coauthor Rudi André Dahle
     * @coauthor Olav Smevoll
     * @param message String message of the exception
     */
    public PatternFormatExceptions(String message){
        super(message);
    }
}
