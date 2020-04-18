package FinalProject;

import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.List;
import java.util.Random;

/**
 * COVIDBall is a Runnable.  A COVIDBall bounces and infects.
 *
 * @author BCIT
 * @author Jason Lui (A00930386)
 * @version 2020
 */
public class COVIDBall extends Ball {

    private static final int LOOP_SLEEP_DURATION = 10; // sleep time for the while run loop
    private static final int MINIMUM_TIME_TO_START_DYING = 7000; // time until a ball can die
    private static final int RECOVERY_TIME = 25000; // time until a ball is recovered
    private static final int MILLISECONDS_PER_DAY = 1000; // number of milliseconds to represent a day
    private static final double COVID_DEATH_RATE = 0.03; // death chance of COVID-19 per day

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
    private int infectionDistance;

    /**
     * Constructs an object of type COVIDBall.
     *
     * @param xPosition double
     * @param yPosition double
     * @param xMaxSpeed int
     * @param yMaxSpeed int
     * @param infected boolean
     * @param infectionDistance int
     */
    public COVIDBall(int xPosition, int yPosition, int xMaxSpeed, int yMaxSpeed, boolean infected, int infectionDistance) {
        super(xPosition, yPosition);
        this.dx = xMaxSpeed * GENERATOR.nextDouble(); // change in x
        this.dy = yMaxSpeed * GENERATOR.nextDouble(); // change in y
        this.immune = false;
        this.infected = infected;
        this.alive = true;
        this.timeInfectedMilliseconds = 0;
        this.infectionDistance = infectionDistance;
        this.setFill(infected ? INFECTED_COLOR : UNINFECTED_COLOR);
    }

    /*
     * COVIDBall collision
     */
    private void ballCollision(COVIDBall b1, COVIDBall b2) {
        b1.dx *= -1;
        b1.dy *= -1;
        b2.dx *= -1;
        b2.dy *= -1;
    }

    /**
     * Attempts to infect another COVIDBall
     */
    private void infect(COVIDBall contactedCOVIDBall) {
        if (!contactedCOVIDBall.immune && contactedCOVIDBall.alive) {
            contactedCOVIDBall.immune = true;
            contactedCOVIDBall.infected = true;
            contactedCOVIDBall.setFill(INFECTED_COLOR);
        }
    }

    /*
     * Checks for infection around each COVIDBall
     */
    private void infection() {
        List<COVIDBall> COVIDBalls = BouncingBalls.getCovidBalls();
        for (COVIDBall COVIDBall : COVIDBalls) {
            double xDiff = this.getCenterX() - COVIDBall.getCenterX();
            double yDiff = this.getCenterY() - COVIDBall.getCenterY();
            double socialDistance = this.getRadius() + COVIDBall.getRadius() + this.infectionDistance;

            if (xDiff * xDiff + yDiff * yDiff <= socialDistance * socialDistance) {
                if (this.infected) {
                    infect(COVIDBall);
                } else if (COVIDBall.infected) {
                    infect(this);
                }
            }
        }
    }

    /*
     * Checks for collision for each COVIDBall
     */
    private void collision() {
        List<COVIDBall> COVIDBalls = BouncingBalls.getCovidBalls();
        for (COVIDBall COVIDBall : COVIDBalls) {
            double xDiff = this.getCenterX() - COVIDBall.getCenterX();
            double yDiff = this.getCenterY() - COVIDBall.getCenterY();
            double sumRadii = this.getRadius() + COVIDBall.getRadius();

            if (xDiff * xDiff + yDiff * yDiff <= sumRadii * sumRadii
                    && xDiff * (this.dx - COVIDBall.dx) + yDiff * (this.dy - COVIDBall.dy) < 0) {
                ballCollision(this, COVIDBall);
            }
        }
    }

    /*
     * Increments the time alive for the COVIDBalls
     */
    private void incrementDaysInfected() {
        List<COVIDBall> COVIDBalls = BouncingBalls.getCovidBalls();
        for (COVIDBall COVIDBall : COVIDBalls) {
            if (COVIDBall.infected && COVIDBall.alive) {
                COVIDBall.timeInfectedMilliseconds += 1;
            }
        }
    }

    /*
     * Rolls for a chance to kill balls that have been infected for longer than the threshold
     */
    private void killBalls() {
        List<COVIDBall> COVIDBalls = BouncingBalls.getCovidBalls();
        for (COVIDBall COVIDBall : COVIDBalls) {
            if (COVIDBall.infected
                    && COVIDBall.alive
                    && COVIDBall.timeInfectedMilliseconds % MILLISECONDS_PER_DAY == 0
                    && COVIDBall.timeInfectedMilliseconds >= MINIMUM_TIME_TO_START_DYING) {
                if (GENERATOR.nextDouble() <= COVID_DEATH_RATE) {
                    kill(COVIDBall);
                }
            }
        }
    }

    /*
     * Recovers balls that have been infected for longer than the recovery time
     */
    private void recoverBalls() {
        List<COVIDBall> COVIDBalls = BouncingBalls.getCovidBalls();
        for (COVIDBall COVIDBall : COVIDBalls) {
            if (COVIDBall.infected
                    && COVIDBall.alive
                    && COVIDBall.timeInfectedMilliseconds >= RECOVERY_TIME) {
                recover(COVIDBall);
            }
        }
    }

    /**
     * Kills a COVIDBall
     */
    private void kill(COVIDBall COVIDBall) {
        COVIDBall.alive = false;
        COVIDBall.infected = false;
        COVIDBall.immune = true;
        COVIDBall.dx = 0;
        COVIDBall.dy = 0;
        COVIDBall.setFill(DEAD_COLOR);
    }

    /**
     * Recovers a COVIDBall
     */
    private void recover(COVIDBall COVIDBall) {
        COVIDBall.infected = false;
        COVIDBall.immune = true;
        COVIDBall.setFill(RECOVERED_COLOR);
    }

    /**
     * Bounces the COVIDBall perpetually.
     */
    public void run() {
        while (true) {
            try {
                Thread.sleep(LOOP_SLEEP_DURATION);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }

            collision();
            infection();
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
                if (this.getCenterY() <= this.getRadius()) {
                    dy = (dy < 0) ? dy * -1 : dy;
                }

                if (this.getCenterY() >= BouncingBalls.MAX_Y - this.getRadius()) {
                    dy = (dy > 0) ? dy * -1 : dy;
                }

                if (this.getCenterX() <= this.getRadius()) {
                    dx = (dx < 0) ? dx * -1 : dx;
                }

                if (this.getCenterX() >= BouncingBalls.MAX_X - this.getRadius()) {
                    dx = (dx > 0) ? dx * -1 : dx;
                }

                this.setCenterX(this.getCenterX() + dx); // determines new x-position
                this.setCenterY(this.getCenterY() + dy); // determines new y-position
            });
        }
    }
}
