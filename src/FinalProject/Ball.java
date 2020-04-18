package FinalProject;

import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;

/**
 * COVIDBall is a Runnable.  A COVIDBall bounces.
 *
 * @author BCIT
 * @author Brian Duong
 * @author Hans Sy
 * @author Justin Majam
 * @author Jason Lui
 * @version 2020
 */
public class Ball extends Circle implements Runnable {

    private static final int BALL_SIZE = 10; // size of a ball
    private static final int MAX_HORIZONTAL_SPEED = 5; // max horizontal speed
    private static final int MAX_VERTICAL_SPEED = 5; // max vertical speed
    private static final int SLEEP_DURATION = 20; // max vertical speed

    private static final Random GENERATOR = new Random();
    private int dx; // change in horizontal position of ball
    private int dy; // change in vertical position of ball

    /**
     * Constructs an object of type COVIDBall.
     *
     * @param xPosition an int
     * @param yPosition an int
     */
    public Ball(int xPosition, int yPosition) {
        super(BALL_SIZE, Color.RED);
        this.setCenterX(xPosition);
        this.setCenterY(yPosition);
        dx = GENERATOR.nextInt(MAX_HORIZONTAL_SPEED + 1); // change in x (0 - 5 pixels)
        dy = GENERATOR.nextInt(MAX_VERTICAL_SPEED + 1); // change in y (0 - 5 pixels)
    }

    public Ball() {
    }

    /**
     * Bounces the COVIDBall perpetually.
     */
    public void run() {
        while (true) {
            try {
                Thread.sleep(SLEEP_DURATION); // sleep for 20 milliseconds
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }

            /* Long-running operations must not be run on the JavaFX application
               thread, since this prevents JavaFX from updating the UI, resulting
               in a frozen UI.

               Furthermore any change to a Node that is part of a "live" scene
               graph must happen on the JavaFX application thread.

               Platform.runLater can be used to execute those updates on the
               JavaFX application thread.
             */
            Platform.runLater(() -> {
                // if bounce off top or bottom of Panel
                if (this.getCenterY() <= 0 || this.getCenterY() >= BouncingBalls.MAX_Y) {
                    dy *= -1; // reverses velocity in y direction
                }

                // if bounce off left or right of Panel
                if (this.getCenterX() <= 0 || this.getCenterX() >= BouncingBalls.MAX_X) {
                    dx *= -1; // reverses velocity in x direction
                }

                this.setCenterX(this.getCenterX() + dx); // determines new x-position
                this.setCenterY(this.getCenterY() + dy); // determines new y-position
            });
        }
    }
}
