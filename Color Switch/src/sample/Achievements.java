package sample;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Point3D;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.*;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

class Achievements
{
    Group root;

    Achievements() throws FileNotFoundException {
        show();
    }

    public void setRoot(Group root)
    {
        this.root = root;
    }

    public Group getRoot()
    {
        return root;
    }

    public void show() throws FileNotFoundException {
        root = new Group();
        Scene scene4 = new Scene(root, 1600, 1050, Color.BLACK);
        Main.stage.setScene(scene4);
        Main.stage.setX(-25);
        Main.stage.setY(-35);
//        Main.stage.setFullScreen(true);

        root.setEffect(new GaussianBlur());

        VBox pauseRoot = new VBox(40);
        String  style= getClass().getResource("styles.css").toExternalForm();
        pauseRoot.getStylesheets().add(style);
        pauseRoot.setFillWidth(true);

        pauseRoot.setId("menu");
        pauseRoot.setAlignment(Pos.CENTER);
        pauseRoot.setPadding(new Insets(20));
        pauseRoot.setEffect(new DropShadow(20, Color.BLACK));

        javafx.scene.control.Label achievements = new javafx.scene.control.Label("Achievements");
        achievements.setEffect(new DropShadow(20,Color.BLACK));
        achievements.setId("achievements");
        pauseRoot.getChildren().add(achievements);

        javafx.scene.control.Label name = new javafx.scene.control.Label("Player name : " + Main.user.name);
        name.setEffect(new DropShadow(20,Color.BLACK));
        name.setId("user");
        pauseRoot.getChildren().add(name);

        javafx.scene.control.Label highestScore = new javafx.scene.control.Label("Highest Score : " + Main.user.highestScore);
        highestScore.setEffect(new DropShadow(20,Color.BLACK));
        highestScore.setId("user");
        pauseRoot.getChildren().add(highestScore);

        javafx.scene.control.Label totalStars = new javafx.scene.control.Label("Total Stars : " + Main.user.totalScore);
        totalStars.setEffect(new DropShadow(20,Color.BLACK));
        totalStars.setId("user");
        pauseRoot.getChildren().add(totalStars);

        Button exit = new Button("Close");
        exit.setId("exit");
        exit.setEffect(new DropShadow(20, Color.BLACK));
        pauseRoot.getChildren().add(exit);

        Stage popupStage = new Stage(StageStyle.TRANSPARENT);
        popupStage.initOwner(Main.stage);
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setScene(new Scene(pauseRoot, Color.TRANSPARENT));
        popupStage.setX(500);
        popupStage.setY(250);

        exit.setOnAction(event -> {
            root.setEffect(null);
            popupStage.hide();
            try {
                new MainPage();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        popupStage.show();


    }

}