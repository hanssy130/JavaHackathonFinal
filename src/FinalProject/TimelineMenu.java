package FinalProject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;

public class TimelineMenu extends Stage {

    // Button directs to Border Control, Travel, & Finding Cases timeline.
    private Button btnBorderControl;

    // Button directs to Resource Allocation timeline.
    private Button btnResourceAllocation;

    // Button directs to Communication timeline.
    private Button btnCommunication;


    public void timeLineStage() {

        // Initializes the buttons
        btnBorderControl = new Button("Say 'Hello World' Actions on Border Control, Travel, & Finding Cases");
        btnBorderControl.setOnAction(event -> System.out.println("Hello World!"));
        btnResourceAllocation = new Button("Actions on Resource Allocation");
        btnResourceAllocation.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PictureEvent hey2 = new PictureEvent("Jan1", "I love dogs.", "https://o7planning.org/en/11529/cache/images/i/10503004.png");
                StackPane thirdLayout = new StackPane(hey2);
                Scene thirdScene = new Scene(thirdLayout, 400, 300);

                // New window (Stage)
                Stage newWindow = new Stage();
                newWindow.setTitle("Third Stage");
                newWindow.setScene(thirdScene);

                // Set position of second window, related to primary window.
                newWindow.setX(200);
                newWindow.setY(100);

                newWindow.show();
            }
        });

        btnCommunication = new Button("Actions on Communication");
        btnCommunication.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Event hey = new Event("Dec 31", "I ate a cat.");
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
            }
        });

        // Controls the buttons' spacing & alignment
        VBox buttons = new VBox(btnBorderControl, btnResourceAllocation, btnCommunication);
        final int spacing = 15;
        final int inset = 15;
        buttons.setSpacing(spacing);
        buttons.setPadding(new Insets(inset, 0, 0, 0));
        buttons.setAlignment(Pos.CENTER);

        StackPane root = new StackPane();
        root.setBackground(new Background(new BackgroundFill(Color.rgb(173, 216, 230), CornerRadii.EMPTY, Insets.EMPTY)));
        root.getChildren().add(buttons);

        Scene scene = new Scene(root, 800, 600, Color.LIGHTBLUE);

        this.setTitle("Timeline");
        this.setScene(scene);
        this.show();
    }
}
