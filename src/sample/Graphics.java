/**
 * Graphics Class contains the logic and functionality
 * of the cell. This class is called when the game
 * starts.
 *
 * @author Rudi André Dahle
 */
package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;

import java.util.List;


public class Graphics {

    //Data field
    protected GraphicsContext gc;           //Draws calls to the canvas area
    private double cellHeight;              //Height of each individual cell
    private double cellWidth;               //Width of each individual cell
    private int xCell;
    private int yCell;




    /**
     * Graphics' default constructor receives an
     * argument of the GraphicsContext's class to
     * draw calls to the canvas area.
     *
     * @author Rudi André Dahle
     * @param gc Receives the content related to
     *           GraphicsContext
     */
    public Graphics (GraphicsContext gc){
        this.gc = gc;
    }

    /**
     * Draws the board with existing cells for every loop.
     *
     * @author Rudi André Dahle
     * @param graphicsBoard Receives the value of the graphicBoard
     *                      in boolean 2D array
     */
    public void draw(boolean[][] graphicsBoard) {
        for(int x = 0; x < graphicsBoard.length; x++) {
            for(int y = 0; y < graphicsBoard[0].length; y++) {
                if (graphicsBoard[x][y]) {
                    gc.fillRect(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
                   // gc.fillOval(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
                }
            }
        }
    }

    /**
     * Method called to make the cells visible on the
     * dynamic board
     *
     * @author Olav Smevoll
     * @param dynamicBoard Parameter receives a list within a list
     *                     and a boolean element of the dynamic board
     */
    public void drawDynamic(List<List<Boolean>> dynamicBoard){
        clearDynamicBoard();
        for(int x = 0; x < dynamicBoard.size(); x++){
            for(int y = 0; y < dynamicBoard.size(); y++){
                if(dynamicBoard.get(x).get(y)){
                    gc.fillRect(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
                    //gc.fillRect(x * getCellWidth(), y * getCellHeight(), getCellWidth()-1, getCellHeight()-1);
                }
            }
        }
    }


    /**
     * Method called to make a living or dead cell when the user draws
     * into the canvas area.
     *
     * @author Rudi Andre Dahle
     * @author Ginelle Ignacio
     * @param dynamicBoard Parameter receives a list within a list
     *                     and a boolean element of the dynamic board
     */
    public void drawDynamicCell(List<List<Boolean>> dynamicBoard) {
        if (!dynamicBoard.get(xCell).get(yCell)) {
            dynamicBoard.get(xCell).set(yCell, true);
        } else {
            dynamicBoard.get(xCell).set(yCell, false);
            gc.clearRect(xCell * cellWidth, yCell * cellHeight, cellWidth, cellHeight);
        }
        drawDynamic(dynamicBoard);
    }


    /**
     * Clears the old board before the next generation is drawn
     *
     * @author Rudi André Dahle
     * @param gameBoard
     */
    public void clearBoard(boolean[][] gameBoard) {

        for(int x = 0; x < gameBoard.length; x++) {
            for (int y = 0; y < gameBoard[0].length; y++) {
                if (gameBoard[x][y]) {
                    gc.clearRect(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
                }
            }
        }
    }

    /**
     * Method called to clear the dynamic board area.
     *
     * @author Olav Smevoll
     * @param dynBoard Parameter receives a list within a list
     *                 and a boolean element of the dynamic board
     *
    public void clearDynamicBoard(List<List<Boolean>> dynBoard){
        for(int x = 0; x < dynBoard.size(); x++) {
            for (int y = 0; y < dynBoard.size(); y++) {

                gc.clearRect(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
            }
        }
    }*/

    /**
     * Method called to clear the dynamic board area.
     *
     * @author Olav Smevoll
     */
    public void clearDynamicBoard(){
        gc.clearRect(0,0,gc.getCanvas().getWidth(),gc.getCanvas().getHeight());
    }


    /**
     * Clears entire board when "Clear" button is pushed
     *
     * @author Rudi André Dahle
     * @param gameBoard
     */
   /* public void clearBoard(boolean[][] gameBoard) {
        for(int x = 0; x < gameBoard.length; x++) {
            for (int y = 0; y < gameBoard[0].length; y++) {
                gc.clearRect(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
            }
        }
    }*/

    /**
     *
     * Method called to draw a cell when the user interacts with
     * the canvas area.
     *
     * @author Rudi André Dahle
     * @param graphicsBoard Receives the value of the graphicBoard
     *                      in boolean 2D array
     */
    @Deprecated
    public void drawCell(boolean[][] graphicsBoard) {
        if (!graphicsBoard[xCell][yCell]) {
            graphicsBoard[xCell][yCell] = true;
        } else {
            graphicsBoard[xCell][yCell] = false;
            gc.clearRect(xCell * cellWidth, yCell * cellHeight, cellWidth, cellHeight);
        }
        draw(graphicsBoard);
    }


    /**
     * Computes the cell's x value when the user inserts
     * a cell in the canvas area.
     *
     * @author Rudi André Dahle
     * @param xCoord The coordinates in the canvas of the selected x-cell
     */
    public void setXCell(double xCoord){
        xCell = (int)Math.floor(xCoord/cellWidth);

    }


    /**
     * Sets and computes the cell's y value when the user inserts
     * a cell in the canvas area.
     *
     * @author Rudi André Dahle
     * @param yCoord The coordinates in the canvas of the selected y-cell
     */
    public void setYCell(double yCoord){
        yCell = (int)Math.floor(yCoord/cellHeight);
    }


    /**
     * Gets the x value of a cell.
     *
     * @author Rudi André Dahle
     * @return xCell Returns the integer value of  xCell.
     */
    public int getXCell(){
        return xCell;
    }


    /**
     * Gets the y value of a cell.
     *
     * @author Rudi André Dahle
     * @return yCell Returns the integer value of yCell
     */
    public int getYCell(){
        return yCell;
    }


    /**
     * Returns the cellWidth.
     *
     * @author Rudi André Dahle
     * @return cellWidth Returns the double value of
     *                   cellWidth.
     */
    public double getCellWidth() {
     //   System.out.println(cellWidth);
        return cellWidth;
    }


    /**
     * Returns the cellHeight.
     *
     * @author Rudi André Dahle
     * @return cellHeight Returns the double value of
     *                    cellHeight
     */
    public double getCellHeight() {
        return cellHeight;
    }


    /**
     * Sets and computes the width of a single cell.
     *
     * @author Rudi André Dahle
     * @param cellsWide Number of cells in the game board's width
     */
    public void setCellWidth(int cellsWide){
        this.cellWidth = (double)gc.getCanvas().widthProperty().intValue()/cellsWide;
    }


    /**
     * Calculates the height of a single cell.
     *
     * @author Rudi André Dahle
     * @param cellsHigh Number of cells in the game board's height
     */
    public void setCellHeight(int cellsHigh) {
         this.cellHeight = (double)gc.getCanvas().heightProperty().intValue()/cellsHigh;
    }

    @Deprecated
    public void drawCells(List<List<Boolean>> dynamicBoard) {
        if(dynamicBoard.get(xCell).set(yCell, true)){
            gc.fillRect(xCell * cellWidth, yCell * cellHeight, cellWidth, cellHeight);
        }
    }
}
