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

    /**
     * Stage for Covid-19 page.
     */
    public void covid19Stage() {
        // Pane Setup
        BorderPane layout = new BorderPane();
        layout.setBackground(new Background(
                new BackgroundFill(Color.rgb(173, 216, 230),
                        CornerRadii.EMPTY,
                        Insets.EMPTY
                )));
        layout.setPadding(new Insets(10));

        // Introduction info
        Label title = new Label("What is COVID-19?");
        title.setFont(new Font("Arial", 50));
        Text information = new Text("Coronaviruses are a large family of viruses. Some cause illness in people and " +
                "others cause illness in animals. Human coronaviruses are common and are typically associated with " +
                "mild illnesses, similar to the common cold.\n" +
                "\n COVID-19 is a new disease that has not been previously identified in humans. Rarely, animal " +
                "coronaviruses can infect people, and more rarely, these can then spread from person to person through " +
                "close contact.\n\n Clicking the simulation link below creates an example of how COVID-19 spreads in Taiwan" +
                " from person to person. Click the next button for a simulation of the infection in the United States.\n\n");
        information.setWrappingWidth(550);
        information.setFont(new Font("Arial", 16));

        // Back button
        Button btnBack = new Button("Back");
        btnBack.setOnAction(actionEvent -> {
            new MainMenu().firstStage();
            this.close();
        });

        // Button to see simulations

        Button buttonSimulation = new Button();
        buttonSimulation.setText("Contagious Virus Simulation");
        buttonSimulation.setOnAction(actionEvent -> {
            new Taiwan().start();

        });

        HBox bottomContent = new HBox();
        bottomContent.getChildren().addAll(buttonSimulation);
        bottomContent.setAlignment(Pos.CENTER);

        layout.setBottom(bottomContent);

        // Use Vbox to stack vertically.
        VBox vbox = new VBox();
        vbox.getChildren().addAll(title, information, btnBack);
        vbox.setAlignment(Pos.TOP_LEFT);
        layout.setCenter(vbox);

        // Create the scene.
        Scene sceneMain = new Scene(layout, 800, 600);
        this.setTitle("Introduction");
        this.setScene(sceneMain);
        this.setResizable(false);
        this.show();
    }
}
