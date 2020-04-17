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
import javafx.stage.Stage;

import java.awt.*;

public class TimelineMenu extends Application {

    // Button directs to Border Control, Travel, & Finding Cases timeline.
    private Button btnBorderControl;

    // Button directs to Resource Allocation timeline.
    private Button btnResourceAllocation;

    // Button directs to Communication timeline.
    private Button btnCommunication;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Initializes the buttons
        btnBorderControl = new Button("Say 'Hello World' Actions on Border Control, Travel, & Finding Cases");
        btnBorderControl.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        btnResourceAllocation = new Button("Actions on Resource Allocation");
        btnCommunication = new Button("Actions on Communication");

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

        primaryStage.setTitle("Timeline");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
