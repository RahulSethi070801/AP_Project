package sample;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Point3D;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.*;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Translate;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

public class MainPage
{
    private Group root;

    MainPage() throws FileNotFoundException, InterruptedException {
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

    public void printMenu(Game games[])
    {

    }

    public void printUserDetails(User user)
    {

    }

    public void show() throws FileNotFoundException, InterruptedException {
        root = new Group();

        FadeTransition fadeTransition1 = new FadeTransition();
        fadeTransition1.setDuration(Duration.millis(2000));
        fadeTransition1.setNode(root);
        fadeTransition1.setFromValue(0);
        fadeTransition1.setToValue(1);
        fadeTransition1.play();

        System.out.println(Main.stage);
        Main.stage.setScene(new Scene(root, 1600, 1050, Color.BLACK));
        Main.stage.setX(-25);
        Main.stage.setY(-35);



        Main.mediaPlayerMain.setAutoPlay(Main.music);


        if (Main.newPage)
        {
            root.setEffect(new GaussianBlur());

            VBox pauseRoot = new VBox(40);
            pauseRoot.setAlignment(Pos.CENTER);
            pauseRoot.setPadding(new Insets(20));
            pauseRoot.setEffect(new DropShadow(20, Color.BLACK));
            pauseRoot.setId("menu");
            pauseRoot.setFillWidth(true);

            String  style= getClass().getResource("styles.css").toExternalForm();
            pauseRoot.getStylesheets().add(style);

            Label paused = new Label("Enter your name");
            paused.setEffect(new DropShadow(20,Color.BLACK));
            paused.setId("paused");
            pauseRoot.getChildren().add(paused);

            TextField textField = new TextField();
            pauseRoot.getChildren().add(textField);

            Button but = new Button("Save");
            but.setId("save");
            pauseRoot.getChildren().add(but);

            Stage popupStage = new Stage(StageStyle.TRANSPARENT);
            popupStage.initOwner(Main.stage);
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setScene(new Scene(pauseRoot, Color.TRANSPARENT));
            popupStage.setX(500);
            popupStage.setY(250);

            but.setOnAction(eve ->{
                root.setEffect(null);
                String name = textField.getText();
                Main.user = new User(name);

                Design ds = new Design();
                try{
                    ds.show();
                }
                catch(Exception e)
                {

                }
                Group root2 = ds.getRoot();
                root.getChildren().add(root2);

                PlayButton pb = new PlayButton();
                pb.show();
                Group root3 = pb.getRoot();
                root.getChildren().add(root3);
                popupStage.hide();
            });
            popupStage.show();
        }
        else
        {
            Design ds = new Design();
            ds.show();
            Group root2 = ds.getRoot();
            root.getChildren().add(root2);
            PlayButton pb = new PlayButton();
            pb.show();
            Group root3 = pb.getRoot();
            root.getChildren().add(root3);
        }

        Heading hd = new Heading();
        hd.show();
        Group root1 = hd.getRoot();

        GameModesBanner gmb = new GameModesBanner();
        gmb.show();
        Group root4 = gmb.getRoot();

        FunModeBanner fmb = new FunModeBanner();
        fmb.show();
        Group root6 = fmb.getRoot();

        Exit exit = new Exit();
        exit.show();
        Group root5 = exit.getRoot();

        root.getChildren().add(root1);
        root.getChildren().add(root4);
        root.getChildren().add(root5);
        root.getChildren().addAll(root6);

        Main.newPage = false;

    }
}