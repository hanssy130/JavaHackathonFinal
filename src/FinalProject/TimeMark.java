package FinalProject;

import FinalProject.Timelines;
import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TimeMark extends Group {
    public TimeMark(String markName, int howFarDownCircle, String description) {
        final int textYTranslation = 320;
        final int circleYTranslation = 278;
        final int textOffset = 16;
        final int radius = 20;
        Circle timelineMark = new Circle(howFarDownCircle, circleYTranslation, radius);
        timelineMark.setFill(Color.web("#1a1aff"));
        Text text = new Text(markName);
        text.setY(textYTranslation);
        text.setX(howFarDownCircle - textOffset);
        Button clicker = new Button();
        clicker.setStyle("-fx-background-radius: 20px; " +
                "-fx-min-width: 42px; " +
                "-fx-min-height: 42px; " +
                "-fx-max-width: 42px; " +
                "-fx-max-height: 42px;" +
                "-fx-background-color:#1a1aff ;"
                //"-fx-border-width: 5px;"
        );
        clicker.setTranslateY(textYTranslation - 63);
        clicker.setTranslateX(howFarDownCircle - 20);
        clicker.setOnAction(actionEvent -> {
            TaiwanEvent hey = new TaiwanEvent(markName, description);
            StackPane secondaryLayout = new StackPane(hey);
            Scene secondScene = new Scene(secondaryLayout, 400, 300);
            // New window (Stage)
            Stage newWindow = new Stage();
            newWindow.setTitle("Example Event");
            newWindow.setScene(secondScene);

            // Set position of second window, related to primary window.
            newWindow.setX(200);
            newWindow.setY(100);

            newWindow.show();
        });
        getChildren().addAll(text, timelineMark, clicker);
    }
}
