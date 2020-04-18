package test;

import FinalProject.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ArrowDriver extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        Arrow tester = new Arrow();
//        TimeMark testMark = new TimeMark("Dec 31",50);
//        TimeMark testMark2 = new TimeMark("Jan 20",200);
//        TimeMark testMark3 = new TimeMark("Jan 25",350);
//        TimeMark testMark4 = new TimeMark("Jan 29",500);
//        TimeMark testMark5 = new TimeMark("Feb 7",650);
//        Group display = new Group(tester, testMark, testMark2, testMark3, testMark4, testMark5);
        String[] stuff = {"yes", "fam"};
        Timeline test = new Timeline(stuff);
        Scene scene = new Scene(test.getTimeline(), 800,  600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
