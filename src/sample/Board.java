package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;


/**
 * Created by RudiAndre on 08.02.2016.
 */

public class Board {

    //Datafield
    protected GraphicsContext gc;
    private int cellsWide = 40; //Number of cells in gameboards width
    private int cellsHigh = 20; //Number of cells in gameboards height
    protected int genCounter;
    public boolean[][] gameBoard;


    //Constructor
    public Board(/*int cellsWide, int cellsHigh*/) {
       // this.cellsWide = cellsWide;
       // this.cellsHigh = cellsHigh;
        System.out.println("Antall celler bredde: " + getBoardWidth());
        System.out.println("Antall celler høyde: " + getBoardHeight());

        gameBoard = new boolean[getBoardWidth()][getBoardHeight()];

        gameBoard[0][0] = true;
        gameBoard[2][0] = true;
        gameBoard[4][0] = true;
        gameBoard[6][0] = true;
        gameBoard[8][0] = true;
        gameBoard[10][0] = true;
        gameBoard[12][0] = true;
        gameBoard[14][0] = true;
        gameBoard[16][0] = true;
        gameBoard[18][0] = true;
        gameBoard[20][0] = true;
        gameBoard[22][0] = true;
        gameBoard[24][0] = true;
        gameBoard[26][0] = true;
        gameBoard[28][0] = true;
        gameBoard[30][0] = true;
        gameBoard[32][0] = true;
        gameBoard[34][0] = true;
        gameBoard[36][0] = true;
        gameBoard[38][0] = true;

        gameBoard[1][19] = true;
        gameBoard[3][19] = true;
        gameBoard[5][19] = true;
        gameBoard[7][19] = true;
        gameBoard[9][19] = true;
        gameBoard[11][19] = true;
        gameBoard[13][19] = true;
        gameBoard[15][19] = true;
        gameBoard[17][19] = true;
        gameBoard[19][19] = true;
        gameBoard[21][19] = true;
        gameBoard[23][19] = true;
        gameBoard[25][19] = true;
        gameBoard[27][19] = true;
        gameBoard[29][19] = true;
        gameBoard[31][19] = true;
        gameBoard[33][19] = true;
        gameBoard[35][19] = true;
        gameBoard[37][19] = true;
        gameBoard[39][19] = true;

        gameBoard[0][2] = true;
        gameBoard[0][4] = true;
        gameBoard[0][6] = true;
        gameBoard[0][8] = true;
        gameBoard[0][10] = true;
        gameBoard[0][12] = true;
        gameBoard[0][14] = true;
        gameBoard[0][16] = true;
        gameBoard[0][18] = true;

        gameBoard[39][1] = true;
        gameBoard[39][3] = true;
        gameBoard[39][5] = true;
        gameBoard[39][7] = true;
        gameBoard[39][9] = true;
        gameBoard[39][11] = true;
        gameBoard[39][13] = true;
        gameBoard[39][15] = true;
        gameBoard[39][17] = true;

        gameBoard[3][4] = true;
        gameBoard[4][4] = true;
        gameBoard[5][4] = true;
        gameBoard[5][3] = true;
        gameBoard[4][2] = true;


        /**/

        gameBoard[30][3] = true;
        gameBoard[30][4] = true;
        gameBoard[30][5] = true;
        gameBoard[30][7] = true;
        gameBoard[30][8] = true;
        gameBoard[30][9] = true;
        gameBoard[29][6] = true;
        gameBoard[28][6] = true;
        gameBoard[27][6] = true;
        gameBoard[31][6] = true;
        gameBoard[32][6] = true;
        gameBoard[33][6] = true;

    }


    /**
     * Counts cell neighbours for next generation.
     *
     * @param x
     * @param y
     * @return counter
     * @author Olav Smevoll on 08.03.2016
     */

