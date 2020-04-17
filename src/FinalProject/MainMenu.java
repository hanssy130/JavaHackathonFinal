package FinalProject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainMenu extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {



        BorderPane layoutGrid = new BorderPane();
        //Spacing from window border to actual layout is 10px every side.
        layoutGrid.setPadding(new Insets(10, 10, 10, 10));


        // Button to go to scene with buttons to time lines
        Button buttonTimelines = new Button("Go to timelines");

        HBox menuBottom = new HBox();
        menuBottom.getChildren().addAll(buttonTimelines);

        layoutGrid.setBottom(menuBottom);


        Scene mainScene = new Scene(layoutGrid, 800, 600, Color.LIGHTBLUE);


        primaryStage.setTitle("Main Menu");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
}
