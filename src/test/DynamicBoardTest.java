/**
 * This class does the JUnit Testing to verify the logic
 * and functionality of the cell generations in the Board
 * class.
 *
 * @author Rudi André Dahle
 * @author Olav Smevoll
 * @author Ginelle Ignacio
 */

package test;

import org.junit.Before;
import org.junit.Test;
import sample.Board;
import sample.DynamicBoard;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DynamicBoardTest {

    List<List<Boolean>> gameBoard = new ArrayList<>();


    /**
     * Dynamic Board Test class has a default constructor
     * that receives no arguments.
     *
     * @author Rudi André Dahle
     * @author Ginelle Ignacio
     * @author Olav Smevoll
     */
    public DynamicBoardTest(){

    }

    //Object
    DynamicBoard dynBoard = DynamicBoard.getInstance();


    /**
     * The initial setup of a game board used for testing the
     * functionality of the dynamic game board.
     *
     * @author Rudi André Dahle
     * @author Ginelle Ignacio
     * @author Olav Smevoll
     * @throws Exception if an error occurs while testing
     */
    @Before
    public void setUp() throws Exception {
        dynBoard.setBoardSize(5);
        for (int x = 0; x < 5; x++) {
            List<Boolean> innerArray = new ArrayList<>();
            for(int y = 0; y < 5; y++){
                innerArray.add(false);
            }
            gameBoard.add(innerArray);
        }
        gameBoard.get(1).set(2, true);
        gameBoard.get(2).set(2, true);
        gameBoard.get(3).set(2, true);

        dynBoard.setGameBoard(gameBoard);
    }


    /**
     * Method called to test the result of the logic test
     * of the next generation when using a dynamic board.
     *
     * @author Rudi André Dahle
     * @author Ginelle Ignacio
     * @author Olav Smevoll
     * @throws Exception if an error occurs while testing
     */
    @Test
    public void testNextGeneration() throws Exception {
        String expected  = "0000000100001000010000000";
        assertEquals(expected, dynBoard.toString());
    }
}