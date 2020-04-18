package FinalProject;

import javafx.scene.Group;


public class Timeline {
    private Arrow arrow = new Arrow();
    private String[] dates;
    private Group timeline;

    public Timeline(String[] dates) {
        Group display = new Group();
        final int dateLimit = 5;
        if (dates.length > dateLimit) {
            throw new IllegalArgumentException("Maximum dates per timeline!");
        }
        this.dates = dates;
        display.getChildren().add(arrow);
        int distance = 50;
        final int distanceBetweenBalls = 150;
        for (String date : dates) {
            TimeMark testMark = new TimeMark(date, distance);
            display.getChildren().add(testMark);
            distance += distanceBetweenBalls;
        }
        timeline = display;
    }

    public Group getTimeline() {
        return timeline;
    }

    public static void main(String[] args) {
        String[] stuff = {"yes", "fam"};
        Timeline test = new Timeline(stuff);
    }
}
