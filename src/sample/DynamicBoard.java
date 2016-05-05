/**
 * The Dynamic Board class enables the ability of the
 * program to read files or create cells that are
 * greater than the value given in the beginning of
 * the game.
 *
 * @author Olav Smevoll
 */

package sample;

import java.util.ArrayList;
import java.util.List;


public class DynamicBoard extends Board{

    /**
     *  Singleton class of Dynamic Board that maintains
     *  a static reference to the lone singleton instance.
     *
     * @author Olav Smevoll
     * @return dynamicSingleton Returns the reference from
     *          the static getInstance() method
     */
    public static DynamicBoard getInstance( ) {
        if(dynamicSingleton == null){
            dynamicSingleton = new DynamicBoard();
        }
        return dynamicSingleton;
    }


    //Data field of the singleton class
    private static DynamicBoard dynamicSingleton = null;

    //Data field of the dynamic board class
    private List<List<Boolean>> dynGameBoard = new ArrayList<>();
    private List<List<Byte>> byteBoard = new ArrayList<>();
    private int boardSize = super.cellsWide;
    private byte zero = 0;
    private int boardSplit;
    private int index;


    /**
     * Private constructor so no other instances can be made
     *
     * @author Olav Smevoll
     */
    private DynamicBoard(){

    }

    /**
     *
     * @author Rudi André Dahle
     */
    public void setBoardSplit() {
        this.boardSplit = (int)Math.ceil((double)dynGameBoard.size() / (double)Runtime.getRuntime().availableProcessors());
    }

    /**
     * Fills the dynGameBoard and byteBoard with arrays at the program startup.
     *
     * @author Olav Smevoll
     *
     */
    public void createArray() {
        for (int x = 0; x < boardSize; x++) {
            List<Boolean> innerArray = new ArrayList<>();
            List<Byte> innerByteArray = new ArrayList<>();
            for(int y = 0; y < boardSize; y++){
                innerArray.add(false);
                innerByteArray.add(zero);
            }
            dynGameBoard.add(innerArray);
            byteBoard.add(innerByteArray);
        }
    }


    /**
     * If a cell reaches the edge of the gameboard this method adds 2 new arrays to the dynGameBoard and increases the existing arrays with 2 as well.
     * This method is used together with the addToArrayWestNorth if a cell reaches the edge during runtime,
     * increasing the board by a total of 4 cells.
     *
     */
    public void addToArrayEastSouth(){
        int increase = 2;
        super.cellsWide += increase;
        super.cellsHigh += increase;
        boardSize += increase;

        for(int x = 0; x < increase; x++) {
            List<Boolean> innerArray = new ArrayList<>();
            List<Byte> innerByteArray = new ArrayList<>();
            for(int y = 0; y < boardSize-increase; y++){
                innerArray.add(false);
                innerByteArray.add(zero);
            }
            dynGameBoard.add(innerArray);
            byteBoard.add(innerByteArray);
        }

        for(int x = 0; x < boardSize; x++){
            for(int y = 0; y < increase; y++) {
                dynGameBoard.get(x).add(false);
                byteBoard.get(x).add(zero);
            }
        }
    }

    /**
     * Increases the dynGameBoard by 2 in the west and north direction as well as moving the existing pattern 2 cells into the east/south direction.
     *
     */
    public void addToArrayWestNorth(){
        int increase = 2;
        super.cellsWide += increase;
        super.cellsHigh += increase;
        boardSize += increase;


        for(int x = 0; x < increase; x++) {
            List<Boolean> innerArray = new ArrayList<>();
            List<Byte> innerByteArray = new ArrayList<>();
            for(int y = 0; y < boardSize-increase; y++){
                innerArray.add(0,false);
                innerByteArray.add(0, zero);
            }
            dynGameBoard.add(0, innerArray);
            byteBoard.add(0, innerByteArray);
        }
        for(int x = 0; x < boardSize; x++){
            for(int y = 0; y < increase; y++) {
                dynGameBoard.get(x).add(0, false);
                byteBoard.get(x).add(0, zero);
            }
        }
    }

    /**
     * Overrides the method getGameBoard inherited from the
     * Board class to adpat with the dynamic board.
     *
     * @author Rudi André Dahle
     * @return dynGameBoard Returns the list value of
     *         dynGameBoard
     */
    @Override
    public List<List<Boolean>> getGameBoard(){
        return dynGameBoard;
    }

    /**
     * Sets the value of the dynamic board with
     * a list within a list and a boolean element
     *
     * @author Rudi André Dahle
     * @param board Receives a parameter with the value
     *              of the dynamic game board
     */
    @Override
    @SuppressWarnings("unchecked warnings")
    public <T> void setGameBoard(T board){
        dynGameBoard = (List<List<Boolean>>)board;

    }

