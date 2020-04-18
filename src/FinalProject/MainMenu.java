package FinalProject;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
            new Covid19().covid19Stage();
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

        //Image
        Image taiwanImage = null;
        try {
            taiwanImage = new Image(new FileInputStream("resources/taiwanImage.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ImageView imgView = new ImageView(taiwanImage);
        final int imageY = 100;
        imgView.setY(imageY);

        final int verticalSpacing = 10;
        //The VBox for all of the items going in the center of the BorderPane
        VBox centerContent = new VBox(verticalSpacing);
        centerContent.getChildren().addAll(introduction, imgView, buttonIntroduction, buttonCovid19,
                buttonTimelines);
        final int spacing = 15;
        final int inset = 15;
        centerContent.setSpacing(spacing);
        centerContent.setPadding(new Insets(inset, 0, 0, 0));
        centerContent.setAlignment(Pos.CENTER);
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
