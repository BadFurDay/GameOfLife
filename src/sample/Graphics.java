package sample;

import javafx.scene.canvas.GraphicsContext;


/**
 * Created by Ginelle on 3/4/2016.
 */
public class Graphics {

    //Data field
    protected GraphicsContext gc;
    protected int genCounter;
    private int cellHeight; //Height of each individual cell
    private int cellWidth;  //Width of each individual cell

    //Constructor
    public Graphics (GraphicsContext gc, int cellWidth, int cellHeight){
        this.cellHeight = gc.getCanvas().heightProperty().intValue()/cellHeight;
        this.cellWidth = gc.getCanvas().widthProperty().intValue()/cellWidth;
        this.gc = gc;
    }

    //Objects


    //Methods

    /**
     *
     * @param gameBoard
     */
    public void draw(boolean[][] gameBoard) {
        for (int x = 0; x < gameBoard.length; x++) {
            for (int y = 0; y < gameBoard[0].length; y++) {
                if (gameBoard[x][y]) {
                    gc.fillRect(x * getCellWidth(), y * getCellHeight(), getCellWidth(), getCellHeight());
                } else if (!gameBoard[x][y]) {
                    gc.clearRect(x * getCellWidth(), y * getCellHeight(), getCellWidth(), getCellHeight());
                }
            }
        }
        genCounter++;
        //System.out.println(genCounter);
    }

    public String getGenCounter(){
        String s = Integer.toString(genCounter);
        return s;
    }


    /**
     * Rudi 25.03.16
     * @return
     */
    public int getCellWidth() {
        //System.out.println("Bredde: " + cellWidth);
        return cellWidth;
    }


    /**
     * Calculates the width of a single cell
     *  Rudi 25.03.16
     * @return
     */
    public void setCellWidth(int cellsWide){
        this.cellWidth = gc.getCanvas().widthProperty().intValue()/cellsWide;
        System.out.println(gc.getCanvas().widthProperty().intValue()/cellsWide);
    }


    /**
     * Rudi 25.03.16
     * @return
     */
    public int getCellHeight() {
       // System.out.println("Høyde: " + cellHeight);
        return cellHeight;
    }


    /**
     * Calculates the height of a single cell
     *  Rudi 25.03.16
     * @return
     */
    public void setCellHeight(int cellsHigh) {
        this.cellHeight = gc.getCanvas().heightProperty().intValue()/cellsHigh;
        //System.out.println(gc.getCanvas().heightProperty().intValue()/cellsHigh);
    }
}
