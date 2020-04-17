package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.stage.Stage;

public class DisplayGraphTest extends Application {
    private LineChartExamples test = new LineChartExamples();
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Line Chart Sample");
        String[] months = {"Jan", "Feb", "March"};
        int[] numbers = {1,2,3};
        LineChart<String, Number> tester = test.makeGraph("x", "y", "test", months, numbers);
        Scene scene  = new Scene(tester,800,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
