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
     *
     * @param primaryStage contains the Scene
     */
    public void start(Stage primaryStage) {
        Pane canvas = new Pane();
        Scene scene = new Scene(canvas, MAX_X, MAX_Y);
        System.out.println("Enter the number of balls: ");
        Scanner scanner = new Scanner(System.in);

        int numberOfBalls = scanner.nextInt();
        generateUninfectedBalls(canvas, numberOfBalls, TAIWAN_MOVE_SPEED, TAIWAN_MOVE_SPEED, TAIWAN_INFECTION_DISTANCE);
        generateInfectedBall(canvas, TAIWAN_MOVE_SPEED, TAIWAN_MOVE_SPEED, TAIWAN_INFECTION_DISTANCE);

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
