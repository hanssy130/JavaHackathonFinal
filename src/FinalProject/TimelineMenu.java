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

/**
 * Holds the Menu to choose timelines.
 *
 * @author Hans Sy
 * @version 2020
 */
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

    /**
     * Stage for the Timeline Menu.
     */
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

        btnCommunication = new Button("Actions on Communication");
        btnCommunication.setOnAction(actionEvent -> {
            new Timelines().communicationsStage();
            this.close();
        });

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
