/**
 * Board class contains the rules of the game that the cells
 * will follow in order to generate.
 *
 * @author Rudi André Dahle
 * @author Olav Smevoll
 */

package sample;


public class Board {

    private static Board board;

    //Datafield
    private int cellsWide = 50;             //Number of cells in gameboard's width
    private int cellsHigh = cellsWide/2;    //Number of cells in gameboard's height
    protected int genCounter;               //Number of generations in integer value
    public boolean[][] gameBoard;           //Value of game board in boolean 2D array


    /**
     * Board class has a default constructor that
     * receives no arguments.
     */
    public Board() {
        gameBoard = new boolean[getBoardWidth()][getBoardHeight()];
    }

    public static Board getBoard(){
        if(board == null){
            board = new Board();
        }
        return board;
    }


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
     *  Sets the new values in the array for the
     *  next generation.
     *
     *  @author Rudi André Dahle
     */
    public void nextGeneration() {
        boolean[][] newGameBoard = new boolean[getBoardWidth()][getBoardHeight()];
        boolean[][] inactiveBoard = new boolean[getBoardWidth()][getBoardHeight()];

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
     * @return s Value of generation counter in strings
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
    public boolean[][] getGameBoard() {
        return gameBoard;
    }


    /**
     * Sets the value of the GameBoard
     *
     * @author Rudi André Dahle
     * @param gameBoard Receives the value of the game
     *                  board in boolean 2D array
     */
    public void setGameBoard(boolean[][] gameBoard) {
        this.cellsWide = gameBoard[0].length;
        this.cellsHigh = gameBoard.length;
        this.gameBoard = gameBoard;
    }


    /**
     * Clears the board when new board is loaded
     * from rle file
     *
     * @author Olav Smevoll
     */
    public void clearBoard(){
        for (int x = 0; x < gameBoard.length; x++) {
            for (int y = 0; y < gameBoard[0].length; y++) {
                gameBoard[x][y] = false;
            }
        }
    }


    /**
     * This method is the string representation of
     * the Board class.
     *
     * @author Rudi André Dahle
     * @return toString String representation of gameBoard
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (boolean[] gameArray : gameBoard){
            for(boolean gameCell : gameArray){
                str.append(gameCell ? "1" : "0");
            }
        }
        return str.toString();
    }
}