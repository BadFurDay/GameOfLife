/**
 * Grid class that enables the user to make the grid
 * visible or invisible according to their preference.
 *
 * @author Rudi André Dahle
 * @author Ginelle Ignacio
 * @author Olav Smevoll
 */

package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Grid extends Canvas{

    //Data field
    private GraphicsContext gcGrid;
    private double canvasHeight;
    private double canvasWidth;
    private double cellWidth;
    private double cellHeight;
    private boolean showGrid = false;


    /**
     * Grid's default constructor receives an
     * argument of the GraphicsContext class
     * to drawGrid calls to the canvas area.
     *
     * @author Rudi André Dahle
     * @author Olav Smevoll
     * @author Ginelle Ignacio
     * @param gcGrid Receives the content related to
     *               GraphicsContext
     */
    public Grid(GraphicsContext gcGrid) {
        this.gcGrid = gcGrid;
    }


    /**
     * Draws the grid lines on the canvas area
     *
     * @author Rudi André Dahle
     * @author Olav Smevoll
     * @author Ginelle Ignacio
     */
    public void drawGrid() {
        for (double x = 0; x < canvasWidth; x += cellWidth) {
            gcGrid.strokeLine((int)x, 0, (int)x, (int)canvasHeight);
        }
        for (double y = 0; y < canvasHeight; y += cellHeight) {
            gcGrid.strokeLine(0, (int)y, (int)canvasWidth, (int)y);
        }
    }


    /**
     * Clears the grid lines on the canvas area
     *
     * @author Ginelle Ignacio
     * @author Rudi André Dahle
     * @author Olav Smevoll
     */
    public void clearGrid(){
         gcGrid.clearRect(0, 0, canvasWidth, canvasHeight);
    }


    /**
     * Gets the value of canvas' height
     *
     * @author Rudi André Dahle
     * @author Olav Smevoll
     * @author Ginelle Ignacio
     * @return canvasH Returns the height of the canvas
     */
    public int getCanvasHeight() {
        int canvasH = gcGrid.getCanvas().heightProperty().intValue();
        return canvasH;
    }


    /**
     * Sets the value of the cell width
     *
     * @author Rudi André Dahle
     * @author Olav Smevoll
     * @author Ginelle Ignacio
     * @param cellWidth Width of a single cell
     */
    public void setCellWidth(double cellWidth) {
        this.cellWidth = cellWidth;
    }


    /**
     * Sets the value of the cell's height
     *
     * @author Rudi André Dahle
     * @author Olav Smevoll
     * @author Ginelle Ignacio
     * @param cellHeight Receives the decimal value of
     *                   the cell's height
     */
    public void setCellHeight(double cellHeight) {
        this.cellHeight = cellHeight;
    }


    /**
     *  Sets the canvas' height
     *
     * @author Rudi André Dahle
     * @author Olav Smevoll
     * @author Ginelle Ignacio
     * @param canvasHeight Receives the decimal value
     *                      of the canvas' height
     */
    public void setCanvasHeight(double canvasHeight) {
        this.canvasHeight = canvasHeight;
    }


    /**
     *  Gets the value of canvas' width
     *
     *  @author Rudi André Dahle
     *  @author Olav Smevoll
     *  @author Ginelle Ignacio
     *  @return canvasWidth Returns the integer value
     *          of canvas' width
     */
    public int getCanvasWidth() {
        return gcGrid.getCanvas().widthProperty().intValue();
    }


    /**
     * Sets the value of canvas' width
     *
     * @author Rudi André Dahle
     * @author Olav Smevoll
     * @author Ginelle Ignacio
     * @param canvasWidth Receives the decimal value of
     *                    canvas' width
     */
    public void setCanvasWidth(double canvasWidth){
        this.canvasWidth = canvasWidth;
    }
}
