/**
 * Graphics Class contains the properties of the cell
 * and their sizes. This class is called when the game
 * starts.
 *
 * @author Rudi André Dahle
 */

package sample;

import javafx.scene.canvas.GraphicsContext;


/**
 * Created by Ginelle on 3/4/2016.
 */
public class Graphics {

    //Data field
    protected GraphicsContext gc;
    private double cellHeight; //Height of each individual cell
    private double cellWidth;  //Width of each individual cell
    private int xCell; // X-index of cell
    private int yCell; // Y-index of cell

    //Constructor
    public Graphics (GraphicsContext gc/*, int cellWidth, int cellHeight*/){
       // this.cellHeight = gc.getCanvas().heightProperty().intValue()/cellHeight;
       // this.cellWidth = gc.getCanvas().widthProperty().intValue()/cellWidth;
        this.gc = gc;
    }

    /**
     * Draws the board with existing cells for every loop.
     * @param graphicsBoard
     */
    public void draw(boolean[][] graphicsBoard) {
        for(int x = 0; x < graphicsBoard.length; x++) {
            for(int y = 0; y < graphicsBoard[0].length; y++) {
                if (graphicsBoard[x][y]) {
                    gc.fillRoundRect(x * getCellWidth(), y * getCellHeight(), (getCellWidth()*0.8), (getCellHeight()*0.8), 100, 100);
                   // gc.fillRect(x * getCellWidth(), y * getCellHeight(), getCellWidth()*0.8, getCellHeight()*0.8);
                } else if (!graphicsBoard[x][y]) {
                    gc.clearRect(x * getCellWidth(), y * getCellHeight(), getCellWidth(), getCellHeight());
                }
            }
        }
    }

    /**
     *
     * @author Rudi
     * @param graphicsBoard
     */
    public void drawCell(boolean[][] graphicsBoard) {
        if (!graphicsBoard[getXCell()][getYCell()]) {
            graphicsBoard[getXCell()][getYCell()] = true;
        } else {
            graphicsBoard[getXCell()][getYCell()] = false;
        }
        draw(graphicsBoard);
    }

    /*public void clearCell(){
        graphicsBoard[getXCell()][getYCell()] = false;
    }*/

    /**
     *
     * @author Rudi
     * @param xCoord
     */
    public void setXCell(double xCoord){
        xCell = (int)Math.floor(xCoord/getCellWidth());
    }

    /**
     *
     * @author Rudi
     * @param yCoord
     */
    public void setYCell(double yCoord){
        yCell = (int)Math.floor(yCoord/getCellHeight());
    }

    /**
     *
     * @author Rudi
     * @return
     */
    public int getXCell(){
        return xCell;
    }

    /**
     *
     * @author Rudi
     * @return
     */
    public int getYCell(){
        return yCell;
    }

    /**
     * Returns the cellWidth.
     *
     * @author Rudi
     * @return cellWidth
     */
    public double getCellWidth() {
        return cellWidth;
    }


    /**
     * Returns the cellHeight.
     *
     * @author Rudi
     * @return cellHeight
     */
    public double getCellHeight() {
        return cellHeight;
    }


    /**
     * Calculates the width of a single cell.
     *
     * @author Rudi
     * @return cellWidth
     */
    public void setCellWidth(int cellsWide){
        this.cellWidth = (double)gc.getCanvas().widthProperty().intValue()/cellsWide;
    }



    /**
     * Calculates the height of a single cell.
     *
     * @author Rudi
     * @return cellHeight
     */
    public void setCellHeight(int cellsHigh) {
         this.cellHeight = (double)gc.getCanvas().heightProperty().intValue()/cellsHigh;
    }
}
