/**
 *
 *
 *  @author Rudi André Dahle
 */
package Main;

public class Cell {

    //Data field
    private boolean state = false;
    private boolean newState;

    //Constructor
    public Cell() {

    }

    public Cell(boolean state) {
        this.state = state;
    }

    public void setNewState(boolean state) {
        newState = state;
    }

    public void updateState() {
        state = newState;
    }

    public boolean getState() {
        return state;
    }
}
