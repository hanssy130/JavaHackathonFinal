package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class LineChartExamples {
    private Scene scene;

    LineChartExamples() {

    }

    public void makeGraph() {
        //defining the axes
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");
        //creating the chart
        final LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);

        lineChart.setTitle("KILL ME");
        //defining a series
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("My portfolio");
        //populating the series with data
        series.getData().add(new XYChart.Data<>("January", 23));
        series.getData().add(new XYChart.Data<>("February", 14));
        series.getData().add(new XYChart.Data<>("March", 15));
        series.getData().add(new XYChart.Data<>("April", 24));
        series.getData().add(new XYChart.Data<>("May", 34));
        series.getData().add(new XYChart.Data<>("June", 36));
        series.getData().add(new XYChart.Data<>("July", 22));
        series.getData().add(new XYChart.Data<>("August", 45));
        series.getData().add(new XYChart.Data<>("September", 43));
        series.getData().add(new XYChart.Data<>("October", 17));
        series.getData().add(new XYChart.Data<>("November", 29));
        series.getData().add(new XYChart.Data<>("December", 25));

        this.scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);
    }

    public Scene getScene() {
        return scene;
    }

    //    @Override public void start(Scene scene) {
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
}