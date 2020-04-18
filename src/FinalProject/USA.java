package FinalProject;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
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
     *
     * @param primaryStage contains the Scene
     */
    public void start(Stage primaryStage) {
        Pane canvas = new Pane();
        Scene scene = new Scene(canvas, MAX_X, MAX_Y);
        System.out.println("Enter the number of balls: ");
        Scanner scanner = new Scanner(System.in);

        int numberOfBalls = scanner.nextInt();
        generateUninfectedBalls(canvas, numberOfBalls, USA_MOVE_SPEED, USA_MOVE_SPEED, USA_INFECTION_DISTANCE);
        generateInfectedBall(canvas, USA_MOVE_SPEED, USA_MOVE_SPEED, USA_INFECTION_DISTANCE);

        primaryStage.setTitle("Threads and Balls");
        primaryStage.setScene(scene);
        primaryStage.show();

        threadBalls();
    }

    /**
     * Launches the JavaFX application.  We still need a main method in our
     * JavaFX applications.  The main method must do one thing.  Pass
     * the command line arguments (args) to the launch method inherited from
     * the Application class.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
