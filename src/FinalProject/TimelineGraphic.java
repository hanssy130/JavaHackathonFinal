package FinalProject;

import javafx.scene.Group;

/**
 * Makes a timeline with upto 5 items.
 *
 * @author Brian Duong
 * @author Hans Sy
 * @author Justin Majam
 * @author Jason Lui
 * @version 2020
 */
public class TimelineGraphic {
    private Group timeline;

    /**
     * The constructor.
     *
     * @param dates        A string array for dates.
     * @param descriptions A string array for descriptions
     * @pre params must be arrays of equal length.
     * @pre both arrays must be <=5.
     * @post a completed timeline.
     */
    public TimelineGraphic(String[] dates, String[] descriptions) {
        Group display = new Group();
        final int dateLimit = 5;
        final int distanceDefault = 50;
        if (dates.length > dateLimit) {
            throw new IllegalArgumentException("Maximum dates per timeline!");
        }
        Arrow arrow = new Arrow();
        display.getChildren().add(arrow);
        int distance = distanceDefault;
        int counter = 0;
        final int distanceBetweenBalls = 150;
        for (String date : dates) {
            TimeMark testMark = new TimeMark(date, distance, descriptions[counter]);
            display.getChildren().add(testMark);
            distance += distanceBetweenBalls;
            counter++;
        }
        timeline = display;
    }

    /**
     * Gets the timeline.
     *
     * @return A group for the timeline.
     */
    public Group getTimeline() {
        return timeline;
    }
}
