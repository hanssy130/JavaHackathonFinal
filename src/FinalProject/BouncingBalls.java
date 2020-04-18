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
public class BouncingBalls extends Stage {

    public static final int MAX_X = 600; // horizontal edge of enclosing Panel
    public static final int MAX_Y = 600; // vertical edge of enclosing Panel
    private static final List<COVIDBall> COVID_BALLS = new ArrayList<>();
    private static final Random GENERATOR = new Random();

    /**
     * Returns the list of balls.
     *
     * @return the list of balls
     */
    public static List<COVIDBall> getCovidBalls() {
        return COVID_BALLS;
    }

    /**
     * Generate the uninfected population of balls and add them to COVID_BALLS and the canvas.
     *
     * @param canvas        Pane
     * @param numberOfBalls int
     */
    protected void generateUninfectedBalls(Pane canvas, int numberOfBalls,
                                           int xMaxSpeed, int yMaxSpeed, int infectionDistance) {
        for (int i = 0; i < numberOfBalls; i++) {
            COVIDBall COVIDBall = new COVIDBall(GENERATOR.nextInt(MAX_X),
                    GENERATOR.nextInt(MAX_Y), xMaxSpeed, yMaxSpeed, false, infectionDistance);
            canvas.getChildren().add(COVIDBall);
            COVID_BALLS.add(COVIDBall);
        }
    }

    /**
     * Generate the infected ball and add it to COVID_BALLS and the canvas.
     *
     * @param canvas Pane
     */
    protected void generateInfectedBall(Pane canvas, int xMaxSpeed, int yMaxSpeed, int infectionDistance) {
        COVIDBall COVIDBall = new COVIDBall(GENERATOR.nextInt(MAX_X),
                GENERATOR.nextInt(MAX_Y), xMaxSpeed, yMaxSpeed, true, infectionDistance);
        canvas.getChildren().add(COVIDBall);
        COVID_BALLS.add(COVIDBall);
    }

    /**
     * Starts the threads for the balls
     */
    protected void threadBalls() {
        for (COVIDBall COVIDBall : COVID_BALLS) {
            Thread bouncer = new Thread(COVIDBall);
            bouncer.setDaemon(true);
            bouncer.start();
        }
    }

    /**
     * Demonstrates threading in JavaFX.
     */
    public void start() {
        Pane canvas = new Pane();
        Scene scene = new Scene(canvas, MAX_X, MAX_Y);
        System.out.println("Enter the number of balls: ");
        Scanner scanner = new Scanner(System.in);
        final int numberOfBalls = 20;

        for (int i = 0; i < numberOfBalls; i++) {
            Ball ball = new Ball(GENERATOR.nextInt(MAX_X), GENERATOR.nextInt(MAX_Y));
            canvas.getChildren().add(ball);
            Thread bouncer = new Thread(ball);
            bouncer.setDaemon(true);
            bouncer.start();
        }

        this.setTitle("Threads and Balls");
        this.setScene(scene);
        this.show();
    }


}