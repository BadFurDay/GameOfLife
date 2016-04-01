package sample;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by Ginelle on 3/3/2016.
 */
public class Grid extends Canvas {

    //Data field
    private GraphicsContext gc;
    private double canvasHeight;
    private double canvasWidth;
    private double cellWidth;
    private double cellHeight;

    //Constructor
    public Grid(GraphicsContext gc) {
        this.gc = gc;
        /*// Redraw canvas when size changes.
        widthProperty().addListener(evt -> draw());
        heightProperty().addListener(evt -> draw());*/
    }


    /**
     * Draws the grid lines on the canvas area
     * @author Rudi
     */
    public void draw() {
        // vertical lines
        for (double x = 0; x < canvasWidth; x += cellWidth) {
            gc.strokeLine((int)x, 0, (int)x, (int)canvasHeight);
        }

        // horizontal lines
        for (double y = 0; y < canvasHeight; y += cellHeight) {
            gc.strokeLine(0, (int)y, (int)canvasWidth, (int)y);
        }
    }


    /**
     * Clears the grid lines on the canvas area
     * @author Ginelle
     */
    public void clearGrid(){
         gc.clearRect(0, 0, canvasWidth, canvasHeight);
    }

    /**
     * Gets the canvas' height
     * @author Rudi 29.03.16
     * @return
     */
    public int getCanvasHeight() {
        return gc.getCanvas().heightProperty().intValue();
    }

    /**
     * Sets the cell width
     * @author
     * @param cellWidth
     */
    public void setCellWidth(double cellWidth) {
        this.cellWidth = cellWidth;
    }


    /**
     * Sets the cell's height
     * @param cellHeight
     */
    public void setCellHeight(double cellHeight) {
        this.cellHeight = cellHeight;
    }

    /**
     *  Sets the canvas' height
     *  @author Rudi 29.03.16
     *  @param canvasHeight
     */
    public void setCanvasHeight(double canvasHeight) {
        System.out.println("Canvas høyde: "+canvasHeight);
        this.canvasHeight = canvasHeight;
    }

    /**
     *  Gets the canvas' width
     *  @author Rudi 29.03.16
     *  @return
     */
    public int getCanvasWidth() {
        return gc.getCanvas().widthProperty().intValue();
    }

    /**
     * Sets the canvas' width
     * @author Rudi 29.03.16
     * @param canvasWidth
     */
    public void setCanvasWidth(double canvasWidth){
        System.out.println("Canvas bredde: "+canvasWidth);
        this.canvasWidth = canvasWidth;
    }


    @Override
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
    }
}
