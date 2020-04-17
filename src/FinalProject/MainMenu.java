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
import javafx.stage.Stage;

public class MainMenu extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
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


        Scene sceneMain = new Scene(layoutMainMenu, 800, 600);

        BorderPane layoutButtons = new BorderPane();
        layoutButtons.setPadding(new Insets(10));

        /*
        The different buttons that will appear on the second scene
         */


        


        primaryStage.setTitle("Main Menu");
        primaryStage.setScene(sceneMain);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


}
