package test;

import org.junit.Before;
import org.junit.Test;
import sample.Board;
import sample.DynamicBoard;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by RudiAndre on 05.05.2016.
 */
public class DynamicBoardTest {

    List<List<Boolean>> gameBoard = new ArrayList<>();

    public DynamicBoardTest(){

    }

    //Object
    DynamicBoard dynBoard = DynamicBoard.getInstance();


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

    @Test
    public void testNextGeneration() throws Exception {
        assertEquals("0000000100001000010000000", dynBoard.toString());
    }
}