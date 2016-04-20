/**
 * Grid class that enables the user to make the grid
 * visible or invisible according to their preference.
 *
 * @author Rudi André Dahle
 * @author Ginelle Ignacio
 */

package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;


public class Grid extends Canvas {

    //Data field
    private GraphicsContext gcGrid;
    private double canvasHeight;
    private double canvasWidth;
    private double cellWidth;
    private double cellHeight;

    //Constructor
    public Grid(GraphicsContext gcGrid) {
        this.gcGrid = gcGrid;
        /*// Redraw canvas when size changes.
        widthProperty().addListener(evt -> draw());
        heightProperty().addListener(evt -> draw());*/
    }


    /**
     * Draws the grid lines on the canvas area
     *
     * @author Rudi André Dahle
     */
    public void draw() {
        // vertical lines
        for (double x = 0; x < canvasWidth; x += cellWidth) {
            gcGrid.strokeLine((int)x, 0, (int)x, (int)canvasHeight);
        }
        // horizontal lines
        for (double y = 0; y < canvasHeight; y += cellHeight) {
            gcGrid.strokeLine(0, (int)y, (int)canvasWidth, (int)y);
        }
    }


    /**
     * Clears the grid lines on the canvas area
     *
     * @author Ginelle
     */
    public void clearGrid(){
         gcGrid.clearRect(0, 0, canvasWidth, canvasHeight);
    }


    /**
     * Gets the canvas' height
     *
     * @author Rudi André Dahle on 29.03.16
     * @return
     */
    public int getCanvasHeight() {
        return gcGrid.getCanvas().heightProperty().intValue();
    }


    /**
     * Sets the cell width
     * @author Rudi André Dahle
     * @param cellWidth
     */
    public void setCellWidth(double cellWidth) {
        this.cellWidth = cellWidth;
    }


    /**
     * Sets the cell's height
     *
     * @author Rudi André Dahle
     * @param cellHeight
     */
    public void setCellHeight(double cellHeight) {
        this.cellHeight = cellHeight;
    }


    /**
     *  Sets the canvas' height
     *
     *  @author Rudi André Dahle 29.03.16
     *  @param canvasHeight
     */
    public void setCanvasHeight(double canvasHeight) {
        this.canvasHeight = canvasHeight;
    }

    /**
     *  Gets the canvas' width
     *
     *  @author Rudi André Dahle 29.03.16
     *  @return canvasWidth
     */
    public int getCanvasWidth() {
        return gcGrid.getCanvas().widthProperty().intValue();
    }

    /**
     * Sets the canvas' width
     *
     * @author Rudi André Dahle 29.03.16
     * @param canvasWidth
     */
    public void setCanvasWidth(double canvasWidth){
        this.canvasWidth = canvasWidth;
    }


    /*@Override
    public boolean isResizable() {
        return true;
    }
    @Override
    public double prefWidth(double height) {
        return getWidth();
    }
    @Override
    public double prefHeight(double width) {
        return getHeight();
    }*/
}
