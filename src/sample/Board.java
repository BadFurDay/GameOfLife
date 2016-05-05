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
    protected int initialCells = 10;
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
     * @coauthor Olav Smevoll
     * @coauthor Ginelle Ignacio
     * @return cellsHigh Returns the cell's height
     */
    public int getCellsHigh() {
        return cellsHigh;
    }

    /**
     * Sets the value of cell's height
     *
     * @author Rudi André Dahle
     * @coauthor Olav Smevoll
     * @coauthor Ginelle Ignacio
     * @param cellsHigh
     */
    public void setCellsHigh(int cellsHigh) {
        this.cellsWide = cellsHigh;
    }

    /**
     * Gameboard's width in number of cells
     *
     * @author Rudi André Dahle
     * @coauthor Olav Smevoll
     * @coauthor Ginelle Ignacio
     * @return cellsWide Returns the cell's width
     */
    public int getCellsWide() {
        return cellsWide;
    }

    /**
     * Sets the value of cell's wide
     *
     * @author Rudi André Dahle
     * @coauthor Olav Smevoll
     * @coauthor Ginelle Ignacio
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
     * @coauthor Olav Smevoll
     * @coauthor Ginelle Ignacio
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
     * @coauthor Rudi André Dahle
     * @coauthor Ginelle Ignacio
     */
    public void resetGenCount(){
        genCounter = 0;
    }


    /**
     * Gets the value of the game board
     *
     * @author Rudi André Dahle
     * @coauthor Olav Smevoll
     * @coauthor Ginelle Ignacio
     * @return gameBoard Returns the value of the
     *                   game board
     */
    public abstract <T> T getGameBoard();


    /**
     * Sets the value of the GameBoard
     *
     * @author Rudi André Dahle
     * @coauthor Olav Smevoll
     * @coauthor Ginelle Ignacio
     * @param gameBoard Receives the value of the game
     *                  board in boolean 2D array
     */
    public abstract <T> void setGameBoard(T gameBoard);


   /**
    * Verifies the logic of the game by counting
    * the cell neighbors in every direction each
    * cell comes in contact with.
    *
    *
    * @author Rudi André Dahle
    * @coauthor Olav Smevoll
    * @coauthor Ginelle Ignacio
    * @param x integer value of the first parameter
    * @param y integer value of the second parameter
    * @return counter Returns the value of counter after
    *         checking the rules
    */
    protected abstract void countNeighbours(int x, int y);


   /**
    *  Sets the new values in the array for the
    *  next generation.
    *
    * @author Rudi André Dahle
    * @coauthor Olav Smevoll
    * @coauthor Ginelle Ignacio
    */
    public abstract void nextGeneration();

    /**
     *
     * @author Rudi André Dahle
     * @coauthor Olav Smevoll
     * @coauthor Ginelle Ignacio
     */
    public abstract void rules();

}