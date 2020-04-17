package test;

import FinalProject.LineGraph;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.stage.Stage;

/**
 * An example on how to use the LineGraph Class.
 * @author Justin Majam
 * @version 2020.
 */
public class LineGraphTest extends Application {
    private LineGraph test = new LineGraph();
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Line Chart Sample");
        String[] months = {"Jan", "Feb", "March"};
        int[] numbers = {100,14,50};
        LineChart<String, Number> tester = test.makeGraph("x", "y",
                "test", "infected", months, numbers);
        Scene scene  = new Scene(tester,800,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
