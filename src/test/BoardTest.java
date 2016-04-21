/**
 * This class does the JUit Testing ti verify the logic
 * and functionality of the cell generations in the Board
 * class.
 *
 * @author Rudi André Dahle
 */
package test;

import org.junit.Before;
import org.junit.Test;
import sample.Board;

import static org.junit.Assert.*;


public class BoardTest {
    Board board = new Board();

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
                {false, false, false},
                {true, true, true},
                {false, false, false},
        };
        board.setGameBoard(gameBoard);
    }


    /**
     * Method called to test the logic of the next
     * generation.
     *
     * @author Rudi
     * @throws Exception if an error occurs while testing
     */
    @Test
    public void testNextGeneration() throws Exception {
        board.nextGeneration();
        assertEquals("010010010", board.toString());
    }

    /**
     * Method called to test if the game board resets
     * to its initial value.
     *
     * @author Rudi
     * @throws Exception if an error occurs while testing
     */
    @Test
    public void testClearBoard() throws Exception {
        board.clearBoard();
        assertEquals("000000000", board.toString());
    }


}