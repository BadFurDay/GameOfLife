package sample;

import javafx.animation.Animation;
import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
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
    @FXML private Slider zoomSlider;
    @FXML private Slider speedSlider;
    @FXML private Button playPause;
    @FXML private Toggle gridToggle;
    @FXML private Label genCounter;
    @FXML private Button clearButton;
    private GraphicsContext gc;
    private Timeline timeline;
    private double FPS;
    private boolean running = false;
    private List<Cell> cellList;
    private boolean showGrid = false;

    //Constructor


    //Objects
    Grid grid;
    Board gameBoard;
    Graphics graphics;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Objects
        gc = canvas.getGraphicsContext2D();

        gameBoard = new Board();
        graphics = new Graphics(gc);
        grid = new Grid(gc);
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
        cellList = new ArrayList<Cell>();
        zoomSlider.setValue(5.0);
        FPS = 1;
        draw();

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
     *
     */
    public void draw(){
        gc.clearRect(0, 0, canvas.widthProperty().doubleValue(), canvas.heightProperty().doubleValue());
        for ( Cell c : cellList ) {
            c.draw(gc, colorPicker.getValue(), zoomSlider.getValue());
        }
    }

    /**
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
     *
     */
    public void playPauseEvent(){
        if(running){
            playPause.setText("Pause");
        } else {
            playPause.setText("Play");
        }
    }

    /**
     *
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
     *
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
            } else {
                timeline.pause();
            }
        }
    }

    /**
     *
     * @param event
     */
    public void zoomChanged(MouseEvent event) {
        zoomSlider.getValue();
        draw();
    }

    /**
     *
     * @param actionEvent
     */
    public void colorChanged(ActionEvent actionEvent){
        graphics.gc.setFill(colorPicker.getValue());
    }

    /**
     *
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

}
