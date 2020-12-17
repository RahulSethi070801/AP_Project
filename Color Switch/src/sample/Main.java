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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


public class Main extends Application {

    public static Stage stage;
    public static Stage stage2;
    public static boolean sound = true;
    public static boolean music = true;
    public static boolean newPage = true;
    public static Media mediaMain;
    public static MediaPlayer mediaPlayerMain;
    public static User user;
    public static String localDir;
    public static String path;
    public Main() {
        System.out.println("oausbdo");
        stage = new Stage();
        stage2 = new Stage();
    }

    @Override
    public void start(Stage stage1) throws Exception
    {
        stage.show();
        //stage2.show();
        localDir = System.getProperty("user.dir");
        path = localDir+"\\BackgroundMusic.mp3";
        Main.mediaMain = new Media(new File(path).toURI().toString());
        Main.mediaPlayerMain = new MediaPlayer(Main.mediaMain);
        new StartingGame();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


// TODO : high score total score serializable (done)
// TODO : PPT
// TODO : Integrate (done)
// TODO : Horizontal Line
// TODO : Design Pattern

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