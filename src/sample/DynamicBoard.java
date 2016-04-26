package sample;

import java.util.List;

/**
 * Created by RudiAndre on 22.04.2016.
 */
public class DynamicBoard extends Board{

    private List<List<Boolean>> gameboard;

    /**
     * Board class has a default constructor that
     * receives no arguments.
     *
     * @param cellsWide
     * @param cellsHigh
     */
    public DynamicBoard() {

    }


    @Override
    protected int countNeighbours(int x, int y) {
        return 0;
    }

    @Override
    public void nextGeneration() {

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

    @Override
    public void clearBoard() {

    }

    @Override
    public String toString() {
        return null;
    }
}