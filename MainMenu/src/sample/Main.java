package sample;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.shape.*;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.InputStream;


public class Main extends Application {

    public static Stage stage;

    public Main() {
        stage = new Stage();
    }


    @Override
    public void start(Stage stage1) throws Exception
    {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //stage.setTitle("Hello World");
        stage.setFullScreen(true);


        Heading hd = new Heading();
        hd.show();
        Group root1 = hd.getRoot();

        Design ds = new Design();
        ds.show();
        Group root2 = ds.getRoot();

        PlayButton pb = new PlayButton();
        pb.show();
        Group root3 = pb.getRoot();

        GameModesBanner gmb = new GameModesBanner();
        gmb.show();
        Group root4 = gmb.getRoot();

        Exit exit = new Exit();
        exit.show();
        Group root5 = exit.getRoot();



        Group root = new Group();
        root.getChildren().add(root1);
        root.getChildren().add(root2);
        root.getChildren().add(root3);
        root.getChildren().add(root4);
        root.getChildren().add(root5);
//        root.getChildren().add(root6);

        stage.setScene(new Scene(root, 800, 800, Color.BLACK));
        stage.show();
}


    public static void main(String[] args) {
        launch(args);
    }
}
