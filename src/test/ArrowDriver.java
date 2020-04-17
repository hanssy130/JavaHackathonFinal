package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ArrowDriver extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Arrow tester = new Arrow();
        Scene scene = new Scene(tester, 600,  400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
