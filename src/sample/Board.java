/**
 * Board class contains the rules of the game that the cells
 * will follow in order to generate.
 *
 * @author Rudi André Dahle
 * @author Olav Smevoll
 */

package sample;


public abstract class Board {

    //private static Board board;

    //Datafield
    protected int cellsWide = 20;             //Number of cells in gameboard's width
    protected int cellsHigh = cellsWide;    //Number of cells in gameboard's height
    protected int genCounter;               //Number of generations in integer value
    //protected boolean[][] gameBoard;           //Value of game board in boolean 2D array


   /**
    * Board class has a default constructor that
    * receives no arguments.
    */
    public Board() {
    }




    /**
     * Returns the generation counter as a string value
     * to show as label.
     *
     * @author Olav Smevoll
     * @return s Value of generation counter in strings
     */
    public int getGenCounter(){
        //String s = Integer.toString(genCounter);
        return genCounter;
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
     * @author Rudi André Dahle
     * @return cellsWide Returns the cell's width
     */
    public int getBoardWidth() {
        return cellsWide;
    }


    /**
     * Gameboards height in number of cells
     *
     * @author Rudi André Dahle
     * @return cellsHigh Returns the cell's height
     */
    public int getBoardHeight() {
        return cellsHigh;
    }


    /**
     * Gets the value of the game board
     *
     * @author Rudi André Dahle
     * @return gameBoard Returns the value of the
     *                   game board
     */
    public abstract boolean[][] getGameBoard();


    /**
     * Sets the value of the GameBoard
     *
     * @author Rudi André Dahle
     * @param gameBoard Receives the value of the game
     *                  board in boolean 2D array
     */
    public abstract void setGameBoard(boolean[][] gameBoard);

    /**
     * Clears the board when new board is loaded
     * from rle file
     *
     * @author Olav Smevoll
     */
    public abstract void resetBoard();

    /**
     *
     * @author Rudi André Dahle
     */
    public abstract void initByteBoard();

   /**
    * Verifies the logic of the game by counting
    * the cell neighbors in every direction each
    * cell comes in contact with.
    *
    * @param x integer value of the first parameter
    * @param y integer value of the second parameter
    * @return counter Returns the value of counter after
    *         checking the rules
    * @author Olav Smevoll
    */
    protected abstract void countNeighbours(int x, int y);


   /**
    *  Sets the new values in the array for the
    *  next generation.
    *
    *  @author Rudi André Dahle
    */
    public abstract void nextGeneration();

    /**
     *
     * @author Rudi André Dahle
     */
    public abstract void rules();


   /**
    * Sets the state of selected cell to true or false
    *
    * @author Rudi André Dahle
    * @param x
    * @param y
    */
    public abstract void setCellState(int x, int y);


   /**
    * Gets the state of selected cell
    *
    * @author Rudi André Dahle
    * @param x
    * @param y
    * @return
    */
    public abstract boolean getCellState(int x, int y);
}