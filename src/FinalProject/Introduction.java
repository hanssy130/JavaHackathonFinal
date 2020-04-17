package FinalProject;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Introduction extends Stage {

    private Label title;
    private Text information;

    public void introductionStage() {
        BorderPane layoutIntro = new BorderPane();
        layoutIntro.setBackground(new Background(
                new BackgroundFill(Color.rgb(173, 216, 230),
                        CornerRadii.EMPTY,
                        Insets.EMPTY
                )));
        // Spacing from window border to actual layout is 10px every side.
        layoutIntro.setPadding(new Insets(10));

        title = new Label("Introduction");
        title.setFont(new Font("Arial", 50));

        information = new Text(" During the epidemic of COVID-19, each country’s response has had dramatic impacts " +
                "on how well they dealt with the crisis. Taiwan is one of the top performers, if not the best, in " +
                "preventing the outbreak from getting out of hand, unlike the USA and Italy. Our project an " +
                "informative application that educates the masses on how Taiwan was able to accomplish such a feat.\n" +
                "\n" +
                "Presented by Brian, Hans, Jason, and Justin");
        information.setFont(new Font("Arial", 12));

        VBox vbox = new VBox();
        vbox.getChildren().addAll(title, information);
        vbox.setAlignment(Pos.TOP_LEFT);

        layoutIntro.setCenter(vbox);

        Scene sceneMain = new Scene(layoutIntro, 800, 600);

        this.setTitle("Introduction");
        this.setScene(sceneMain);
        this.setResizable(false);
        this.show();
    }
}
