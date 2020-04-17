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

public class MainMenu extends Stage {



    public void firstStage() {
        BorderPane layoutMainMenu = new BorderPane();
        layoutMainMenu.setBackground(new Background(
                new BackgroundFill(Color.rgb(173, 216, 230),
                        CornerRadii.EMPTY,
                        Insets.EMPTY
                        )));
        //Spacing from window border to actual layout is 10px every side.
        layoutMainMenu.setPadding(new Insets(10));


        // Button to go to scene with buttons to time lines
        Button buttonIntroduction = new Button();
        buttonIntroduction.setText("Introduction");
        buttonIntroduction.setOnAction(actionEvent -> {
            new Introduction().introductionStage();
            this.close();
        });

        Button buttonCovid19 = new Button();
        buttonCovid19.setText("What is Covid-19?");
        buttonCovid19.setOnAction(actionEvent -> {
            new Covid19().info();
            this.close();
        });

        Button buttonTimelines = new Button();
        buttonTimelines.setText("Timeline of Events");
        buttonTimelines.setOnAction(actionEvent -> {
            new TimelineMenu().timeLineStage();
            this.close();
        });

        Label title = new Label("Taiwan #1");
        /*
        Set font size.
         */
        title.setFont(new Font(30));

        /*
        This is the HBox to hold the title
         */
        HBox menuTop = new HBox();
        menuTop.getChildren().addAll(title);
        menuTop.setAlignment(Pos.CENTER);

        layoutMainMenu.setTop(menuTop);


        Text introduction = new Text();
        introduction.setText("How Taiwan Contained an Epidemic Virus Better Than the Rest");
        introduction.setFont(new Font(16));

        //The VBox for all of the items going in the center of the BorderPane
        VBox centerContent = new VBox(10);
        centerContent.getChildren().addAll(introduction, buttonIntroduction, buttonCovid19,
                buttonTimelines);
        centerContent.setAlignment(Pos.TOP_CENTER);
        layoutMainMenu.setCenter(centerContent);


        Scene sceneMain = new Scene(layoutMainMenu, 800, 600);

        this.setTitle("Main Menu");
        this.setScene(sceneMain);
        this.setResizable(false);
        this.show();
    }


}
