package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DisplayGraphTest extends Application {
    LineChartExamples test = new LineChartExamples();
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Line Chart Sample");
        Scene graph = test.getScene();
        primaryStage.setScene(graph);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
