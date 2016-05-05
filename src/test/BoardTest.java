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
import sample.StatBoard;

import static org.junit.Assert.*;

@Deprecated
public class BoardTest {


    /**
     * Board Test class has a default constructor
     * that receives no arguments.
     *
     * @author Rudi André Dahle
     * @coauthor Olav Smevoll
     * @coauthor Ginelle Ignacio
     */
    public BoardTest(){

    }

    //Object
    Board statBoard = new StatBoard();

    /**
     * The initial setup of a game board used for testing the
     * functionality of the static game board.
     *
     * @author Rudi André Dahle
     * @coauthor Olav Smevoll
     * @coauthor Ginelle Ignacio
     * @throws Exception if an error occurs while testing
     */
    @Before
    public void setUp() throws Exception {
        boolean[][] gameBoard = {
                {false, true, false},
                {false, false, true},
                {true, true, true},
        };
        statBoard.setGameBoard(gameBoard);
    }


    /**
     * Method called to test the result of the logic test
     * of the next generation when using a static board.
     *
     * @author Rudi André Dahle
     * @coauthor Ginelle Ignacio
     * @coauthor Olav Smevoll
     * @throws Exception if an error occurs while testing
     */
    @Test
    public void testNextGeneration() throws Exception {
        String expected = "010001111";
        assertEquals(expected, statBoard.toString());
    }



}