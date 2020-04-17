package FinalProject;

import javafx.application.Application;
import javafx.stage.Stage;

import java.lang.reflect.Member;

public class Driver extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        new MainMenu().firstStage();
    }
}
