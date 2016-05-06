/**
 * Board class contains the rules of the game that the cells
 * will follow in order to generate.
 *
 * @author Rudi André Dahle
 * @author Olav Smevoll
 * @author Ginelle Ignacio
 */

package sample;


public abstract class Board {

    //Datafield
    protected int initialCells = 25;
    protected int cellsWide = initialCells;
    protected int cellsHigh = cellsWide;
    protected int genCounter;


   /**
    * Board class has a default constructor that
    * receives no arguments.
    */
    public Board() {
    }


    /**
     * Gameboards height in number of cells
     *
     * @author Rudi André Dahle
     * @author Olav Smevoll
     * @author Ginelle Ignacio
     * @return cellsHigh Returns the cell's height
     */
    public int getCellsHigh() {
        return cellsHigh;
    }


    /**
     * Sets the number of cells in the gameboard's height
     *
     * @author Rudi André Dahle
     * @author Olav Smevoll
     * @author Ginelle Ignacio
     * @param cellsHigh Parameter receives an integer
     *                  value of the cell's height.
     */
    public void setCellsHigh(int cellsHigh) {
        this.cellsWide = cellsHigh;
    }


    /**
     * Gameboard's width in number of cells
     *
     * @author Rudi André Dahle
     * @author Olav Smevoll
     * @author Ginelle Ignacio
     * @return cellsWide Returns the cell's width
     */
    public int getCellsWide() {
        return cellsWide;
    }


    /**
     * Sets the number of cell's in the gameboard's width
     *
     * @author Rudi André Dahle
     * @author Olav Smevoll
     * @author Ginelle Ignacio
     * @param cellsWide Parameter receives an integer
     *                  value of the cell's wide
     */
    public void setCellsWide(int cellsWide) {
        this.cellsWide = cellsWide;
    }


    /**
     * Returns the generation counter as a string value
     * to show as label.
     *
     * @author Rudi André Dahle
     * @author Olav Smevoll
     * @author Ginelle Ignacio
     * @return s Value of generation counter in strings
     */
    public int getGenCounter(){
        return genCounter;
    }


    /**
     * Resets the generation counter to zero when
     * the clear button is fired
     *
     * @author Olav Smevoll
     * @author Rudi André Dahle
     * @author Ginelle Ignacio
     */
    public void resetGenCount(){
        genCounter = 0;
    }


    /**
     * Gets the value of the game board
     *
     * @author Rudi André Dahle
     * @author Olav Smevoll
     * @author Ginelle Ignacio
     * @return gameBoard Returns the value of the game board
     * @param <T> A variable for types (int, boolean, boolean[][] etc.).
     *           We use boolean[][] and Boolean Lists in this program.
     */
    public abstract <T> T getGameBoard();


    /**
     * Sets the value of the GameBoard
     *
     * @author Rudi André Dahle
     * @author Olav Smevoll
     * @author Ginelle Ignacio
     * @param gameBoard Receives the value of the game board in boolean 2D array
     * @param <T> A variable for types (int, boolean, boolean[][] etc.).
     *           We use boolean[][] and Boolean Lists in this program.
     */
    public abstract <T> void setGameBoard(T gameBoard);


   /**
    * Verifies the logic of the game by notifying each
    * neighbour of a live cell about its state.
    *
    * @author Rudi André Dahle
    * @author Olav Smevoll
    * @author Ginelle Ignacio
    * @param x integer value of the first parameter
    * @param y integer value of the second parameter
    */
    protected abstract void countNeighbours(int x, int y);


   /**
    * Scans the array for live cells.
    *
    * @author Rudi André Dahle
    * @author Olav Smevoll
    * @author Ginelle Ignacio
    */
    public abstract void nextGeneration();


    /**
     * Sets the new values for the cells in the array for the
     * next generation.
     *
     * @author Rudi André Dahle
     * @author Olav Smevoll
     * @author Ginelle Ignacio
     */
    public abstract void rules();

}