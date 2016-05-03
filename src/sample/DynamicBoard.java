package sample;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olav Smevoll on 22.04.2016.
 */
public class DynamicBoard extends Board{


        private static DynamicBoard dynamicSingleton = null;

        private DynamicBoard(){ }


        public static DynamicBoard getInstance( ) {
            if(dynamicSingleton == null){
                dynamicSingleton = new DynamicBoard();
            }
            return dynamicSingleton;
        }


    private List<List<Boolean>> dynGameBoard = new ArrayList<>();
    private List<List<Byte>> byteBoard = new ArrayList<>();
    private int boardSize = super.cellsWide;
    private byte zero = 0;
    private int boardSplit;
    private int index;

    /**
     * Fills the dynGameBoard with arrays at the program startup.
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

    public void checkForBoardIncrease(){
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

    @Override
    public void setCellState(int x, int y) {

    }

    @Override
    public boolean getCellState(int x, int y) {
        return false;
    }

    @Override
    @SuppressWarnings("unchecked warnings")
    public <T> void setGameBoard(T board){
        dynGameBoard = (List<List<Boolean>>)board;
    }

    //Kills every cell on the board.
    public void clearDynBoard(/*List<List<Boolean>> listArray*/) {
        for (int x = 0; x < boardSize; x++) {
            for(int y = 0; y < boardSize; y++){
                dynGameBoard.get(x).set(y, false);
            }
        }
    }

    public void clearByteBoard(){
        for (int x = 0; x < boardSize; x++) {
            for(int y = 0; y < boardSize; y++){
                byteBoard.get(x).set(y, zero);
            }
        }
    }

    @Override
    public void initByteBoard(){};



    public void resetDynamicBoard(List<List<Boolean>> board) {
        for (int x = 0; x < boardSize; x++) {
            for(int y = 0; y < boardSize; y++){
                if(board.get(x).get(y))
                board.get(x).set(y, false);
            }
        }
    }

    @Override
    public void resetBoard() {
        for (int x = 0; x < boardSize; x++) {
            for(int y = 0; y < boardSize; y++){
                dynGameBoard.get(x).set(y, false);
            }
        }
    }

    @Override
    public List<List<Boolean>> getGameBoard(){
        return dynGameBoard;
    }

    @Override
    public int getCellsWide() {
        return cellsWide;
    }

    @Override
    public void setCellsWide(int cellsWide) {
        this.cellsWide = cellsWide;
    }

    @Override
    public String toString() {
        return null;
    }

}