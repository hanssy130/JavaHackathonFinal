package FinalProject;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Modality;
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

        Pane canvas = new Pane();
        Line border = new Line(0, 600, 600, 600);
        border.setStrokeWidth(3);
        canvas.getChildren().addAll(border);
        Scene scene = new Scene(canvas, MAX_X, MAX_Y + Y_OFFSET);

        final int numberOfBalls = 20;
        generateUninfectedBalls(canvas, numberOfBalls, TAIWAN_MOVE_SPEED, TAIWAN_MOVE_SPEED, TAIWAN_INFECTION_DISTANCE);
        generateInfectedBall(canvas, TAIWAN_MOVE_SPEED, TAIWAN_MOVE_SPEED, TAIWAN_INFECTION_DISTANCE);

        this.initModality(Modality.APPLICATION_MODAL);
        this.setTitle("Taiwan Covid-19 Infection Simulation");
        this.setScene(scene);
        this.show();

        threadBalls();
    }

}
