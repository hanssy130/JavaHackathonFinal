package FinalProject;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Scanner;

/**
 * @author Jason Lui (A00930386)
 * @version 2020
 */
public class Taiwan extends BouncingBalls {

    private static final int TAIWAN_MOVE_SPEED = 1;
    private static final int TAIWAN_INFECTION_DISTANCE = 1;

    /**
     * Demonstrates threading in JavaFX.
     */
    public void start() {
        final int yOffset = 100;
        Pane canvas = new Pane();
        Scene scene = new Scene(canvas, MAX_X, MAX_Y + yOffset);
        System.out.println("Enter the number of balls: ");

        final int numberOfBalls = 20;
        generateUninfectedBalls(canvas, numberOfBalls, TAIWAN_MOVE_SPEED, TAIWAN_MOVE_SPEED, TAIWAN_INFECTION_DISTANCE);
        generateInfectedBall(canvas, TAIWAN_MOVE_SPEED, TAIWAN_MOVE_SPEED, TAIWAN_INFECTION_DISTANCE);

        this.setTitle("Threads and Balls");
        this.setScene(scene);
        this.show();

        threadBalls();
    }

}
