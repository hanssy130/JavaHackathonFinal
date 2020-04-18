package FinalProject;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.Scanner;

/**
 * @author Jason Lui (A00930386)
 * @version 2020
 */
public class USA extends BouncingBalls {

    private static final int USA_MOVE_SPEED = 3;
    private static final int USA_INFECTION_DISTANCE = 15;

    /**
     * Demonstrates threading in JavaFX.
     */
    public void start() {
        Pane canvas = new Pane();
        Line border = new Line(0, 600, 600, 600);
        border.setStrokeWidth(3);
        canvas.getChildren().addAll(border);
        Scene scene = new Scene(canvas, MAX_X, MAX_Y + Y_OFFSET);

        final int numberOfBalls = 20;
        generateUninfectedBalls(canvas, numberOfBalls, USA_MOVE_SPEED, USA_MOVE_SPEED, USA_INFECTION_DISTANCE);
        generateInfectedBall(canvas, USA_MOVE_SPEED, USA_MOVE_SPEED, USA_INFECTION_DISTANCE);

        this.setTitle("Threads and Balls");
        this.setScene(scene);
        this.show();

        threadBalls();
    }


}
