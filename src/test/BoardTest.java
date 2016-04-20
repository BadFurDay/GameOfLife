package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sample.Board;

import static org.junit.Assert.*;

/**
 * Created by RudiAndre on 19.04.2016.
 */
public class BoardTest {
    Board board = new Board();

    @Before
    public void setTest() {
        boolean[][] gameBoard = {
                {false, false, false},
                {true, true, true},
                {false, false, false},
        };
        board.setGameBoard(gameBoard);
    }

    @Test
    public void testNextGeneration() {
        board.nextGeneration();
        org.junit.Assert.assertEquals("010010010", board.toString());
    }

    @Test
    public void testClearBoard() throws Exception {
        board.clearBoard();
        org.junit.Assert.assertEquals("000000000", board.toString());
    }


}