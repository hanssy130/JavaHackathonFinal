package FinalProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.io.FileInputStream;

public class TimelineMenu extends Stage {

    // Button directs to Border Control, Travel, & Finding Cases timeline.
    private Button btnBorderControl;

    // Button directs to Resource Allocation timeline.
    private Button btnResourceAllocation;

    // Button directs to Communication timeline.
    private Button btnCommunication;

    // Back button
    private Button btnBack;

    private Label title;
    private Text information;


    public void timeLineStage() {
        // Introduction info
        title = new Label("Timeline of Events");
        title.setFont(new javafx.scene.text.Font("Arial", 50));
        information = new Text("Click on a timeline to explore Taiwan's responses in each area.");
        information.setFont(new Font("Arial", 16));

        // Initializes the buttons
        btnBorderControl = new Button("Actions on Border Control, Travel, & Finding Cases");
        btnBorderControl.setOnAction(actionEvent -> {
            new Timelines().borderControlStage();
            this.close();
        });

        btnResourceAllocation = new Button("Actions on Resource Allocation");
        btnResourceAllocation.setOnAction(actionEvent -> {
            new Timelines().resourceAllocationStage();
            this.close();
        });
//        btnResourceAllocation.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                PictureEvent hey2 = new PictureEvent("Jan1", "I love dogs.", "https://o7planning.org/en/11529/cache/images/i/10503004.png");
//                StackPane thirdLayout = new StackPane(hey2);
//                Scene thirdScene = new Scene(thirdLayout, 400, 300);
//
//                // New window (Stage)
//                Stage newWindow = new Stage();
//                newWindow.setTitle("Third Stage");
//                newWindow.setScene(thirdScene);
//
//                // Set position of second window, related to primary window.
//                newWindow.setX(200);
//                newWindow.setY(100);
//
//                newWindow.show();
//            }
//        });

        btnCommunication = new Button("Actions on Communication");
        btnCommunication.setOnAction(actionEvent -> {
            new Timelines().communicationsStage();
            this.close();
        });
//        btnCommunication.setOnAction(event -> {
//            Event hey = new Event("Dec 31", "I ate a cat.");
//            StackPane secondaryLayout = new StackPane(hey);
//            Scene secondScene = new Scene(secondaryLayout, 400, 300);
//
//            // New window (Stage)
//            Stage newWindow = new Stage();
//            newWindow.setTitle("Example Event");
//            newWindow.setScene(secondScene);
//
//            // Set position of second window, related to primary window.
//            newWindow.setX(200);
//            newWindow.setY(100);
//
//            newWindow.show();
//        });

        btnBack = new Button("Back");
        btnBack.setOnAction(actionEvent -> {
            new MainMenu().firstStage();
            this.close();
        });

        // Controls the buttons' spacing & alignment
        VBox buttons = new VBox(title, information, btnBorderControl, btnResourceAllocation, btnCommunication, btnBack);
        final int spacing = 15;
        final int inset = 15;
        buttons.setSpacing(spacing);
        buttons.setPadding(new Insets(inset, 0, 0, 0));
        buttons.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane();
        root.setBackground(new Background(new BackgroundFill(Color.rgb(173, 216, 230), CornerRadii.EMPTY, Insets.EMPTY)));
        root.setCenter(buttons);

        Scene scene = new Scene(root, 800, 600, Color.LIGHTBLUE);

        this.setTitle("Timeline");
        this.setScene(scene);
        this.show();
    }
}
