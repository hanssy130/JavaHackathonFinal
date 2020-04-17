package FinalProject;

import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.List;
import java.util.Random;

/**
 * Ball is a Runnable.  A Ball bounces.
 *
 * @author BCIT
 * @author Jason Lui (A00930386)
 * @version 2020
 */
public class Ball extends Circle implements Runnable {

    private static final int MAX_X = 500; // horizontal edge of enclosing Panel
    private static final int MAX_Y = 500; // vertical edge of enclosing Panel
    private static final int BALL_SIZE = 10; // size of a ball
    private static final int MAX_HORIZONTAL_SPEED = 5; // max horizontal speed
    private static final int MAX_VERTICAL_SPEED = 5; // max vertical speed
    private static final int SLEEP_DURATION = 20; // sleep time

    private static final Random GENERATOR = new Random();
    private double dx; // change in horizontal position of ball
    private double dy; // change in vertical position of ball
    private boolean immune;
    private boolean infected;


    /**
     * Constructs an object of type Ball.
     *
     * @param xPosition double
     * @param yPosition double
     */
    public Ball(int xPosition, int yPosition) {
        super(BALL_SIZE, Color.RED);
        this.setCenterX(xPosition);
        this.setCenterY(yPosition);
        dx = (MAX_HORIZONTAL_SPEED - 1) * GENERATOR.nextDouble() + 1; // change in x
        dy = (MAX_VERTICAL_SPEED - 1) * GENERATOR.nextDouble() + 1; // change in y
    }

    /*
     * Ball collision
     */
    private void ballCollision(Ball b1, Ball b2) {
        b1.dx *= -1;
        b1.dy *= -1;
        b2.dx *= -1;
        b2.dy *= -1;
    }

    /*
     * Checks for collision for each ball
     */
    private void collision() {
        List<Ball> balls = BouncingBalls.getBalls();
        for (Ball ball : balls) {
            double xDiff = this.getCenterX() - ball.getCenterX();
            double yDiff = this.getCenterY() - ball.getCenterY();
            double sumRadii = this.getRadius() + ball.getRadius();

            if (xDiff * xDiff + yDiff * yDiff <= sumRadii * sumRadii
                    && xDiff * (this.dx - ball.dx) + yDiff * (this.dy - ball.dy) < 0) {
                ballCollision(this, ball);
            }
        }
    }

    /**
     * Bounces the Ball perpetually.
     */
    public void run() {
        while (true) {
            try {
                Thread.sleep(SLEEP_DURATION); // sleep for 20 milliseconds
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }

            collision();

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
                if (this.getCenterY() <= BALL_SIZE) {
                    dy = (dy < 0) ? dy * -1 : dy;
                }

                if (this.getCenterY() >= MAX_Y - BALL_SIZE) {
                    dy = (dy > 0) ? dy * -1 : dy;
                }

                if (this.getCenterX() <= BALL_SIZE) {
                    dx = (dx < 0) ? dx * -1 : dx;
                }

                if (this.getCenterX() >= MAX_X - BALL_SIZE) {
                    dx = (dx > 0) ? dx * -1 : dx;
                }

                this.setCenterX(this.getCenterX() + dx); // determines new x-position
                this.setCenterY(this.getCenterY() + dy); // determines new y-position
            });
        }
    }
}
