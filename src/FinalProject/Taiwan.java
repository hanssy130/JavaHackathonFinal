package FinalProject;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Line;
import javafx.stage.Modality;

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

        BorderPane canvas = new BorderPane();
        canvas.setPadding(new Insets(10));

        Line border = new Line(0, 600, 600, 600);
        border.setStrokeWidth(3);

        Button buttonExit = new Button();
        buttonExit.setText("Exit");
        buttonExit.setOnAction(actionEvent -> {
            this.close();
        });

        buttonExit.setLayoutX(200);
        buttonExit.setLayoutY(200);


        Button buttonNextSimulation = new Button();
        buttonNextSimulation.setText("Next Simulation");
        buttonNextSimulation.setOnAction(actionEvent -> {
            new USA().start();
            this.close();
        });


        canvas.getChildren().addAll(buttonNextSimulation, border, buttonExit);


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
