package test;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

/**
 * A class to make an arrow shape for JavaFX.
 * @author Justin Majam
 * @version 2020
 */
public class Arrow extends Group {
    public Arrow() {
        final int rectangleYTranslation = 155;
        final int rectangleWidth = 550;
        final int rectangleHeight = 55;
        // the body of the arrow
        Rectangle arrowBody = new Rectangle(0, rectangleYTranslation, rectangleWidth, rectangleHeight);
        arrowBody.setFill(Color.web("#ff8080"));
        // the head of the arrow
        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(50.0, 0.0,  0.0, 50.0,100.0, 50.0);
        triangle.setFill(Color.web("#ff8080"));
        triangle.setTranslateX(520.0);
        triangle.setTranslateY(160.0);
        triangle.setScaleY(1.2);
        triangle.setRotate(90.0);
        getChildren().addAll(arrowBody, triangle);

    }
}
