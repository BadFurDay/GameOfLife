package sample;

import javafx.animation.Animation;
import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
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

    //Datafield
    @FXML Canvas canvas;
    @FXML private ColorPicker colorPicker;
  //  @FXML private ColorPicker backgroundColor;
    @FXML private Slider zoomSlider;
    @FXML private Slider speedSlider;
    @FXML private Button playPause;
    @FXML private Toggle gridToggle;
    @FXML private Label genCounter;
    @FXML private Button clearButton;
    @FXML private MenuItem help;
    private GraphicsContext gc;
    private Timeline timeline;
    private double FPS;
    private boolean running = false;
    private List<Cell> cellList;
    private boolean showGrid = false;

    //Objects
    Grid grid;
    Board gameBoard;
    Graphics graphics;
    FileHandler reader;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Objects
        gc = canvas.getGraphicsContext2D();
        gameBoard = new Board();
        graphics = new Graphics(gc);
        grid = new Grid(gc);
        reader = new FileHandler();

        graphics.setCellHeight(gameBoard.getBoardHeight());
        graphics.setCellWidth(gameBoard.getBoardWidth());
        grid.setCanvasHeight(gc.getCanvas().heightProperty().intValue());
        grid.setCanvasWidth(gc.getCanvas().widthProperty().intValue());
        grid.setCellWidth(graphics.getCellWidth());
        grid.setCellHeight(graphics.getCellHeight());

        //Initial properties in the GUI
        genCounter.setText(gameBoard.getGenCounter());
        graphics.gc.setFill(Color.MEDIUMAQUAMARINE);
        colorPicker.setValue(Color.MEDIUMAQUAMARINE);
        //backgroundColor.setValue(Color.SILVER);
        zoomSlider.setValue(15.0);
        speedSlider.setValue(15.0);
        FPS = 10;

        //Time properties responsible for the animation
        Duration duration = Duration.millis(1000/FPS);
        KeyFrame keyframe = new KeyFrame(duration, (ActionEvent e) ->
        {graphics.draw(gameBoard.getGameBoard());
            if(showGrid){
                grid.draw();
            }
            gameBoard.nextGeneration(grid); genCounter.setText(gameBoard.getGenCounter()); });
        timeline = new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.getKeyFrames().add(keyframe);
    }


    /**
     * TEMPORARY FIX LATER
     */

    public void draw(){
        gc.clearRect(0, 0, canvas.widthProperty().doubleValue(), canvas.heightProperty().doubleValue());
        for ( Cell c : cellList ) {
            c.draw(gc, colorPicker.getValue(), zoomSlider.getValue());
        }
    }

    /**
     * User selects a single to input into the canvas
     *
     * @param event
     */

    public void canvasMouseDragged(MouseEvent event){
        Cell c = new Cell();
        c.x = event.getX();
        c.y = event.getY();
        cellList.add(c);
        draw();
    }

    /**
     * Play/Pause button for the animation
     *
     * @param actionEvent
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
     * @param actionEvent
     */
    public void clearEvent(ActionEvent actionEvent){
        timeline.stop();
        playPause.setText("Play");
        gc.clearRect(0, 0, canvas.widthProperty().doubleValue(), canvas.heightProperty().doubleValue());
        gameBoard.resetGenCount();
        
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
     * @param event
     */

    public void speedChanged(MouseEvent event) {
        timeline.stop();
        
        double FPS = speedSlider.getValue();

        if (running) {
            if (FPS != 0) {
                Duration duration = Duration.millis(1000 / FPS);
                KeyFrame keyframe = new KeyFrame(duration, (ActionEvent e) ->
                {
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
     * @param event
     */

    public void zoomChanged(MouseEvent event) {

    }

    /**
     * Color picker changes the colors of the cell
     *
     * @author Ginelle
     * @param actionEvent
     */

    public void colorChanged(ActionEvent actionEvent){
        graphics.gc.setFill(colorPicker.getValue());
    }

    /**
     * Change background color of the game.
     * @author Rudi
     * @param actionEvent
     */
   /* public void backgroundChanged(ActionEvent actionEvent){
        graphics.gc.setFill(backgroundColor.getValue());
    }*/

    /**
     * Grid toggle to make the grid visible or invisible
     *
     * @author Rudi
     * @param actionEvent
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
     * Rules of Game of Life9 located in the menu under help
     *
     * @author Ginelle 01.04.16
     * @param actionEvent
     */

    public void helpEvent (ActionEvent actionEvent){
        Stage helpDialog= new Stage();
        helpDialog.initModality(Modality.WINDOW_MODAL);
        helpDialog.setTitle("Rules in Game of Life");

        Scene helpScene = new Scene(VBoxBuilder.create()
                .children(new Text ("Game of life \n \n" +
                        "The rules of the game are simple, and describe the evolution of the grid.\n \n" +
                        "The two-dimensiononal grid of square cells, each of which is in one of two possible states, live or dead. \n" +
                        "Every cell interacts with its eight neighbours, which are the cells that are directly horizontally, vertically \n"+
                        "or diagonally adjacent. At each step in time, the following transitions occur:\n \n " +
                        "\t 1. Any live cell with fewer than two live neighbours dies because it is underpopulated.\n" +
                        "\t 2. Any live cell with more than three live neighbours dies because it is overpopulated.\n" +
                        "\t 3. Any live cell with two or three live neighbours lives, unchanged, to the next generation.\n" +
                        "\t 4. Any dead cell with exactly three live neighbours will come to life."))
                .alignment(Pos.CENTER)
                .padding(new Insets(40))
                .build());

        helpDialog.setScene(helpScene);
        helpDialog.show();
    }

    /**
     * "Open File..." menu item set to open FileChooser window
     * @author Rudi 01.04.16
     * @param actionEvent
     */

    public void openFiles(ActionEvent actionEvent) {
        try {
            reader.chooseFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setStage(){

    }

    /**
     * "Close" menu item located in Menu to close whole window
     *
     * @author Ginelle 01.04.16
     * @param actionEvent
     */

    public void closeWindow (ActionEvent actionEvent){
        System.exit(0);
    }
}