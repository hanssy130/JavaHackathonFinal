package FinalProject;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Line;

/**
 * USA.
 *
 * @author Brian Duong
 * @author Hans Sy
 * @author Justin Majam
 * @author Jason Lui
 * @version 2020
 */
public class USA extends BouncingBalls {

    private static final int USA_MOVE_SPEED = 3;
    private static final int USA_INFECTION_DISTANCE = 15;

    /**
     * Demonstrates threading in JavaFX.
     */
    public void start() {

        Line border = new Line(0, 600, 600, 600);
        border.setStrokeWidth(3);

        Button buttonExit = new Button();
        buttonExit.setText("Return");
        buttonExit.setOnAction(actionEvent -> {
            this.close();
        });

        Button buttonNextSimulation = new Button();
        buttonNextSimulation.setText("Next Simulation");
        buttonNextSimulation.setOnAction(actionEvent -> {
            new Taiwan().start();
            this.close();
        });

        BorderPane canvas = new BorderPane();
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
