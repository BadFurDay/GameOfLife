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
    private Canvas canvas;
    private double canvasHeight; //Canvas' height.
    private double canvasWidth; //Canvas' width.
    private double cellWidth;
    private double cellHeight;

    //Constructor
    public Grid(GraphicsContext gc) {
        this.gc = gc;
        /*// Redraw canvas when size changes.
        widthProperty().addListener(evt -> draw());
        heightProperty().addListener(evt -> draw());*/
    }

    //Methods

    /**
     * Draws the grid lines on the canvas area
     */
    public void draw() {
        // vertical lines
        //gc.setStroke(Color.TRANSPARENT);
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
     */
    public void clearGrid(){
         gc.clearRect(0, 0, canvasWidth, canvasHeight);
    }

    /**
     * Gets the canvas' height
     *  Rudi 29.03.16
     * @return
     */
    public int getCanvasHeight() {
        return gc.getCanvas().heightProperty().intValue();
    }

    /*public int getCellWidth(int cellWidth) {
      //  System.out.println(cellWidth);
        return cellWidth;
    }*/


    /**
     * Sets the cell width
     * @param cellWidth
     */
    public void setCellWidth(double cellWidth) {
        this.cellWidth = cellWidth;
    }

    /*public int getCellHeight(int cellHeight){
      //  System.out.println(cellHeight);
        return cellHeight;
    }*/

    /**
     * Sets the cell's height
     * @param cellHeight
     */
    public void setCellHeight(double cellHeight) {
        this.cellHeight = cellHeight;
    }

    /**
     * Sets the canvas' height
     *  Rudi 29.03.16
     *  @param canvasHeight
     */
    public void setCanvasHeight(double canvasHeight) {
        System.out.println("Canvas høyde: "+canvasHeight);
        this.canvasHeight = canvasHeight;
    }

    /**
     *  Gets the canvas' width
     *  Rudi 29.03.16
     *  @return
     */
    public int getCanvasWidth() {
        return gc.getCanvas().widthProperty().intValue();
    }

    /**
     * Sets the canvas' width
     * Rudi 29.03.16
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
