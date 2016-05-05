/**
 * This class board represents a static board inherited
 * from the Board class. This class has no ability to read
 * a file that contains a pattern with a greater value than
 * the predefined 2D array.
 *
 * This board is no longer in use because of the dynamic
 * board.
 *
 * @author Rudi Andre Dahle
 * @coauthor Olav Smevoll
 * @coauthor Ginelle Ignacio
 */

package sample;

@Deprecated
public class StatBoard extends Board {


    public StatBoard statBoard;

    //Datafield
    protected boolean[][] statGameBoard;
    private byte[][] byteBoard;
    private int boardSplit;
    private int index;


    /**
     * Board class has a default constructor that
     * receives no arguments.
     *
     * @author Rudi André Dahle
     * @coauthor Olav Smevoll
     * @coauthor Ginelle Ignacio
     */
    public StatBoard() {
        statGameBoard = new boolean[cellsWide][cellsHigh];
        boardSplit = (int)Math.ceil((double)statGameBoard.length / (double)Runtime.getRuntime().availableProcessors());
    }

    /**
     * Overrides the getCellsWide method inherited from the
     * Board class to adapt with the static board.
     *
     * @author Rudi André Dahle
     * @coauthor Olav Smevoll
     * @coauthor Ginelle Ignacio
     * @return cellsWide Integer value of the cellswide
     *                   inherited from the super class
     */
    @Override
    public int getCellsWide() {
        return super.cellsWide;
    }


    /**
     * Overrides the setCellsWide method inherited from the
     * Board class to adapt with the static board.
     *
     * @author Rudi André Dahle
     * @coauthor Olav Smevoll
     * @coauthor Ginelle Ignacio
     * @param cellsWide Parameter receives an integer
     */
    @Override
    public void setCellsWide(int cellsWide) {
        super.cellsWide = cellsWide;
    }


    /**
     * Overrides the method countNeighbor inherited from
     * the Board class to adapt with the static board.
     *
     * @author Rudi André Dahle
     * @coauthor Olav Smevoll
     * @coauthor Ginelle Ignacio
     * @param x integer value of the first parameter
     * @param y integer value of the second parameter
     */
    @Override
    protected void countNeighbours(int x, int y) {
        int blx = statGameBoard.length - 1;
        int bly = statGameBoard[0].length - 1;

        //Check cell neighbor North-West
        if (x > 0 && y > 0) {
            byteBoard[x - 1][y - 1]++;
        }

        //Check cell neighbor North
        if (x > 0) {
            byteBoard[x - 1][y]++;
        }

        //Check cell neighbor North-East
        if (x > 0 && y < bly) {
            byteBoard[x - 1][y + 1]++;
        }

        //Check cell neighbor West
        if (y > 0) {
            byteBoard[x][y - 1]++;
        }

        //Check cell neighbor East
        if (y < bly) {
            byteBoard[x][y + 1]++;
        }

        //Check cell neighbor South-West
        if (x < blx && y > 0) {
            byteBoard[x + 1][y - 1]++;
        }

        //Check cell neighbor South
        if (x < blx) {
            byteBoard[x + 1][y]++;
        }

        //Check cell neighbor South-East
        if (x < blx && y < bly) {
            byteBoard[x + 1][y + 1]++;
        }

    }

    /**
     * Initializes the board
     *
     * @author Rudi André Dahle
     * @coauthor Olav Smevoll
     * @coauthor Ginelle Ignacio
     */
    public void initByteBoard(){
        index = 0;
        byteBoard = new byte[cellsWide][cellsHigh];
    }

    /**
     * Overrides the nextGeneration method inherited from the
     * Board class to adapt with the Static Board.
     *
     * @author Rudi André Dahle
     * @coauthor Olav Smevoll
     * @coauthor Ginelle Ignacio
     */
    @Override
    public synchronized void nextGeneration() {
        for (int x = index*boardSplit; x < (index+1)*boardSplit && x < statGameBoard.length; x++) {
            for (int y = 0; y < statGameBoard[0].length; y++) {
                if (statGameBoard[x][y]) {
                    countNeighbours(x, y);
                }
            }
        }
        index++;
    }

    /**
     * Overrides the rules method inherited from the
     * Board class to adapt with the Static Board.
     *
     * @author Rudi André Dahle
     * @coauthor Olav Smevoll
     * @coauthor Ginelle Ignacio
     */
    @Override
    public void rules(){
        for (int x = 0; x < byteBoard.length; x++) {
            for (int y = 0; y < byteBoard[0].length; y++) {
                if (byteBoard[x][y] < 2 || byteBoard[x][y] > 3) {
                    statGameBoard[x][y] = false;
                }
                if (byteBoard[x][y] == 3) {
                    statGameBoard[x][y] = true;
                }
            }
        }
        genCounter++;
    }

    /**
     * Overrides the setGameBoard method inherited from the
     * Board class to adapat with the static board.
     *
     * @author Rudi André Dahle
     * @coauthor Olav Smevoll
     * @coauthor Ginelle Ignacio
     * @param statGameBoard Receives the boolean value of the game
     */
    @Override
    public <T> void setGameBoard(T statGameBoard) {
        this.cellsWide = ((boolean[][])statGameBoard)[0].length;
        this.cellsHigh = ((boolean[][])statGameBoard).length;
        this.statGameBoard = ((boolean[][])statGameBoard);
    }

    /**
     * Method called to get the value the game board
     *
     * @author Rudi André Dahle
     * @coauthor Olav Smevoll
     * @coauthor Ginelle Ignacio
     * @return statGameBoard The value of the static game board
     */
    @Override
    public boolean[][] getGameBoard() {
        return statGameBoard;
    }



    /**
     * Overrides the toString method inherited from the Board
     * class to adapt with the static board. This method is
     * used for Junit testing.
     *
     * @author Rudi André Dahle
     * @coauthor Olav Smevoll
     * @coauthor Ginelle Ignacio
     * @return str.toString Value of the string builder's
     *                      to string
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (boolean[] gameArray : statGameBoard) {
            for(boolean gameCell : gameArray) {
                str.append(gameCell ? "1" : "0");
            }
        }
        return str.toString();
    }
}