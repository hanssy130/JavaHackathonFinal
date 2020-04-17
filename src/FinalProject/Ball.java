package FinalProject;

import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
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

    private static final int BALL_SIZE = 10; // size of a ball
    private static final int MAX_HORIZONTAL_SPEED = 2; // max horizontal speed
    private static final int MAX_VERTICAL_SPEED = 2; // max vertical speed
    private static final int LOOP_SLEEP_DURATION = 10; // sleep time for the while run loop
    private static final int MINIMUM_TIME_TO_START_DYING = 7000; // time until a ball can die
    private static final int RECOVERY_TIME = 28000; // time until a ball is recovered
    private static final int MILLISECONDS_PER_DAY = 1000; // number of milliseconds to represent a day
    private static final double COVID_DEATH_RATE = 0.052; // death chance of COVID-19 per day


    private static final Paint INFECTED_COLOR = Color.rgb(150, 20, 20);
    private static final Paint RECOVERED_COLOR = Color.rgb(92, 210, 203);
    private static final Paint UNINFECTED_COLOR = Color.rgb(0, 255, 111);
    private static final Paint DEAD_COLOR = Color.BLACK;

    private static final Random GENERATOR = new Random();
    private double dx; // change in horizontal position of ball
    private double dy; // change in vertical position of ball
    private boolean immune;
    private boolean infected;
    private boolean alive;
    private int timeInfectedMilliseconds;

    /**
     * Constructs an object of type Ball.
     *
     * @param xPosition double
     * @param yPosition double
     */
    public Ball(int xPosition, int yPosition, boolean infected) {
        super(BALL_SIZE);
        this.setCenterX(xPosition);
        this.setCenterY(yPosition);
        this.dx = MAX_HORIZONTAL_SPEED * GENERATOR.nextDouble(); // change in x
        this.dy = MAX_VERTICAL_SPEED * GENERATOR.nextDouble(); // change in y
        this.immune = false;
        this.infected = infected;
        this.alive = true;
        this.timeInfectedMilliseconds = 0;
        this.setFill(infected ? INFECTED_COLOR : UNINFECTED_COLOR);
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

    /**
     * Attempts to infect another ball
     */
    private void infect(Ball contactedBall) {
        if (!contactedBall.immune && contactedBall.alive) {
            contactedBall.immune = true;
            contactedBall.infected = true;
            contactedBall.setFill(INFECTED_COLOR);
        }
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
                if (this.infected) {
                    infect(ball);
                } else if (ball.infected) {
                    infect(this);
                }
            }
        }
    }

    /*
     * Increments the time alive for the balls
     */
    private void incrementDaysInfected() {
        List<Ball> balls = BouncingBalls.getBalls();
        for (Ball ball : balls) {
            if (ball.infected && ball.alive) {
                ball.timeInfectedMilliseconds += 1;
            }
        }
    }

    /*
     * Rolls for a chance to kill balls that have been infected for 7 seconds or longer.
     */
    private void killBalls() {
        List<Ball> balls = BouncingBalls.getBalls();
        for (Ball ball : balls) {
            if (ball.infected
                    && ball.alive
                    && ball.timeInfectedMilliseconds % MILLISECONDS_PER_DAY == 0
                    && ball.timeInfectedMilliseconds >= MINIMUM_TIME_TO_START_DYING) {
                if (GENERATOR.nextDouble() <= COVID_DEATH_RATE) {
                    kill(ball);
                }
            }
        }
    }

    /*
     * Recovers balls that have been infected for 14 seconds or longer.
     */
    private void recoverBalls() {
        List<Ball> balls = BouncingBalls.getBalls();
        for (Ball ball : balls) {
            if (ball.infected
                    && ball.alive
                    && ball.timeInfectedMilliseconds >= RECOVERY_TIME) {
                recover(ball);
            }
        }
    }

    /**
     * Kills a ball
     */
    private void kill(Ball ball) {
        ball.alive = false;
        ball.infected = false;
        ball.immune = true;
        ball.dx = 0;
        ball.dy = 0;
        ball.setFill(DEAD_COLOR);
    }

    /**
     * Recovers a ball
     */
    private void recover(Ball ball) {
        ball.infected = false;
        ball.immune = true;
        ball.setFill(RECOVERED_COLOR);
    }

    /**
     * Bounces the Ball perpetually.
     */
    public void run() {
        while (true) {
            try {
                Thread.sleep(LOOP_SLEEP_DURATION);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }

            collision();
            incrementDaysInfected();
            killBalls();
            recoverBalls();

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

                if (this.getCenterY() >= BouncingBalls.MAX_Y - BALL_SIZE) {
                    dy = (dy > 0) ? dy * -1 : dy;
                }

                if (this.getCenterX() <= BALL_SIZE) {
                    dx = (dx < 0) ? dx * -1 : dx;
                }

                if (this.getCenterX() >= BouncingBalls.MAX_X - BALL_SIZE) {
                    dx = (dx > 0) ? dx * -1 : dx;
                }

                this.setCenterX(this.getCenterX() + dx); // determines new x-position
                this.setCenterY(this.getCenterY() + dy); // determines new y-position
            });
        }
    }
}
