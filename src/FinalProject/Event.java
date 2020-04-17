package FinalProject;

import javafx.scene.Group;
import javafx.scene.text.Text;

public class Event extends Group {

    private String date;
    private String description;

    public Event(String date, String description) {
        this.date = date;
        this.description = description;

        Text something = new Text(description);
        getChildren().addAll(something);
    }
}
