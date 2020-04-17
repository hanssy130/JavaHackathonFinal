package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class LineChartExamples {
    private LineChart <String, Number> output;


    private void insert(XYChart.Series<String, Number> series, String xAxis, int yAxis) {
        series.getData().add(new XYChart.Data<>(xAxis, yAxis));
    }
    public LineChart<String, Number> makeGraph(String xLabel, String yLabel,
                                               String name, String[] xData, int[] yData) {
        //defining the axes
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel(xLabel);
        yAxis.setLabel(yLabel);
        //creating the chart
        final LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);

        lineChart.setTitle(name);
        //defining a series
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("My portfolio");
        //populating the series with data
        int counter = 0;
        for (String data: xData) {
            insert(series, data, yData[counter]);
            counter++;
        }
        //this.scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);
        return lineChart;
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