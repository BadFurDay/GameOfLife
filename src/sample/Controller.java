/**
 * Main controller is located at the bottom of the game window.
 * It contains all the buttons and sliders that the user will
 * use to manipulate the game.
 *
 * @author Ginelle Ignacio
 * @author Rudi André Dahle
 * @author Olav Smevoll
 */

package sample;

import javafx.animation.Animation;
import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;

import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.paint.Color;


public class Controller implements Initializable{

    //REMOVE LATER?
    private static class Cell{
        public double x, y;
        public void draw(GraphicsContext gc, Color drawColor, double size) {
            gc.setFill(drawColor);
            gc.fillRect(x, y, size, size);
        }

    }

    //Data field
    @FXML Canvas canvas;
    @FXML private ColorPicker colorPicker;
    @FXML private ColorPicker backgroundColor;
    @FXML private Slider zoomSlider;
    @FXML private Slider speedSlider;
    @FXML private Button playPause;
    @FXML private Label genCounter;
    private GraphicsContext gc;
    private Timeline timeline;
    private boolean running = false;
    private boolean showGrid = false;
    private List<Cell> cellList;
    private double FPS; //frames per second


    //Objects
    Grid grid;
    Board gameBoard;
    Graphics graphics;
    FileHandler reader;
    PatternFormatException pfe;
    Stage helpWindow;
    Stage readWeb;
    ErrorWindows error;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Objects
        gc = canvas.getGraphicsContext2D();
        gameBoard = new Board();
        graphics = new Graphics(gc);
        grid = new Grid(gc);
        reader = new FileHandler();
        pfe = new PatternFormatException();
        helpWindow = new Stage();
        readWeb = new Stage();
        error = new ErrorWindows();

        //Grid properties
        graphics.setCellHeight(gameBoard.getBoardHeight());
        graphics.setCellWidth(gameBoard.getBoardWidth());
        grid.setCanvasHeight(gc.getCanvas().heightProperty().intValue());
        grid.setCanvasWidth(gc.getCanvas().widthProperty().intValue());
        grid.setCellWidth(graphics.getCellWidth());
        grid.setCellHeight(graphics.getCellHeight());

        //Initial properties in the GUI
        genCounter.setText(gameBoard.getGenCounter());
        graphics.gc.setFill(Color.rgb(26,0,104));
        colorPicker.setValue(Color.rgb(26,0,104));
        backgroundColor.setValue(Color.SILVER);
        zoomSlider.setValue(10.0);
        zoomSlider.setShowTickMarks(true);
        speedSlider.setValue(10.0);
        speedSlider.setShowTickMarks(true);
        speedSlider.setShowTickMarks(true);
        FPS = 10;

