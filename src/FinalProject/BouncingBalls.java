package FinalProject;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * BouncingBalls, an introduction to threading and JavaFX.
 *
 * @author BCIT
 * @author Jason Lui (A00930386)
 * @version 2020
 */
public class BouncingBalls extends Application {

    private static final int MAX_X = 500; // horizontal edge of enclosing Panel
    private static final int MAX_Y = 500; // vertical edge of enclosing Panel
    private static final List<Ball> BALLS = new ArrayList<>();
    private static final Random GENERATOR = new Random();

    /**
     * Returns the list of balls.
     *
     * @return the list of balls
     */
    public static List<Ball> getBalls() {
        return BALLS;
    }

    /**
     * Generate the number of balls and add them to BALLS and the canvas.
     *
     * @param canvas        Pane
     * @param numberOfBalls int
     */
    private void generateBalls(Pane canvas, int numberOfBalls) {
        for (int i = 0; i < numberOfBalls; i++) {
            Ball ball = new Ball(GENERATOR.nextInt(MAX_X), GENERATOR.nextInt(MAX_Y));
            canvas.getChildren().add(ball);
            BALLS.add(ball);
        }
    }

    /**
     * Starts the threads for the balls
     */
    private void threadBalls() {
        for (Ball ball: BALLS) {
            Thread bouncer = new Thread(ball);
            bouncer.setDaemon(true);
            bouncer.start();
        }
    }

    /**
     * Demonstrates threading in JavaFX.
     *
     * @param primaryStage contains the Scene
     */
    public void start(Stage primaryStage) {
        Pane canvas = new Pane();
        Scene scene = new Scene(canvas, 500, 500);
        System.out.println("Enter the number of balls: ");
        Scanner scanner = new Scanner(System.in);

        int numberOfBalls = scanner.nextInt();
        generateBalls(canvas, numberOfBalls);

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
