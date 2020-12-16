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
    public static Stage stage2;
    public static boolean sound = true;
    public static boolean newPage = true;
    public static User user;
    public Main() {
        stage = new Stage();
        stage2 = new Stage();
    }


    @Override
    public void start(Stage stage1) throws Exception
    {
        stage.show();
        new StartingGame();
        //new MainPage();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


/*

--module-path
F:\openjfx-11.0.2_windows-x64_bin-sdk\javafx-sdk-11.0.2\lib
--add-modules
javafx.controls,javafx.media,javafx.graphics,javafx.fxml
--add-exports
javafx.graphics/com.sun.javafx.sg.prism=ALL-UNNAMED

 */
/*
C:\Users\Tushar\Downloads\javafx-sdk-15.0.1\lib
 */