package sample;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Olav Smevold on 22.04.2016.
 */
public class DynamicBoard extends Board{

    private int boardSize = 20;


    //The board displayed on the screen. SATT SOM STATIC FOR Å TESTE FILEHANDLER
    private static List<List<Boolean>> dynGameBoard = new ArrayList<>();


    public static List getDynBoard(){
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
    protected int countNeighbours(int x, int y) {
        int counter = 0;
        int blx = boardSize - 1;
        int bly = boardSize - 1;



        //Check cell neighbor North-West
        if (x > 0 && y > 0 && dynGameBoard.get(x-1).get(y-1)) {
            counter++;
        }

        //Check cell neighbor North
        if (x > 0 && dynGameBoard.get(x-1).get(y)) {
            counter++;
        }

        //Check cell neighbor North-East
        if (x > 0 && y < bly && dynGameBoard.get(x-1).get(y+1)) {
            counter++;
        }

        //Check cell neighbor West
        if (y > 0 && dynGameBoard.get(x).get(y-1)) {
            counter++;
        }

        //Check cell neighbor East
        if (y < bly && dynGameBoard.get(x).get(y+1)) {
            counter++;
        }

        //Check cell neighbor South-West
        if (x < blx && y > 0 && dynGameBoard.get(x+1).get(y-1)) {
            counter++;
        }

        //Check cell neighbor South
        if (x < blx && dynGameBoard.get(x+1).get(y)) {
            counter++;
        }

        //Check cell neighbor South-East
        if (x < blx && y < bly && dynGameBoard.get(x+1).get(y+1)) {
            counter++;
        }
        return counter;
    }


    @Override
    public void nextGeneration() {
        List<List<Boolean>> storeBoard = new ArrayList<>();
        for (int x = 0; x < boardSize; x++) {
            List<Boolean> innerArrayStore = new ArrayList<>();
            for(int y = 0; y < boardSize; y++){
                innerArrayStore.add(false);
            }
            storeBoard.add(innerArrayStore);
        }

        for (int x = 0; x < boardSize; x++) {
            for (int y = 0; y < boardSize; y++) {
                if (dynGameBoard.get(x).get(y)) {
                    storeBoard.get(x).set(y, countNeighbours(x, y) == 2 || countNeighbours(x, y) == 3);
                } else storeBoard.get(x).set(y, countNeighbours(x, y) == 3);
            }
        }
        dynGameBoard = storeBoard;
        checkForBoardIncrease();

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

    public static void rleToBoard(String finalRle){
        int yCounter = 5;
        int xCounter = 5;

        for (int i = 0; i < finalRle.length(); i++) {
            if (finalRle.charAt(i) == '$') {
                yCounter++;
                xCounter = 5;
            }
            if (finalRle.charAt(i) == 'b') {
                dynGameBoard.get(xCounter).set(yCounter, false);
                //statBoard.statGameBoard[xCounter][yCounter] = false;
                xCounter++;
            }
            if (finalRle.charAt(i) == 'o') {
                dynGameBoard.get(xCounter).set(yCounter, true);
                //statBoard.statGameBoard[xCounter][yCounter] = true;
                xCounter++;
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
    public void clearBoard(){

    }

    @Override
    public String toString() {
        return null;
    }

}