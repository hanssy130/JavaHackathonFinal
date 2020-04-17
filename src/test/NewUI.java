package test;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class NewUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Rectangle arrowBody = new Rectangle(0, 155,550,55);
        arrowBody.setFill(Color.web("#ff8080"));
        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(50.0, 0.0,  0.0, 50.0,100.0, 50.0);
        triangle.setFill(Color.web("#ff8080"));
        triangle.setTranslateX(520.0);
        triangle.setTranslateY(160.0);
        triangle.setScaleY(1.2);
        triangle.setRotate(90.0);
        Group timeline = new Group(arrowBody, triangle);
        Scene display = new Scene(timeline,600, 400);
        primaryStage.setScene(display);
        primaryStage.show();
    }
}
