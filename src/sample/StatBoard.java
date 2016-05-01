package sample;

import javafx.scene.canvas.GraphicsContext;
import org.omg.SendingContext.RunTime;

/**
 * Created by RudiAndre on 25.04.2016.
 */
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
     */
    public StatBoard() {
        statGameBoard = new boolean[cellsWide][cellsHigh];
        boardSplit = (int)Math.ceil((double)statGameBoard.length / (double)Runtime.getRuntime().availableProcessors());
    }

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

    @Override
    public void initByteBoard(){
        index = 0;
        byteBoard = new byte[cellsWide][cellsHigh];
    }

    @Override
    public synchronized void nextGeneration() {
       // double w = 7.64;
       // double h = 7.64;
        for (int x = index*boardSplit; x < (index+1)*boardSplit && x < statGameBoard.length; x++) {
            for (int y = 0; y < statGameBoard[0].length; y++) {
                if (statGameBoard[x][y]) {
                    countNeighbours(x, y);
                }
            }
        }
        index++;
    }


    @Override
    public void rules(){
        for (int x = 0; x < byteBoard.length; x++) {
            for (int y = 0; y < byteBoard[0].length; y++) {
                if (byteBoard[x][y] < 2) {
                    statGameBoard[x][y] = false;
                }
                if (byteBoard[x][y] == 3) {
                    statGameBoard[x][y] = true;
                }
                if (byteBoard[x][y] > 3) {
                    statGameBoard[x][y] = false;
                }
            }
        }
        genCounter++;
    }


    @Override
    public void setCellState(int x, int y) {
        this.statGameBoard[x][y] = statGameBoard[x][y];
    }

    @Override
    public boolean getCellState(int x, int y) {
        return statGameBoard[x][y];
    }

    @Override
    public boolean[][] getGameBoard() {
        return statGameBoard;
    }


    @Override
    public void setGameBoard(boolean[][] statGameBoard) {
        this.cellsWide = statGameBoard[0].length;
        this.cellsHigh = statGameBoard.length;
        this.statGameBoard = statGameBoard;
    }

    @Override
    public void resetBoard() {
        for (int x = 0; x < statGameBoard.length; x++) {
            for (int y = 0; y < statGameBoard[0].length; y++) {
                if(statGameBoard[x][y]) {
                    statGameBoard[x][y] = false;
                }
            }
        }
    }

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