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

    /**
     * Grid's default constructor receives an
     * argument of the GraphicsContext class
     * to draw calls to the canvas area.
     *
     * @param gcGrid Receives the content related to
     *               GraphicsContext
     */
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
        long start = System.currentTimeMillis();
        // vertical lines
        for (double x = 0; x < canvasWidth; x += cellWidth) {
            gcGrid.strokeLine((int)x, 0, (int)x, (int)canvasHeight);
        }

        // horizontal lines
        for (double y = 0; y < canvasHeight; y += cellHeight) {
            gcGrid.strokeLine(0, (int)y, (int)canvasWidth, (int)y);
        }
        long stop = System.currentTimeMillis();
        System.out.println("gridDraw: "+(stop-start)+"ms");
    }


    /**
     * Clears the grid lines on the canvas area
     *
     * @author Ginelle Ignacio
     */
    public void clearGrid(){
         gcGrid.clearRect(0, 0, canvasWidth, canvasHeight);
    }


    /**
     * Gets the value of canvas' height
     *
     * @author Rudi André Dahle
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
     * @param cellWidth Width of a single cell
     */
    public void setCellWidth(double cellWidth) {
        this.cellWidth = cellWidth;
    }


    /**
     * Sets the value of the cell's height
     *
     * @author Rudi André Dahle
     * @param cellHeight Receives the decimal value of
     *                   the cell's height
     */
    public void setCellHeight(double cellHeight) {
        this.cellHeight = cellHeight;
    }


    /**
     *  Sets the canvas' height
     *
     *  @author Rudi André Dahle
     *  @param canvasHeight Receives the decimal value
     *                      of the canvas' height
     */
    public void setCanvasHeight(double canvasHeight) {
        this.canvasHeight = canvasHeight;
    }


    /**
     *  Gets the value of canvas' width
     *
     *  @author Rudi André Dahle
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
     * @param canvasWidth Receives the decimal value of
     *                    canvas' width
     */
    public void setCanvasWidth(double canvasWidth){
        this.canvasWidth = canvasWidth;
    }


    /*@Override
    public boolean isResizable() {
        return true;
    }
    @Override12
    public double prefWidth(double height) {
        return getWidth();
    }
    @Override
    public double prefHeight(double width) {
        return getHeight();
    }*/
}
