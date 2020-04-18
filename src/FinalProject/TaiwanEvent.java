package FinalProject;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class TaiwanEvent extends Group {

    private String date;
    private String description;

    public TaiwanEvent(String date, String description) {
        this.date = date;
        this.description = description;

        Text eventDate = new Text(date);
        Text eventDescription = new Text(description);
        VBox stackPane = new VBox(eventDate, eventDescription);
        final int spacing = 15;
        final int inset = 15;
        stackPane.setSpacing(spacing);
        stackPane.setPadding(new Insets(inset, 0, 0, 0));
        stackPane.setAlignment(Pos.CENTER);

        getChildren().addAll(stackPane);
    }
}
