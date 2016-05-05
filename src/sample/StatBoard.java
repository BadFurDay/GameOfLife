/**
 * This class board represents a static board inherited
 * from the Board class. This class is not able to read
 * a file that contains a pattern with the value that is
 * greater than the the 2D array of the this game board.
 *
 * @author Rudi Andre Dahle
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
     * receives no arguments..
     */
    public StatBoard() {
        statGameBoard = new boolean[cellsWide][cellsHigh];
        boardSplit = (int)Math.ceil((double)statGameBoard.length / (double)Runtime.getRuntime().availableProcessors());
    }

    @Override
    public int getCellsWide() {
        return super.cellsWide;
    }

    @Override
    public void setCellsWide(int cellsWide) {
        super.cellsWide = cellsWide;
    }


    /**
     * Overrides the method countNeighbor inherited from
     * the Board class to adapt with the static board.
     *
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
        //return 5;
    }

    //@Override

    /**
     * Initializes the board
     *
     *@author Rudi André Dahle
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
     * Overrides the setCellState method inherited from the Board
     * class to adapt with the static board.
     *
     * @author Rudi André Dahle
     * @param x integer value of x cell state
     * @param y integer value of y cell state
     */
    /*@Override
    public void setCellState(int x, int y) {
        this.statGameBoard[x][y] = statGameBoard[x][y];
    }*/

    /**
     * Overrides the getCellState method inherited from the Board
     * class to adapt with the static board.
     *
     * @author Olav Smevoll
     * @param x integer value of x cell state
     * @param y integer value of y cell state
     * @return statGameBoard The value of the game board
     */
    /*@Override
    public boolean getCellState(int x, int y) {
        return statGameBoard[x][y];
    }*/

    /**
     * Overrides the setGameBoard method inherited from the
     * Board class to adapat with the static board.
     *
     * @author Rudi André Dahle
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
     * @return statGameBoard The value of the static game board
     */
    @Override
    public boolean[][] getGameBoard() {
        return statGameBoard;
    }

    /**
     * Overrides the resetBoard method inherited from the Board
     * class to adapt with the static board
     */
    /*@Override
    public void resetBoard() {
        for (int x = 0; x < statGameBoard.length; x++) {
            for (int y = 0; y < statGameBoard[0].length; y++) {
                if(statGameBoard[x][y]) {
                    statGameBoard[x][y] = false;
                }
            }
        }
    }*/



    /**
     * Overrides the toString method inherited from the Board
     * class to adapt with the static board.
     *
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