package FinalProject;

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

/**
 * @author Brian Duong
 * @version 2020
 */
public class Covid19 extends Stage {

    public void info() {
        // Pane Setup
        BorderPane layoutIntro = new BorderPane();
        layoutIntro.setBackground(new Background(
                new BackgroundFill(Color.rgb(173, 216, 230),
                        CornerRadii.EMPTY,
                        Insets.EMPTY
                )));
        layoutIntro.setPadding(new Insets(10));

        // Introduction info
        Label title = new Label("Introduction");
        title.setFont(new Font("Arial", 50));
        Text information = new Text("Coronaviruses are a large family of viruses. Some cause"
                + " illness in people and others cause illness in animals. Human coronaviruses "
                + "are common and are typically associated with mild illnesses, similar to the "
                + "common cold.\n\n"
                + "COVID-19 is a new disease that has not been previously identified in humans."
                + " Rarely, animal coronaviruses can infect people, and more rarely, "
                + "these can then spread from person to person through close contact.\n\n"
                + "Presented by Brian, Hans, Jason, and Justin");
        information.setWrappingWidth(550);
        information.setFont(new Font("Arial", 16));

        // Back button
        Button btnBack = new Button("Back");
        btnBack.setOnAction(actionEvent -> {
            new MainMenu().firstStage();
            this.close();
        });

        // Use Vbox to stack vertically.
        VBox vbox = new VBox();
        vbox.getChildren().addAll(title, information, btnBack);
        vbox.setAlignment(Pos.TOP_LEFT);
        layoutIntro.setCenter(vbox);

        // Create the scene.
        Scene sceneMain = new Scene(layoutIntro, 800, 600);
        this.setTitle("Introduction");
        this.setScene(sceneMain);
        this.setResizable(false);
        this.show();
    }
}
