package sample;

import javafx.scene.canvas.GraphicsContext;


/**
 * Created by Ginelle on 3/4/2016.
 */
public class Graphics {

    //Data field
    protected GraphicsContext gc;
    protected int genCounter;
    private double cellHeight; //Height of each individual cell
    private double cellWidth;  //Width of each individual cell

    //Constructor
    public Graphics (GraphicsContext gc/*, int cellWidth, int cellHeight*/){
       // this.cellHeight = gc.getCanvas().heightProperty().intValue()/cellHeight;
       // this.cellWidth = gc.getCanvas().widthProperty().intValue()/cellWidth;
        this.gc = gc;
    }

    //Objects


    //Methods

    /**
     * Draws the board with existing cells for every loop.
     * @param gameBoard
     */
    public void draw(boolean[][] gameBoard) {
        System.out.println("Cellestørrelse: " + getCellHeight());
        for (int x = 0; x < gameBoard.length; x++) {
            for (int y = 0; y < gameBoard[0].length; y++) {
                if (gameBoard[x][y]) {
                    //gc.fillRoundRect(x * getCellWidth(), y * getCellHeight(), getCellWidth(), getCellHeight(), getCellWidth(), getCellWidth());
                    gc.fillRect(x * getCellWidth(), y * getCellHeight(), getCellWidth(), getCellHeight());
                } else if (!gameBoard[x][y]) {
                    gc.clearRect(x * getCellWidth(), y * getCellHeight(), getCellWidth(), getCellHeight());
                }
            }
        }
        genCounter++;
    }

    /**
     * Returns the genCounter as a string to show as a label.
     * @return
     */
    public String getGenCounter(){
        String s = Integer.toString(genCounter);
        return s;
    }


    /**
     * Rudi 25.03.16
     * Returns the cellWidth.
     * @return
     */
    public double getCellWidth() {
        //System.out.println("Celle bredde: " + cellWidth);
        return cellWidth;
    }


    /**
     * Rudi 25.03.16
     * Returns the cellHeight.
     * @return
     */
    public double getCellHeight() {
        // System.out.println("Celle høyde: " + cellHeight);
        return cellHeight;
    }


    /**
     * Calculates the width of a single cell.
     *  Rudi 25.03.16
     * @return
     */
    public void setCellWidth(int cellsWide){
        this.cellWidth = (double)gc.getCanvas().widthProperty().intValue()/cellsWide;
        //System.out.println(gc.getCanvas().widthProperty().intValue()/cellsWide);
    }



    /**
     * Calculates the height of a single cell.
     *  Rudi 25.03.16
     * @return
     */
    public void setCellHeight(int cellsHigh) {
         this.cellHeight = (double)gc.getCanvas().heightProperty().intValue()/cellsHigh;

        //System.out.println(gc.getCanvas().heightProperty().intValue()/cellsHigh);
    }

    /**
     * Resets the genCounter when the board is cleared.
     *
     */

    public void resetGenCount(){

        genCounter = 0;
    }
}
