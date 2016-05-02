package sample;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Olav Smevold on 22.04.2016.
 */
public class DynamicBoard extends Board{

    //The board displayed on the screen. SATT SOM STATIC FOR Å TESTE FILEHANDLER
    private List<List<Boolean>> dynGameBoard = new ArrayList<>();
    private List<List<Byte>> byteBoard = new ArrayList<>();
    private int boardSize = 20;
    private byte zero = 0;
    private int boardSplit;
    private int index;



    public List getDynBoard(){
        return dynGameBoard;
    }


    /**
     * Fills the dynGameBoard with arrays at the program startup.
     *
     */
    public void createArray() {
        for (int x = 0; x < boardSize; x++) {
            List<Boolean> innerArray = new ArrayList<>();
            for(int y = 0; y < boardSize; y++){
                innerArray.add(false);
            }
            dynGameBoard.add(innerArray);
        }
    }

    /**
     * Increases existing vectors by 5 and adding 5 new vectors.
     *
     */
    public void addToArray(){
        boardSize += 5;

        for(int x = 0; x < 5; x++) {
            List<Boolean> innerArray = new ArrayList<>(boardSize);
            for(int y = 0; y < boardSize-5; y++){
                innerArray.add(false);
            }
            dynGameBoard.add(innerArray);
        }
        for(int x = 0; x < boardSize; x++){
            for(int y = 0; y < 5; y++)
                dynGameBoard.get(x).add(false);
        }
    }


    /*public void setGlider(){
        dynGameBoard.get(3).set(15, true);
        dynGameBoard.get(4).set(13, true);
        dynGameBoard.get(4).set(15, true);
        dynGameBoard.get(5).set(14, true);
        dynGameBoard.get(5).set(15, true);
    }*/

    public void setBoardSize(int size){
        boardSize = size;
    }

    public int getBoardSize(){
        return boardSize;
    }

    public List getBoard(){
        return dynGameBoard;
    }

    public void setDynGameBoard(List<List<Boolean>> board){
        dynGameBoard = board;
    }

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

    @Override
    public void initByteBoard(){
        index = 0;

        for (int x = 0; x < boardSize; x++) {
            List<Byte> innerByteArray = new ArrayList<>();
            for(int y = 0; y < boardSize; y++){
                innerByteArray.add(zero);
            }
            byteBoard.add(innerByteArray);
        }
    }


    @Override
    public synchronized void nextGeneration() {
        List<List<Boolean>> storeBoard = new ArrayList<>();
        for (int x = index*boardSplit; x < (index+1)*boardSplit && x < boardSize; x++) {
            List<Boolean> innerArrayStore = new ArrayList<>();
            for(int y = 0; y < boardSize; y++){
                innerArrayStore.add(false);
            }
            storeBoard.add(innerArrayStore);
        }
        index++;
        dynGameBoard = storeBoard;
        checkForBoardIncrease();
    }

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
    }


    public void checkForBoardIncrease() {

        for (int x = 0; x < boardSize; x++) {
            for (int y = 0; y < boardSize; y++) {
                if (x == boardSize - 1 || y == boardSize - 1) {
                    if (dynGameBoard.get(x).get(y)) {
                        addToArray();
                        return;
                    }
                }
            }
        }
    }


    @Override
    public void setCellState(int x, int y) {

    }

    @Override
    public boolean getCellState(int x, int y) {
        return false;
    }

    @Override
    public boolean[][] getGameBoard() {
        return new boolean[0][];
    }

    @Override
    public void setGameBoard(boolean[][] gameBoard) {

    }

    //Kills every cell on the board.
    public void clearDynBoard(/*List<List<Boolean>> listArray*/) {
        for (int x = 0; x < boardSize; x++) {
            for(int y = 0; y < boardSize; y++){
                dynGameBoard.get(x).set(y, false);
            }
        }
    }

    @Override
    public void resetBoard() {
    }

    @Override
    public String toString() {
        return null;
    }

}