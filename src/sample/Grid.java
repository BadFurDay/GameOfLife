package sample;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by Ginelle on 3/3/2016.
 */
public class Grid extends Canvas {

    //datafelt
    private GraphicsContext gc;
    private int canvasHeight; //Canvas' height.
    private int canvasWidth; //Canvas' width.
    private double cellWidth;
    private double cellHeight;
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
        // vertical lines
        gc.setStroke(Color.BLUE);
        for(double x = 0 ; x < canvasWidth ; x += cellWidth){
            //gc.strokeLine(0, x, canvasWidth, x);
            gc.strokeLine(x, 0, x, canvasHeight);
        }
        // horizontal lines
        gc.setStroke(Color.RED);
        for(double y = 0 ; y < canvasHeight ; y += cellHeight){
            //gc.strokeLine(y, 0, y, canvasHeight);
            gc.strokeLine(0, y, canvasWidth, y); //MÅ FIKSES, ANNENHVER LINJE ER SKEIV(skyldes bruk av type double, type int fikser dette).
        }


        //Horizontal lines
       /* for(double x = 0; x < canvasWidth; x += cellWidth) {
            gc.strokeLine(0, x, canvasWidth, x);
        }
        //Vertical lines
            for (int y = 0; y < canvasHeight; y += cellHeight) {
                gc.strokeLine(y, 0, y, canvasHeight);
            }*/
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

    public void setCellWidth(double cellWidth) {
        this.cellWidth = cellWidth;
    }

    /*public int getCellHeight(int cellHeight){
      //  System.out.println(cellHeight);
        return cellHeight;
    }*/

    public void setCellHeight(double cellHeight) {
        this.cellHeight = cellHeight;
    }

    /**
     *  Rudi 29.03.16
     */
    public void setCanvasHeight(int canvasHeight) {
        System.out.println("Canvas høyde: "+canvasHeight);
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