/**
 * Cell class
 *
 *  @author Rudi André Dahle
 */
package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class Cell /*extends Graphics*/ {

    /*
     * Note...
     *
     * Tenkte å sette metodene som er relatert til cellens mouseventer
     * her sånn at vi slipper å ha så mange metoder inni bare en klasse (graphics klassen).
     * Har prøvd å gjøre det, men fikk feilmelding.
     *
     * Dette er ikke så viktig, så dette kan vi ordne når vi får ekstra tid ;)
     *
     */


    //Data field
  //  private int xCell; // X-index of cell
  //  private int yCell; // Y-index of cell

  //  Graphics graphics;
  //  public Cell(GraphicsContext gc) {
  //      super(gc);
  //  }



    /**
     *
     * @author Rudi
     * @param graphicsBoard
     */
   /* public void drawCell(boolean[][] graphicsBoard) {
        if (!graphicsBoard[getXCell()][getYCell()]) {
            graphicsBoard[getXCell()][getYCell()] = true;
        } else {
            graphicsBoard[getXCell()][getYCell()] = false;
        }
       draw(graphicsBoard);
    }*/

    /**
     *
     * @author Rudi
     * @param xCoord
     */
  /*  public void setXCell(double xCoord){
        xCell = (int)Math.floor(xCoord/super.getCellWidth());
    }*/

    /**
     *
     * @author Rudi
     * @param yCoord
     */
  /*  public void setYCell(double yCoord){
        yCell = (int)Math.floor(yCoord/super.getCellHeight());
    }*/

    /**
     *
     * @author Rudi
     * @return
     */
  /*  public int getXCell(){
        return xCell;
    }*/

    /**
     *
     * @author Rudi
     * @return
     */
   /* public int getYCell(){
        return yCell;
    }*/

}
