package sample;

import javafx.animation.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Time;
import java.util.Random;


class StartingGame
{
    Group root;

    public StartingGame() throws FileNotFoundException {
        this.root= new Group();
        Scene scene0 = new Scene(root, 800, 800, Color.BLACK);
        Main.stage.setScene(scene0);
        Main.stage.setFullScreen(true);

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

        Ring r = new Ring();
        r.show(0);
        Group root1 = r.getRoot();

        Ball b = new Ball();
        b.show();
        Group root2 = b.getRoot();

        TranslateTransition translateTransition1 = new TranslateTransition(Duration.millis(500), root2);
        //translateTransition1.setFromY(700);
        translateTransition1.setToY(-150);
        translateTransition1.setCycleCount(1);
        //translateTransition1.setAutoReverse(true);

        String localDir = System.getProperty("user.dir");
        String path = localDir+"\\jump.wav";
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);

        TranslateTransition translateTransition2 = new TranslateTransition(Duration.millis(500), root2);
        //translateTransition2.setFromY(400);
        translateTransition2.setToY(0);
        translateTransition2.setCycleCount(1);
        translateTransition2.setAutoReverse(true);

        TranslateTransition translateTransition3 = new TranslateTransition(Duration.millis(500), root2);
        //translateTransition3.setFromY(700);
        translateTransition3.setToY(-150);
        translateTransition3.setCycleCount(1);
        translateTransition3.setAutoReverse(true);



        TranslateTransition translateTransition4 = new TranslateTransition(Duration.millis(500), root2);
        //translateTransition4.setFromY(400);
        translateTransition4.setToY(0);
        translateTransition4.setCycleCount(1);
        translateTransition4.setAutoReverse(true);

        TranslateTransition translateTransition5 = new TranslateTransition(Duration.millis(200), root2);
        //translateTransition4.setFromY(400);
        translateTransition5.setToY(-320);
        translateTransition5.setCycleCount(1);
        translateTransition5.setAutoReverse(true);

        mediaPlayer.seek(mediaPlayer.getStartTime());

//        TranslateTransition translateTransition6 = new TranslateTransition(Duration.millis(500), root2);
//        //translateTransition4.setFromY(400);
//        translateTransition6.setToY(200);
//        translateTransition6.setCycleCount(1);
//        translateTransition6.setAutoReverse(true);

        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(translateTransition1, translateTransition2, translateTransition3, translateTransition4, translateTransition5);
        sequentialTransition.setCycleCount(1);
        sequentialTransition.setInterpolator(Interpolator.LINEAR);
        //sequentialTransition.setAutoReverse(true);
        sequentialTransition.play();

        root.getChildren().addAll(root1, root2);


    }
}
