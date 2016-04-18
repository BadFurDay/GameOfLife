/**
 * Board class contains the rules of the game that the cells
 * will follow in order to generate.
 *
 * @author Rudi André Dahle
 * @author Olav Smevoll
 */

package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;


public class Board {

    private static Board board;

    //Datafield
    //protected GraphicsContext gc;
    private int cellsWide = 100; //Number of cells in gameboards width
    private int cellsHigh = cellsWide/2; //Number of cells in gameboards height
    protected int genCounter;
    public boolean[][] gameBoard;


    //Constructor
    private Board() {
        System.out.println("Antall celler bredde: " + getBoardWidth());
        System.out.println("Antall celler høyde: " + getBoardHeight());
        gameBoard = new boolean[getBoardWidth()][getBoardHeight()];
    }

    public static Board getBoard(){
        if(board == null){
            board = new Board();
        }
        return board;
    }


    /**
     * Counts cell neighbours for next generation.
     *
     * @param x the arrays x position
     * @param y the arrays y position
     * @return counter Returns the value of counter after
     *         checking the rules
     * @author Olav Smevoll on 08.03.2016
     */
    protected int countNeighbours(int x, int y) {
        int counter = 0;
        int blx = gameBoard.length - 1;
        int bly = gameBoard[0].length - 1;

        //Check cell neighbor North-West
        if (x > 0 && y > 0 && gameBoard[x - 1][y - 1]) {
            counter++;
        }

        //Check cell neighbor North
        if (x > 0 && gameBoard[x - 1][y]) {
            counter++;
        }

        //Check cell neighbor North-East
        if (x > 0 && y < bly && gameBoard[x - 1][y + 1]) {
            counter++;
        }

        //Check cell neighbor West
        if (y > 0 && gameBoard[x][y - 1]) {
            counter++;
        }

        //Check cell neighbor East
        if (y < bly && gameBoard[x][y + 1]) {
            counter++;
        }

        //Check cell neighbor South-West
        if (x < blx && y > 0 && gameBoard[x + 1][y - 1]) {
            counter++;
        }

        //Check cell neighbor South
        if (x < blx && gameBoard[x + 1][y]) {
            counter++;
        }

        //Check cell neighbor South-East
        if (x < blx && y < bly && gameBoard[x + 1][y + 1]) {
            counter++;
        }
        return counter;
    }


    /**
     *  Sets the new values in the array for the next generation.
     *
     *  @author Rudi André Dahle on 04.03.2016
     */
    public void nextGeneration(Grid grid) {
        boolean[][] newGameBoard = new boolean[getBoardWidth()][getBoardHeight()];
        for (int x = 0; x < gameBoard.length; x++) {
            for (int y = 0; y < gameBoard[0].length; y++) {
                if (gameBoard[x][y]) {
                    newGameBoard[x][y] = countNeighbours(x, y) == 2 || countNeighbours(x, y) == 3;
                } else newGameBoard[x][y] = countNeighbours(x, y) == 3;
            }
        }
        gameBoard = newGameBoard;
        genCounter++;
    }

    /**
     * Returns the generation counter as a string value
     * to show as label.
     *
     * @author Olav Smevoll
     * @return s Value of generation counter in to strings
     */
    public String getGenCounter(){
        String s = Integer.toString(genCounter);
        return s;
    }

    /**
     * Resets the generation counter to zero when
     * the clear button is fired
     *
     * @author Olav Smevoll
     */
    public void resetGenCount(){
        genCounter = 0;
    }

    /**
     * Gameboard's width in number of cells
     *
     * @author Rudi André Dahle 24.03.16
     * @return cellsWide Returns the cell's width
     */
    public int getBoardWidth() {
        return cellsWide;
    }


    /**
     * Gameboards height in number of cells
     *
     * @author Rudi André Dahle 24.03.16
     * @return cellsHigh Returns the cell's height
     */
    public int getBoardHeight() {
        return cellsHigh;
    }


    /**
     * Sets Gameboard's height
     *
     * @author Rudi André Dahle on 24.03.16
     * @param y Integer value of the board's height
     */
   /* public void setBoardHeight(int y) {
        cellsHigh = y;
    }*/


    /**
     * Created by RudiAndre on 09.03.2016.
     * @return
     */
    /*public int getCanvasHeight() {
        return canvas.heightProperty().intValue();
    }*/


    /**
     * Created by RudiAndre on 09.03.2016.
     * @return
     */
   /* public int getCanvasWidth() {
        return canvas.widthProperty().intValue();
    }*/


    /**
     * Gets the GameBoard
     *
     * @author RudiAndre on 01.03.2016.
     * @return gameBoard
     */
    public boolean[][] getGameBoard() {
        return gameBoard;
    }


    /**
     * Sets the GameBoard
     *
     * @author Rudi André Dahle on 01.03.2016.
     * @param gameBoard
     */
   /* public void setGameBoard(boolean[][] gameBoard) {
        this.gameBoard = gameBoard;
    }*/

    /**
     * Clears the board when new board is loaded from rle file
     *
     * @author Olav
     */
    public void clearBoard(){
        for (int x = 0; x < gameBoard.length; x++) {
            for (int y = 0; y < gameBoard[0].length; y++) {
                gameBoard[x][y] = false;
            }
        }
    }


    /**
     *
     * @author Rudi
     * @return toString
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
            for (int x = 0; x < gameBoard.length; x++) {
                for (int y = 0; y < gameBoard.length; y++) {
                    if (gameBoard[x][y]) {
                        str.append("1");
                    } else {
                        str.append("0");
                    }
                }
            }
        return str.toString();
    }
}