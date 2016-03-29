package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Slider;
import javafx.util.Duration;
import javafx.fxml.FXML;

/**
 * Created by Ginelle on 3/9/2016.
 */

public class Speed {

    /*protected double FPS;
    protected Timeline timeline;
    protected GraphicsContext gc;
    protected Canvas canvas;
    @FXML protected Slider speedSlider;


    public Speed(GraphicsContext gc){
        this.gc = gc;
    }

    public void updateSpeed(){
        gc = canvas.getGraphicsContext2D();
        Board gameBoard = new Board(canvas.wid);
        Graphics graphics = new Graphics(gc);

        double FPS = speedSlider.getValue();

        Duration duration = Duration.millis(1000/FPS);
        KeyFrame keyframe = new KeyFrame(duration, (ActionEvent e) ->
        {
            graphics.draw(gameBoard.getGameBoard());
            gameBoard.nextGeneration();
        });
        timeline = new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.getKeyFrames().add(keyframe);

    }*/
}
