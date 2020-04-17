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

        Text eventDate = new Text(date);
        Text eventDescription = new Text(description);
        VBox stackPane = new VBox(eventDate, eventDescription);

        getChildren().addAll(stackPane);
    }
}