    protected int countNeighbours(int x, int y) {
        int counter = 0;
        int blx = gameBoard.length - 1;
        int bly = gameBoard[0].length - 1;

        //Check cell neighbor North-West
        if (x > 0 && y > 0 && gameBoard[x - 1][y - 1]) {
            counter++;
        }

        //Check cell neighbor North
        if (x > 0 && gameBoard[x - 1][y]) {
            counter++;
        }

        //Check cell neighbor North-East
        if (x > 0 && y < bly && gameBoard[x - 1][y + 1]) {
            counter++;
        }

        //Check cell neighbor West
        if (y > 0 && gameBoard[x][y - 1]) {
            counter++;
        }

        //Check cell neighbor East
        if (y < bly && gameBoard[x][y + 1]) {
            counter++;
        }

        //Check cell neighbor South-West
        if (x < blx && y > 0 && gameBoard[x + 1][y - 1]) {
            counter++;
        }

        //Check cell neighbor South
        if (x < blx && gameBoard[x + 1][y]) {
            counter++;
        }

        //Check cell neighbor South-East
        if (x < blx && y < bly && gameBoard[x + 1][y + 1]) {
            counter++;
        }
        return counter;
    }


    /**
     *  Sets the new values in the array for the next generation.
     *
     *  @author Rudi Andre on 04.03.2016
     */
    public void nextGeneration(Grid grid) {
        boolean[][] newGameBoard = new boolean[getBoardWidth()][getBoardHeight()];

        for (int x = 0; x < gameBoard.length; x++) {
            for (int y = 0; y < gameBoard[0].length; y++) {
                if (gameBoard[x][y]) {
                    newGameBoard[x][y] = countNeighbours(x, y) == 2 || countNeighbours(x, y) == 3;
                } else newGameBoard[x][y] = countNeighbours(x, y) == 3;
            }
        }
        gameBoard = newGameBoard;
        genCounter++;
    }

    /**
     * Returns the genCounter as a string to show as a label.
     *
     * @author Olav
     * @return s
     */
    public String getGenCounter(){
        String s = Integer.toString(genCounter);
        return s;
    }

    /**
     * Resets the genCounter when the board is cleared.
     *
     * @author Olav
     */

    public void resetGenCount(){
        genCounter = 0;
    }


    /**
     * Gameboard's width in number of cells
     *
     * @author Rudi 24.03.16
     * @return
     */

    public int getBoardWidth() {
        return cellsWide;
    }


    /**
     *
     * @param x
     */
   /* public void setBoardWidth(int x) {
        cellsWide = x;
    }*/


    /**
     * Gameboards height in number of cells
     *
     * @author Rudi 24.03.16
     * @return
     */

    public int getBoardHeight() {
        return cellsHigh;
    }


    /**
     * Rudi 24.03.16
     * Sets Gameboard's height
     * @param y
     */

    public void setBoardHeight(int y) {
        cellsHigh = y;
    }


    /**
     * Created by RudiAndre on 09.03.2016.
     * @return
     */
    /*public int getCanvasHeight() {
        return canvas.heightProperty().intValue();
    }*/


    /**
     * Created by RudiAndre on 09.03.2016.
     * @return
     */
   /* public int getCanvasWidth() {
        return canvas.widthProperty().intValue();
    }*/


    /**
     * Gets the GameBoard
     * @author RudiAndre on 01.03.2016.
     * @return gameBoard
     */

    public boolean[][] getGameBoard() {
        return gameBoard;
    }


    /**
     * Sets the GameBoard
     *
     * @author RudiAndre on 01.03.2016.
     * @param gameBoard
     */

    public void setGameBoard(boolean[][] gameBoard) {
        this.gameBoard = gameBoard;
    }


    /**
     *
     *
     * @author
     * @return toString
     */

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
            for (int x = 0; x < gameBoard.length; x++) {
                for (int y = 0; y < gameBoard.length; y++) {
                    if (gameBoard[x][y]) {
                        str.append("1");
                    } else {
                        str.append("0");
                    }
                }
            }
        return str.toString();
    }
}