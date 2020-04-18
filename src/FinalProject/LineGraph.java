package FinalProject;

import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * A class to make lineGraphs.
 *
 * @author Brian Duong
 * @author Hans Sy
 * @author Justin Majam
 * @author Jason Lui
 * @version 2020.
 */
public class LineGraph {
    /**
     * Inserts data into a graph's series.
     *
     * @param series A series for an XYChart.
     * @param xAxis  A string for the X axis.
     * @param yAxis  An int for the Y axis.
     */
    private void insert(XYChart.Series<String, Number> series, String xAxis, int yAxis) {
        series.getData().add(new XYChart.Data<>(xAxis, yAxis));
    }

    /**
     * Makes a LineGraph with inputted data.
     *
     * @param xLabel    A string for the x Axis Label.
     * @param yLabel    A string for the y Axis Label.
     * @param name      A string for the graph name.
     * @param lineLabel A label for the line.
     * @param xData     An array of Strings for the X axis.
     * @param yData     An array of ints for the Y axis.
     * @return A completed line graph.
     * @pre both arrays must be the same length.
     * @post A completed line graph.
     */
    public LineChart<String, Number> makeGraph(
            String xLabel, String yLabel, String name,
            String lineLabel, String[] xData, int[] yData) {
        //making the axes
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel(xLabel);
        yAxis.setLabel(yLabel);
        //creating the graph
        final LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle(name);
        //defining a series
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName(lineLabel);
        //populating the series with data
        int counter = 0;
        for (String data : xData) {
            insert(series, data, yData[counter]);
            counter++;
        }
        lineChart.getData().add(series);
        return lineChart;
    }

}
