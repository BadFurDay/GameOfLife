/**
 * Board class contains the rules of the game that the cells
 * will follow in order to generate.
 *
 * @author Rudi André Dahle
 * @author Olav Smevoll
 */

package sample;

import javafx.scene.canvas.GraphicsContext;


public class Board {

    //Datafield
    protected GraphicsContext gc;
    private int cellsWide = 100; //Number of cells in gameboards width
    private int cellsHigh = cellsWide/2; //Number of cells in gameboards height
    protected int genCounter;
    public boolean[][] gameBoard;


    //Constructor
    public Board(/*int cellsWide, int cellsHigh*/) {
       // this.cellsWide = cellsWide;
       // this.cellsHigh = cellsHigh;
        System.out.println("Antall celler bredde: " + getBoardWidth());
        System.out.println("Antall celler høyde: " + getBoardHeight());
        System.out.println("nb");
        gameBoard = new boolean[getBoardWidth()][getBoardHeight()];

/*
        gameBoard[25][1] = true;

        gameBoard[23][2] = true;
        gameBoard[25][2] = true;

        gameBoard[13][3] = true;
        gameBoard[14][3] = true;
        gameBoard[21][3] = true;
        gameBoard[22][3] = true;
        gameBoard[35][3] = true;
        gameBoard[36][3] = true;

        gameBoard[12][4] = true;
        gameBoard[16][4] = true;
        gameBoard[21][4] = true;
        gameBoard[22][4] = true;
        gameBoard[35][4] = true;
        gameBoard[36][4] = true;

        gameBoard[1][5] = true;
        gameBoard[2][5] = true;
        gameBoard[11][5] = true;
        gameBoard[17][5] = true;
        gameBoard[21][5] = true;
        gameBoard[22][5] = true;

        gameBoard[1][6] = true;
        gameBoard[2][6] = true;
        gameBoard[11][6] = true;
        gameBoard[15][6] = true;
        gameBoard[17][6] = true;
        gameBoard[18][6] = true;
        gameBoard[23][6] = true;
        gameBoard[25][6] = true;

        gameBoard[11][7] = true;
        gameBoard[17][7] = true;
        gameBoard[25][7] = true;

        gameBoard[12][8] = true;
        gameBoard[16][8] = true;

        gameBoard[13][9] = true;
        gameBoard[14][9] = true;
*/
        /*gameBoard[0][0] = true;
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
        gameBoard[33][6] = true;*/

    }


    /**
     * Counts cell neighbours for next generation.
     *
     * @param x the arrays x position
     * @param y the arrays y position
     * @return counter Returns the value of counter after
     *         checking the rules
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
     *  @author Rudi André Dahle on 04.03.2016
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
     * Returns the generation counter as a string value
     * to show as label.
     *
     * @author Olav Smevoll
     * @return s Value of generation counter in to strings
     */
    public String getGenCounter(){
        String s = Integer.toString(genCounter);
        return s;
    }

    /**
     * Resets the generation counter to zero when
     * the clear button is fired
     *
     * @author Olav Smevoll
     */

    public void resetGenCount(){
        genCounter = 0;
    }


    /**
     * Gameboard's width in number of cells
     *
     * @author Rudi André Dahle 24.03.16
     * @return cellsWide Returns the cell's width
     */

    public int getBoardWidth() {
        return cellsWide;
    }


    /**
     * Gameboards height in number of cells
     *
     * @author Rudi André Dahle 24.03.16
     * @return cellsHigh Returns the cell's height
     */
    public int getBoardHeight() {
        return cellsHigh;
    }


    /**
     * Sets Gameboard's height
     *
     * @author Rudi André Dahle on 24.03.16
     * @param y Integer value of the board's height
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
     *
     * @author RudiAndre on 01.03.2016.
     * @return gameBoard
     */
    public boolean[][] getGameBoard() {
        return gameBoard;
    }


    /**
     * Sets the GameBoard
     *
     * @author Rudi André Dahle on 01.03.2016.
     * @param gameBoard
     */
    public void setGameBoard(boolean[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    /**
     * Clears the board when new board is loaded from rle file
     *
     * @author Olav Smevoll
     */
    public void clearBoard(){
        System.out.println("KJØRT");

        for (int x = 0; x < gameBoard.length; x++) {
            for (int y = 0; y < gameBoard[0].length; y++) {
                gameBoard[x][y] = false;
            }
        }
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