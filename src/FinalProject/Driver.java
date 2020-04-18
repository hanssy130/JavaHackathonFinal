package FinalProject;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main driver of the application.
 */
public class Driver extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        new MainMenu().firstStage();
    }
}
