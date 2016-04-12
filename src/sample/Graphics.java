/**
 * Graphics Class contains the properties of the cell
 * and their sizes.
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
        for (int x = 0; x < graphicsBoard.length; x++) {
            for (int y = 0; y < graphicsBoard[0].length; y++) {
                if (graphicsBoard[x][y]) {
                    //gc.fillRoundRect(x * getCellWidth(), y * getCellHeight(), getCellWidth(), getCellHeight(), getCellWidth(), getCellWidth());
                    gc.fillRect(x * getCellWidth(), y * getCellHeight(), getCellWidth(), getCellHeight());
                } else if (!graphicsBoard[x][y]) {
                    gc.clearRect(x * getCellWidth(), y * getCellHeight(), getCellWidth(), getCellHeight());
                }
            }
        }
    }


    /**
     * Returns the cellWidth.
     *
     * @author Rudi André Dahle on 25.03.16
     * @return cellWidth
     */
    public double getCellWidth() {
        //System.out.println("Celle bredde: " + cellWidth);
        return cellWidth;
    }


    /**
     * Returns the cellHeight.
     *
     * @author Rudi André Dahle on 25.03.16
     * @return cellHeight
     */
    public double getCellHeight() {
        // System.out.println("Celle høyde: " + cellHeight);
        return cellHeight;
    }


    /**
     * Calculates the width of a single cell.
     *
     * @author Rudi André Dahle 5.03.16
     * @return cellWidth
     */
    public void setCellWidth(int cellsWide){
        this.cellWidth = (double)gc.getCanvas().widthProperty().intValue()/cellsWide;
        System.out.println("Cellebredden er: " + getCellWidth());
    }



    /**
     * Calculates the height of a single cell.
     *
     * @author Rudi André Dahle
     * @return cellHeight
     */
    public void setCellHeight(int cellsHigh) {
         this.cellHeight = (double)gc.getCanvas().heightProperty().intValue()/cellsHigh;
        System.out.println("Cellehøyden er: " + getCellHeight());
    }
}
