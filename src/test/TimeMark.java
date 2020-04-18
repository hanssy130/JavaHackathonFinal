package test;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class TimeMark extends Group {
    public TimeMark(String markName, int howFarDownCircle) {
        final int textYTranslation = 320;
        final int circleYTranslation = 278;
        final int textOffset = 16;
        final int radius = 20;
        Circle timelineMark = new Circle(howFarDownCircle, circleYTranslation, radius);
        timelineMark.setFill(Color.web("#1a1aff"));
        Text text = new Text(markName);
        text.setY(textYTranslation);
        text.setX(howFarDownCircle - textOffset);
        getChildren().addAll(text, timelineMark);
    }
}
