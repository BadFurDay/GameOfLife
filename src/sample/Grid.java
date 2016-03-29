package sample;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
/**
 * Created by Ginelle on 3/3/2016.
 */
public class Grid extends Canvas {

    //datafelt
    private GraphicsContext gc;
    private int canvasHeight; //Canvas' height.
    private int canvasWidth; //Canvas' width.
    private int cellWidth;
    private int cellHeight;
    /* public Grid() {
         // Redraw canvas when size changes.
         widthProperty().addListener(evt -> draw());
         heightProperty().addListener(evt -> draw());
     }
 */

    //Constructor
    public Grid(GraphicsContext gc) {
        this.gc = gc;
    }

    //Methods
    public void draw() {
      //  System.out.println("Cellebredde: " + cellWidth);
      //  System.out.println("Cellehøyde: " + cellHeight);
        for(int x = 0; x < canvasWidth; /*x += 18*/ x += cellWidth) {
            //Horizontal lines
            gc.strokeLine(0, x, canvasWidth, x);
           // for (int y = 0; y < canvasHeight; y += cellHeight) {
                //Vertical lines
                gc.strokeLine(x, 0, x, canvasHeight);
            //}
        }
    }

    public void clearGrid(){
        gc.clearRect(0, 0, canvasWidth, canvasHeight);
    }

    /**
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

    public void setCellWidth(int cellWidth) {
        this.cellWidth = cellWidth;
    }

    /*public int getCellHeight(int cellHeight){
      //  System.out.println(cellHeight);
        return cellHeight;
    }*/

    public void setCellHeight(int cellHeight) {
        this.cellHeight = cellHeight;
    }

    /**
     *  Rudi 29.03.16
     */
    public void setCanvasHeight(int canvasHeight) {
        this.canvasHeight = canvasHeight;
    }

    /**
     *  Rudi 29.03.16
     * @return
     */
    public int getCanvasWidth() {
        return gc.getCanvas().widthProperty().intValue();
    }

    /**
     * Rudi 29.03.16
     */
    public void setCanvasWidth(int canvasWidth){
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