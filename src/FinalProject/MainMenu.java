package FinalProject;

import javafx.application.Application;
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
        Button buttonTimelines = new Button("Go to timelines");
        buttonTimelines.setOnAction(actionEvent -> {
            new TimelineMenu().timeLineStage();
            this.close();
        });

        HBox menuBottomMainMenu = new HBox();
        menuBottomMainMenu.getChildren().addAll(buttonTimelines);

        layoutMainMenu.setBottom(menuBottomMainMenu);

        Label title = new Label("What is Covid-19?");
        /*
        Set font and font size.
         */
        title.setFont(new Font("Arial", 30));

        /*
        This is the HBox to hold the title
         */
        HBox menuTop = new HBox();
        menuTop.getChildren().addAll(title);
        menuTop.setAlignment(Pos.CENTER);

        layoutMainMenu.setTop(menuTop);



        VBox centerText = new VBox();
        Text introduction = new Text();
        introduction.setText("This is sample Covid-19 text");
        introduction.setFont(new Font(30));

        centerText.getChildren().add(introduction);
        centerText.setAlignment(Pos.TOP_CENTER);
        layoutMainMenu.setCenter(centerText);


        Scene sceneMain = new Scene(layoutMainMenu, 800, 600);

        this.setTitle("Main Menu");
        this.setScene(sceneMain);
        this.setResizable(false);
        this.show();
    }


}