        //Time properties responsible for the animation
        Duration duration = Duration.millis(1000/FPS);
        KeyFrame keyframe = new KeyFrame(duration, (ActionEvent e) -> {
            graphics.draw(gameBoard.getGameBoard());
                if(showGrid){
                    grid.draw();
                }
            gameBoard.nextGeneration(grid);
            genCounter.setText(gameBoard.getGenCounter());
        });
        timeline = new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.getKeyFrames().add(keyframe);
    }

    //fix later
    public void draw(){
        gc.clearRect(0, 0, canvas.widthProperty().doubleValue(), canvas.heightProperty().doubleValue());
        for ( Cell c : cellList ) {
            c.draw(gc, colorPicker.getValue(), zoomSlider.getValue());
        }
    }

    /**
     * Method called when user selects a single cell
     * to input in the canvas area
     *
     * @param event Represents a mouse event used when
     *              the user interacts with the GUI.
     */
    public void selectCell(MouseEvent event){
        //gameboard
        //c.x og x.y
    }

    //fix later
    public void canvasMouseDragged(MouseEvent event){
        Cell c = new Cell();
        c.x = event.getX();
        c.y = event.getY();
        cellList.add(c);
        draw();
    }

    /**
     * Method called when user plays or pauses the button
     * for the animation
     *
     * @author Rudi André Dahle
     * @param actionEvent represents an Action Event used to
     *                    when a button has been fired.
     */
    @FXML
    public void OnStartClick(ActionEvent actionEvent) {
       if(timeline.getStatus() == Status.RUNNING) {
            timeline.pause();
            running = false;
        } else {
            timeline.play();
            running = true;
        }
    }


    /**
     *Changes the text on the play button pause and vice versa
     */
    public void playPauseEvent(){
        if(running){
            playPause.setText("Pause");
        } else {
            playPause.setText("Play");
        }
    }


    /**
     * Clear button to clear the cells in the canvas area
     * @author Ginelle
     * @param actionEvent represents an Action Event used to
     *                    when a button has been fired.
     */
    public void clearEvent(ActionEvent actionEvent){
        timeline.stop();
        playPause.setText("Play");
        gc.clearRect(0, 0, canvas.widthProperty().doubleValue(), canvas.heightProperty().doubleValue());
        gameBoard.resetGenCount();
        gameBoard.clearBoard();

        if (showGrid) {
            grid.draw();
        } else {
            grid.clearGrid();
        }
    }

    /**
     * Speed slider manipulates the speed of animation
     *
     * @author Ginelle
     * @param event Represents a mouse event used when
     *              the user interacts with the slider.
     */
    public void speedChanged(MouseEvent event) {
        timeline.stop();

        double FPS = speedSlider.getValue();

        if (running) {
            if (FPS != 0) {
                Duration duration = Duration.millis(1000 / FPS);
                KeyFrame keyframe = new KeyFrame(duration, (ActionEvent e) -> {
                    graphics.draw(gameBoard.getGameBoard());
                    gameBoard.nextGeneration(grid);
                    genCounter.setText(gameBoard.getGenCounter());
                        if(showGrid){
                            grid.draw();
                        }
                });
                timeline = new Timeline();
                timeline.setCycleCount(Animation.INDEFINITE);
                timeline.getKeyFrames().add(keyframe);
                timeline.play();
            }
        }
    }

    /**
     * Zoom slider to zoom the animation in and out
     *
     * @param event Represents a mouse event used when
     *              the user interacts with the slider
     */

    public void zoomChanged(MouseEvent event) {

    }

    /**
     * Color picker changes the colors of the cells
     *
     * @author Ginelle
     * @param actionEvent represents an Action Event used to
     *                    when a button has been fired.
     */
    public void colorChanged(ActionEvent actionEvent){
        graphics.gc.setFill(colorPicker.getValue());
    }


    /**
     * Change background color of the game.
     * @author Rudi
     * @param actionEvent represents an Action Event used to
     *                    when a button has been fired.
     */
    public void backgroundChanged(ActionEvent actionEvent){
        //MÅ FIKSES
        double canvasWidth = canvas.getWidth();
        double canvasHeight = canvas.getHeight();

        gc.setFill(backgroundColor.getValue());
        gc.fillRect(0, 0, canvasWidth, canvasHeight);

    }


    /**
     * Grid toggle to make the grid visible or invisible
     *
     * @author Rudi
     * @param actionEvent represents an Action Event used to
     *                    when a button has been fired.
     */

    public void gridEvent(ActionEvent actionEvent) {
        if (!showGrid) {
            showGrid = true;
            //graphics.draw(gameBoard.getGameBoard());
            grid.draw();
        }else {
            showGrid = false;
            grid.clearGrid();
            graphics.draw(gameBoard.getGameBoard());
        }
    }

    /**
     * Rules of Game of Life located in the menu under help
     *
     * @author Ginelle 01.04.16
     * @param ae represents an Action Event used to
     *           when a menu item has been clicked
     */

    public void helpEvent (ActionEvent ae) throws IOException {
        Parent helpRoot = FXMLLoader.load(getClass().getClassLoader().getResource("Rules/Guide.fxml"));
        helpWindow.setTitle("Guidelines");
        helpWindow.setScene(new Scene(helpRoot));
        helpWindow.show();
    }

    /**
     * "Open File..." menu item set to open FileChooser window
     *
     * @author Rudi 01.04.16
     * @param ae represents an Action Event used to
     *           when a menu item has been clicked
     */

    public void openFiles(ActionEvent ae)throws IOException {
        try {
            reader.chooseFile();
        } catch (FileNotFoundException fe){
            System.err.println("File not found!");
            error.fileNotFound();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error opening file!");
            error.errorOpeningfile();
        } catch (NoSuchElementException ne){
            System.err.println("File format does not match!");
            error.incorrectMatch();
        } catch (IllegalStateException ie) {
            System.err.println("Error reading from file!");
            error.errorReading();
        }
        //pfe.openFiles();
    }


    /**
     * Method called when the user selects "Read Web File.."
     * on the menu list under "File". This method will read
     * an RLE file of an web address.
     *
     * @author Ginelle Ignacio
     * @param ae represents an Action Event used to
     *           when a menu item has been clicked
     * @throws IOException
     */

    public void webFile(ActionEvent ae) throws IOException {
       try {
           Parent webRoot = FXMLLoader.load(getClass().getClassLoader().getResource("Files/Webfile.fxml"));
           readWeb.setTitle("Read web file");
           readWeb.setScene(new Scene(webRoot));
           readWeb.show();
            //reader.readGameBoardFromURL();
        /*} catch (IOException e){
           throw new RuntimeException(e);*/
        } catch (MalformedURLException me){
            System.err.println("Invalid web address!");
            error.invalidURL();
        } catch (IOException ie) {
           System.err.println("Problem opening URL connection");
           error.errorConnection();
       }
    }

    public void setStage(){

    }

    /**
     * Method called when the user clicks on the "Close"
     * item located in Menu under File to close whole window
     *
     * @author Ginelle Ignacio
     * @param ae represents an Action Event used to
     *           when a menu item has been clicked
     */

    public void closeWindow (ActionEvent ae){
        System.exit(0);
    }
}