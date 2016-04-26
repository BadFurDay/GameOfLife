package sample;

/**
 * Created by RudiAndre on 25.04.2016.
 */
public class StatBoard extends Board {

    public StatBoard statBoard;

    //Datafield
    protected boolean[][] statGameBoard;

    /**
     * Board class has a default constructor that
     * receives no arguments.
     */
    public StatBoard() {
        statGameBoard = new boolean[super.getBoardWidth()][super.getBoardHeight()];
    }


    @Override
    protected int countNeighbours(int x, int y) {
        int counter = 0;
        int blx = statGameBoard.length - 1;
        int bly = statGameBoard[0].length - 1;

        //Check cell neighbor North-West
        if (x > 0 && y > 0 && statGameBoard[x - 1][y - 1]) {
            counter++;
        }

        //Check cell neighbor North
        if (x > 0 && statGameBoard[x - 1][y]) {
            counter++;
        }

        //Check cell neighbor North-East
        if (x > 0 && y < bly && statGameBoard[x - 1][y + 1]) {
            counter++;
        }

        //Check cell neighbor West
        if (y > 0 && statGameBoard[x][y - 1]) {
            counter++;
        }

        //Check cell neighbor East
        if (y < bly && statGameBoard[x][y + 1]) {
            counter++;
        }

        //Check cell neighbor South-West
        if (x < blx && y > 0 && statGameBoard[x + 1][y - 1]) {
            counter++;
        }

        //Check cell neighbor South
        if (x < blx && statGameBoard[x + 1][y]) {
            counter++;
        }

        //Check cell neighbor South-East
        if (x < blx && y < bly && statGameBoard[x + 1][y + 1]) {
            counter++;
        }
        return counter;
    }

    @Override
    public void nextGeneration() {
        boolean[][] newStatBoard = new boolean[getBoardWidth()][getBoardHeight()];
        boolean[][] inactiveBoard = new boolean[getBoardWidth()][getBoardHeight()];

        for (int x = 0; x < statGameBoard.length; x++) {
            for (int y = 0; y < statGameBoard[0].length; y++) {
                if (statGameBoard[x][y]) {
                    newStatBoard[x][y] = countNeighbours(x, y) == 2 || countNeighbours(x, y) == 3;
                } else newStatBoard[x][y] = countNeighbours(x, y) == 3;
            }
        }
        statGameBoard = newStatBoard;
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
    public void clearBoard() {
        for (int x = 0; x < statGameBoard.length; x++) {
            for (int y = 0; y < statGameBoard[0].length; y++) {
                statGameBoard[x][y] = false;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (boolean[] gameArray : statGameBoard){
            for(boolean gameCell : gameArray){
                str.append(gameCell ? "1" : "0");
            }
        }
        return str.toString();
    }
}