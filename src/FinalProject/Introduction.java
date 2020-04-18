package FinalProject;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Features the stage of the Introduction.
 *
 * @author Hans Sy
 * @version 2020
 */
public class Introduction extends Stage {

    // Holds the title.
    private Label title;
    // Holds the information.
    private Text information;
    // Holds the back button.
    private Button btnBack;

    /**
     * Creates the stage of the Introduction.
     */
    public void introductionStage() {
        // Pane Setup
        BorderPane layoutIntro = new BorderPane();
        layoutIntro.setBackground(new Background(
                new BackgroundFill(Color.rgb(173, 216, 230),
                        CornerRadii.EMPTY,
                        Insets.EMPTY
                )));
        layoutIntro.setPadding(new Insets(10));

        // Introduction info
        title = new Label("Introduction");
        title.setFont(new Font("Arial", 50));
        information = new Text("During the epidemic of COVID-19, each country’s response "
                + "has had dramatic impacts on how well they dealt with the crisis. Taiwan is "
                + "one of the top performers, if not the best, in preventing the outbreak from "
                + "getting out of hand, unlike the USA and Italy. Our project an informative "
                + "application that educates the masses on how Taiwan was able to accomplish "
                + "such a feat. \n\n"
                + "Presented by Brian, Hans, Jason, and Justin");
        information.setWrappingWidth(550);
        information.setFont(new Font("Arial", 16));

        // Back button
        btnBack = new Button("Back");
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
