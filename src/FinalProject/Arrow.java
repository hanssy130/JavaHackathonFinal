package FinalProject;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

/**
 * A class to make an arrow shape for JavaFX.
 *
 * @author Justin Majam
 * @version 2020
 */
public class Arrow extends Group {
    /**
     * Constructor for the arrow Group.
     */
    public Arrow() {
        final int rectangleYTranslation = 250;
        final int rectangleWidth = 750;
        final int rectangleHeight = 55;
        final double triangleP1xCoordinate = 50.0;
        final double triangleP2xCoordinate = 50.0;
        final double triangleP3xCoordinate = 100.0;
        final double triangleP3yCoordinate = 50.0;
        final double triangleSetTranslateX = 720.0;
        final double triangleSetTranslateY = 254.0;
        final double triangleSetScaleY = 1.2;
        final double triangleSetRotate = 90.0;

        // the body of the arrow
        Rectangle arrowBody = new Rectangle(
                0, rectangleYTranslation, rectangleWidth, rectangleHeight);
        arrowBody.setFill(Color.web("#ff8080"));
        // the head of the arrow
        Polygon triangle = new Polygon();

        // get all the points of the polygon
        triangle.getPoints().addAll(triangleP1xCoordinate, 0.0, 0.0,
                triangleP2xCoordinate, triangleP3xCoordinate, triangleP3yCoordinate);
        triangle.setFill(Color.web("#ff8080"));

        // move the triangle to the front of the rectangle in the correct position
        triangle.setTranslateX(triangleSetTranslateX);
        triangle.setTranslateY(triangleSetTranslateY);
        triangle.setScaleY(triangleSetScaleY);
        triangle.setRotate(triangleSetRotate);
        // put the shapes into a group
        getChildren().addAll(arrowBody, triangle);

    }
}