    /**
     * Overrides the countNeighbors method inherited from
     * the Board class to adapt the method called with the
     * dynamic board.
     *
     * @author Rudi André Dahle
     * @param x integer value of the first parameter
     * @param y integer value of the second parameter
     */
    @Override
    protected void countNeighbours(int x, int y) {
        int blx = boardSize - 1;
        int bly = boardSize - 1;


        //Check cell neighbor North-West
        if (x > 0 && y > 0) {
            byte tmp = (byteBoard.get(x-1).get(y-1));
            byteBoard.get(x-1).set(y-1, (byte)(tmp+1));
        }

        //Check cell neighbor North
        if (x > 0) {
            byte tmp = (byteBoard.get(x-1).get(y));
            byteBoard.get(x-1).set(y, (byte)(tmp+1));
        }

        //Check cell neighbor North-East
        if (x > 0 && y < bly) {
            byte tmp = (byteBoard.get(x-1).get(y+1));
            byteBoard.get(x-1).set(y+1, (byte)(tmp+1));
        }

        //Check cell neighbor West
        if (y > 0) {
            byte tmp = (byteBoard.get(x).get(y-1));
            byteBoard.get(x).set(y-1, (byte)(tmp+1));
        }

        //Check cell neighbor East
        if (y < bly) {
            byte tmp = (byteBoard.get(x).get(y+1));
            byteBoard.get(x).set(y+1, (byte)(tmp+1));
        }

        //Check cell neighbor South-West
        if (x < blx && y > 0) {
            byte tmp = (byteBoard.get(x+1).get(y-1));
            byteBoard.get(x+1).set(y-1, (byte)(tmp+1));
        }

        //Check cell neighbor South
        if (x < blx) {
            byte tmp = (byteBoard.get(x+1).get(y));
            byteBoard.get(x+1).set(y, (byte)(tmp+1));
        }

        //Check cell neighbor South-East
        if (x < blx && y < bly) {
            byte tmp = (byteBoard.get(x+1).get(y+1));
            byteBoard.get(x+1).set(y+1, (byte)(tmp+1));
        }
    }

    /**
     * Overrides the nextGeneration method inherited from the
     * Board class to adapt the method called with the dynamic
     * board.
     *
     * @author Rudi André Dahle
     * @coauthor Olav Smevoll
     */
    @Override
    public synchronized void nextGeneration() {
        for (int x = index*boardSplit; x < (index+1)*boardSplit && x < boardSize; x++) {
            //List<Boolean> innerArrayStore = new ArrayList<>();
            for(int y = 0; y < boardSize; y++){
                if(dynGameBoard.get(x).get(y)){
                    countNeighbours(x,y);
                }
            }
        }
        index++;
    }

    /**
     * Overrides the rules method inherited from the Board
     * class to adapt the method called with the dynamic
     * board.
     *
     * @author Rudi André Dahle
     * @coauthor Olav Smevoll
     */
    @Override
    public void rules(){
        for (int x = 0; x < boardSize; x++) {
            for (int y = 0; y < boardSize; y++) {
                if (byteBoard.get(x).get(y) < 2 || byteBoard.get(x).get(y) > 3) {
                    dynGameBoard.get(x).set(y, false);
                }
                if (byteBoard.get(x).get(y) == 3) {
                    dynGameBoard.get(x).set(y, true);
                }
            }
        }
        genCounter++;
        clearByteBoard();
        index = 0;
    }

    /**
     * Checks if the board size needs to be increased before the next generation.
     *
     */
    public void checkForBoardIncrease(){
        int minY = 0;
        int maxY = boardSize-1;
        int minX = 0;
        int maxX = boardSize-1;

        for(int yCounter = 0; yCounter < boardSize; yCounter++){
            if(dynGameBoard.get(minX).get(yCounter)){
                addToArrayWestNorth();
                addToArrayEastSouth();
                return;
            }
            if(dynGameBoard.get(maxX).get(yCounter)){
                addToArrayEastSouth();
                addToArrayWestNorth();
                return;
            }
        }
        for(int xCounter = 0; xCounter < boardSize; xCounter++){
            if(dynGameBoard.get(xCounter).get(minY)){
                addToArrayWestNorth();
                addToArrayEastSouth();
                return;
            }
            if(dynGameBoard.get(xCounter).get(maxY)){
                addToArrayEastSouth();
                addToArrayWestNorth();
                return;
            }
        }
    }

    /**
     * Clears the board and goes back to the original size
     *
     *@author Olav Smevoll
     */
    public void clearDynBoard() {
        dynGameBoard.clear();
        boardSize = super.initialCells;
        super.cellsWide = initialCells;
        super.cellsHigh = super.cellsWide;

        for (int x = 0; x < boardSize; x++) {
            dynGameBoard.add(new ArrayList<>());

            for(int y = 0; y < boardSize; y++){
                dynGameBoard.get(x).add(false);
            }
        }
    }

    /**
     * Clears the byte board.
     *
     * @author Olav Smevoll
     */
    public void clearByteBoard(){
        byteBoard.clear();
        for (int x = 0; x < boardSize; x++) {
            byteBoard.add(new ArrayList<>());
            for(int y = 0; y < boardSize; y++){
                byteBoard.get(x).add(zero);
            }
        }
    }


    /**
     * Method called to reset the Dynamic Board
     *
     * @author Olav Smevoll
     * @param board Parameter receives a list within a list
     *              and a boolean element of the board
     */
    public void resetDynamicBoard(List<List<Boolean>> board) {
        board.clear();
        for (int x = 0; x < boardSize; x++) {
            board.add(new ArrayList<>());
            for(int y = 0; y < boardSize; y++){
                board.get(x).add(y, false);
            }
        }
    }


    /**
     * Overrides the toString method inherited from the Board
     * class to adapt with the dynamic board.
     *
     * @return null Returns the value null
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        return str.toString();
    }
}