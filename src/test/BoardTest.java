/**
 * This class does the JUit Testing to verify the logic
 * and functionality of the cell generations in the Board
 * class.
 *
 * @author Rudi André Dahle
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
     */
    public BoardTest(){

    }

    //Object
    Board statBoard = new StatBoard();

    /**
     * The initial setup of a game board used for testing the functionality
     * of the game board.
     *
     * @author Rudi André Dahle
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
     * of the next generation.
     *
     * @author Rudi André Dahle
     * @throws Exception if an error occurs while testing
     */
    @Test
    public void testNextGeneration() throws Exception {
        assertEquals("010001111", statBoard.toString());
    }


    //DENNE MÅ UTFØRES VIA GRAPHICS KLASSEN NÅ

    /**
     * Method called to test if the game board resets
     * to its initial value.
     *
     * @author Rudi André Dahle
     * @throws Exception if an error occurs while testing
     */
  /*  @Test
    public void testClearBoard() throws Exception {
        graphics.resetBoard();
        assertEquals("000000000", statBoard.toString());
    }*/


}