package FinalProject;

import javafx.scene.Group;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Event extends Group {

    private String date;
    private String description;

    public Event(String date, String description) {
        this.date = date;
        this.description = description;

        Text something = new Text(description);
        Text somethingelse = new Text(date);
        VBox stackPane = new VBox(somethingelse, something);

        getChildren().addAll(stackPane);
    }
}
