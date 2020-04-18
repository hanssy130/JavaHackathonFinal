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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainMenu extends Stage {



    public void firstStage() {
        BorderPane layoutMainMenu = new BorderPane();
        final int red = 173;
        final int green = 216;
        final int blue = 230;
        layoutMainMenu.setBackground(new Background(
                new BackgroundFill(Color.rgb(red, green, blue),
                        CornerRadii.EMPTY,
                        Insets.EMPTY
                        )));

        final int layoutPadding = 10;
        //Spacing from window border to actual layout is 10px every side.
        layoutMainMenu.setPadding(new Insets(layoutPadding));


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
        final int titleSize = 30;
        title.setFont(new Font(titleSize));

        /*
        This is the HBox to hold the title
         */
        HBox menuTop = new HBox();
        menuTop.getChildren().addAll(title);
        menuTop.setAlignment(Pos.CENTER);

        layoutMainMenu.setTop(menuTop);


        Text introduction = new Text();
        introduction.setText("How Taiwan Contained an Epidemic Virus Better Than the Rest");
        final int textSize = 16;
        introduction.setFont(new Font(textSize));

        //The VBox for all of the items going in the center of the BorderPane
        final int vBoxVerticalSpacing = 10;
        VBox centerContent = new VBox(vBoxVerticalSpacing);
        centerContent.getChildren().addAll(introduction, buttonIntroduction, buttonCovid19,
                buttonTimelines);
        centerContent.setAlignment(Pos.TOP_CENTER);
        layoutMainMenu.setCenter(centerContent);

        final int maxX = 800;
        final int maxY = 600;

        Scene sceneMain = new Scene(layoutMainMenu, maxX, maxY);

        this.setTitle("Main Menu");
        this.setScene(sceneMain);
        this.setResizable(false);
        this.show();
    }


}
