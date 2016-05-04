/**
 * The Dynamic Board class enables the ability of the
 * program to read files or create cells that are
 * greater than the value given in the beginning of
 * the game.
 *
 * @author Olav Smevoll
 */

package sample;


import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DynamicBoard extends Board{

    //Data field of the singleton class
    private static DynamicBoard dynamicSingleton = null;


    /**
     * The Dynamic Board class receives no arguments
     * in its constructor.
     *
     * @author Olav Smevoll
     */
    private DynamicBoard(){

        }

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

    //Data field of the dynamic board class
    private List<List<Boolean>> dynGameBoard = new ArrayList<>();
    private List<List<Byte>> byteBoard = new ArrayList<>();
    private int boardSize = super.cellsWide;
    private byte zero = 0;
    private int boardSplit;
    private int index;


    /**
     * Fills the dynGameBoard with arrays at the program startup.
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
     * Increases existing vectors by 5 and adding 5 new vectors.
     *
     * @author Olav Smevoll
     */
    public void addToArrayEastSouth(){
        int increase = 5;
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

    public void addToArrayWestNorth(){
        int increase = 5;
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
     * Sets the value of the board size
     *
     * @author Olav Smevoll
     * @param size Receives a parameter with an integer
     *             value
     */
    public void setBoardSize(int size){
        boardSize = size;
    }


    /**
     * Gets the value of the board size
     *
     * @author Olav Smevoll
     * @return boardSize Returns the integer value of the
     *         board size
     */
    public int getBoardSize(){
        return boardSize;
    }


    /**
     * List value of the board
     *
     * @author Olav Smevoll
     * @return dynGameBoard Returns the list value of
     *         dynGameBoard
     */
    public List getBoard(){
        return dynGameBoard;
    }


    /**
     * Sets the value of the dynamic board with
     * a list within a list and a boolean element
     *
     * @author Olav Smevoll
     * @param board Receives a parameter with the value
     *              of the dynamic game board
     */
    public void setDynGameBoard(List<List<Boolean>> board){
        dynGameBoard = board;
    }


    /**
     * Overrides the countNeighbors method inherited from
     * the Board class to adapt the method called with the
     * dynamic board.
     *
     * @author Olav Smevoll
     * @param x integer value of the first parameter
     * @param y integer value of the second parameter
     */
    @Override
    protected void countNeighbours(int x, int y) {
       // int counter = 0;
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
     * @author Olav Smevoll
     */
    @Override
    public synchronized void nextGeneration() {
        checkForBoardIncrease();

        for (int x = 0/*index*boardSplit*/; x < /*(index+1)*boardSplit && x < */ boardSize; x++) {
            //List<Boolean> innerArrayStore = new ArrayList<>();
            for(int y = 0; y < boardSize; y++){
                if(dynGameBoard.get(x).get(y)){
                    countNeighbours(x,y);
                }
                //innerArrayStore.add(false);
            }
           // storeBoard.add(innerArrayStore);
        }
       // index++;

        //dynGameBoard = storeBoard;
        //checkForBoardIncrease();
    }

    /**
     * Overrides the rules method inherited from the Board
     * class to adapt the method called with the dynamic
     * board.
     *
     * @author Olav Smevoll
     */
    @Override
    public void rules(){
        for (int x = 0; x < boardSize; x++) {
            for (int y = 0; y < boardSize; y++) {
                if (byteBoard.get(x).get(y) < 2) {
                    dynGameBoard.get(x).set(y, false);
                }
                if (byteBoard.get(x).get(y) == 3) {
                    dynGameBoard.get(x).set(y, true);
                }
                if (byteBoard.get(x).get(y) > 3) {
                    dynGameBoard.get(x).set(y, false);
                }
            }
        }
        genCounter++;
        clearByteBoard();
    }

   /* public void checkForBoardIncrease() {

        for (int x = 0; x < boardSize; x++) {
            for (int y = 0; y < boardSize; y++) {
                if (x == boardSize - 1 || y == boardSize - 1) {
                    if (dynGameBoard.get(x).get(y)) {
                        addToArrayEastSouth();
                        return;
                    }
                }
            }
        }
    }*/

    //Erstatter checkForBoardIncrease for raskere gjenneomkjøring

    /*public void checkForBoardIncrease(){
        for (int x = 0; x < boardSize; x++) {
            for (int y = 0; y < boardSize; y++) {
                if (x >= boardSize - 2 || y >= boardSize - 2 || x < 1 || y < 1) {
                    if (dynGameBoard.get(x).get(y)) {
                        addToArrayEastSouth();
                        addToArrayWestNorth();
                        return;
                    }
                }
            }
        }
    }*/

    public void checkForBoardIncrease(){
        int minY = 0;
        int maxY = boardSize-1;
        int minX = 0;
        int maxX = boardSize-1;

        for(int yCounter = 0; yCounter < boardSize; yCounter++){
            if(dynGameBoard.get(minX).get(yCounter)){
                addToArrayWestNorth();
                return;
            }
            if(dynGameBoard.get(maxX).get(yCounter)){
                addToArrayEastSouth();
                return;
            }
        }
        for(int xCounter = 0; xCounter < boardSize; xCounter++){
            if(dynGameBoard.get(xCounter).get(minY)){
                addToArrayWestNorth();
                return;
            }
            if(dynGameBoard.get(xCounter).get(maxY)){
                addToArrayEastSouth();
                return;
            }
        }

    }

    public void checkForBoardIncreaseEastSouth(){
        int y = boardSize-1;
        int x = boardSize-1;

        for(int xCounter = 0; xCounter < boardSize; xCounter++){
            if(dynGameBoard.get(xCounter).get(y)){
                addToArrayEastSouth();
                return;
            }
        }
        for(int yCounter = 0; yCounter < boardSize; yCounter++){
            if(dynGameBoard.get(x).get(yCounter)){
                addToArrayEastSouth();
                return;
            }
        }

    }

    public void checkForBoardIncreaseWestNorth(){
        int y = 0;
        int x = 0;

        for(int xCounter = 0; xCounter < boardSize; xCounter++){
            if(dynGameBoard.get(xCounter).get(y)){
                addToArrayWestNorth();
                return;
            }
        }
        for(int yCounter = 0; yCounter < boardSize; yCounter++){
            if(dynGameBoard.get(x).get(yCounter)){
                addToArrayWestNorth();
                return;
            }
        }
    }


    /**
     * Overrides the setCellState method inherited from the Board
     * class to adapt with the dynamic board.
     *
     * @author Olav Smevoll
     * @param x integer value of x cell state
     * @param y integer value of y cell state
     */
    @Override
    public void setCellState(int x, int y) {

    }


    /**
     * Overrides the getCellState method inherited from the Board
     * class to adapt with the dynamic board.
     *
     * @author Olav Smevoll
     * @param x integer value of x cell state
     * @param y integer value of y cell state
     * @return false Returns the value false
     */
    @Override
    public boolean getCellState(int x, int y) {
        return false;
    }


    /**
     * Overrides the setGameBoard method inherited from the
     * Board class to adapt with the dynamic board.
     *
     * @author Olav Smevoll
     * @param board Receives the boolean value of the game
     */
    @Override
    @SuppressWarnings("unchecked warnings")
    public <T> void setGameBoard(T board){
        dynGameBoard = (List<List<Boolean>>)board;
    }

    /**
     * Method called to kill every cell on the board.
     *
     *@author Olav Smevoll
     */
    public void clearDynBoard(/*List<List<Boolean>> listArray*/) {
        dynGameBoard.clear();
        boardSize = 30;
        super.cellsWide = 30;
        super.cellsHigh = super.cellsWide;
        for (int x = 0; x < boardSize; x++) {
            dynGameBoard.add(new ArrayList<>());
            for(int y = 0; y < boardSize; y++){
                dynGameBoard.get(x).add(false);
            }
        }
    }

    /**
     * Method call to clear the byte board.
     *
     * @author Olav Smevoll
     */
    public void clearByteBoard(){
        for (int x = 0; x < boardSize; x++) {
            for(int y = 0; y < boardSize; y++){
                byteBoard.get(x).set(y, zero);
            }
        }
    }

    /**
     * Overrides the initByteBoard inherited from the
     * Board class to adapt with the dynamic board.
     *
     * @author Olav Smevoll
     */
    @Override
    public void initByteBoard(){};


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
     * Overrides the resetBoard method inherited from the
     * Board class to adapt with the dynamic board
     *
     * @author Olav Smevoll
     */
    @Override
    public void resetBoard() {
        for (int x = 0; x < boardSize; x++) {
            for(int y = 0; y < boardSize; y++){
                dynGameBoard.get(x).set(y, false);
            }
        }
    }

    /**
     * Overrides the method getGameBoard inherited from the
     * Board class to adapt with the dynamic board.
     *
     * @author Olav Smevoll
     */
    @Override
    public List<List<Boolean>> getGameBoard(){
        return dynGameBoard;
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

    boolean test = true;
    public boolean setForTesting(int sizeX, int sizeY,  boolean test){
        this.cellsWide = sizeX;
        this.cellsHigh = sizeY;
        this.test = test;
        return true;
    }

    public boolean getForTesting(int x, int y){
            return true;
    }
}