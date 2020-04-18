package FinalProject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TimelineTester extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        String[] stuff = {"yes", "family"};
        String[] describe = {"stuff happened", "stuff happened again"};
        TimelineGraphic test = new TimelineGraphic(stuff, describe);
        Scene scene = new Scene(test.getTimeline(), 800,  600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}