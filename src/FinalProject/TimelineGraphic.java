package FinalProject;

import javafx.scene.Group;


public class TimelineGraphic {
    private Arrow arrow = new Arrow();
    private Group timeline;

    public TimelineGraphic(String[] dates, String[] descriptions) {
        Group display = new Group();
        final int dateLimit = 5;
        if (dates.length > dateLimit) {
            throw new IllegalArgumentException("Maximum dates per timeline!");
        }
        display.getChildren().add(arrow);
        int distance = 50;
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

    public Group getTimeline() {
        return timeline;
    }
}
