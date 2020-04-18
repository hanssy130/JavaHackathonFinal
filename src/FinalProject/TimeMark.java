package FinalProject;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TimeMark extends Group {
    private final String buttonSpecs = "-fx-background-radius: 20px;"
            + "-fx-min-width: 42px; "
            + "-fx-min-height: 42px; "
            + "-fx-max-width: 42px; "
            + "-fx-max-height: 42px;"
            + "-fx-background-color:#1a1aff ;";

    public TimeMark(String markName, int howFarDownCircle, String description) {
        final int circleYTranslation = 278;
        final int radius = 20;
        Circle timelineMark = new Circle(howFarDownCircle, circleYTranslation, radius);
        timelineMark.setFill(Color.web("#1a1aff"));
        Text text = new Text(markName);
        moveText(text, howFarDownCircle);
        Button clicker = new Button();
        buttonStyler(clicker, howFarDownCircle);
        clicker.setOnAction(actionEvent -> {
            Stage newWindow = makePopUp(markName, description);
            newWindow.show();
        });
        getChildren().addAll(text, timelineMark, clicker);
    }

    private void moveText(Text text, int howFarDownCircle) {
        final int textYTranslation = 320;
        final int textOffset = 30;
        text.setY(textYTranslation);
        text.setX(howFarDownCircle - textOffset);
    }

    private void buttonStyler(Button clicker, int howFarDownCircle) {
        final int textYTranslation = 320;
        final int buttonOffsetY = 63;
        final int buttonOffSetX = 20;
        clicker.setStyle(buttonSpecs);
        clicker.setTranslateY(textYTranslation - buttonOffsetY);
        clicker.setTranslateX(howFarDownCircle - buttonOffSetX);
    }

    private Stage makePopUp(String markName, String description) {
        final int popUpWidth = 600;
        final int popUpHeight = 480;
        final int popUpX = 200;
        final int popUpY = 100;
        TaiwanEvent hey = new TaiwanEvent(markName, description);
        StackPane secondaryLayout = new StackPane(hey);
        Scene secondScene = new Scene(secondaryLayout, popUpWidth, popUpHeight);
        secondScene.setFill(Color.rgb(173, 216, 230));
        Stage newWindow = new Stage();
        newWindow.setTitle("Event");
        newWindow.setScene(secondScene);
        newWindow.setX(popUpX);
        newWindow.setY(popUpY);
        return newWindow;
    }
}
