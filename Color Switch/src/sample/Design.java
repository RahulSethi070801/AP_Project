package sample;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.*;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Design implements Display
{
    private Group root;

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
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Line line1 = new Line(250, 200, 350, 200);
        line1.setStrokeWidth(20);
        Line line2 = new Line(350, 200, 450, 200);
        line2.setStrokeWidth(20);
        Line line3 = new Line(350, 200, 350, 300);
        line3.setStrokeWidth(20);
        Line line4 = new Line(350, 200, 350, 100);
        line4.setStrokeWidth(20);

        line1.setStroke(Color.rgb(144, 13, 255));
        line2.setStroke(Color.rgb(250, 225, 0));
        line3.setStroke(Color.rgb(50, 219, 240));
        line4.setStroke(Color.rgb(255, 1, 129));



        Line line5 = new Line(1000, 200, 1100, 200);
        line5.setStrokeWidth(20);
        Line line6 = new Line(1100, 200, 1200, 200);
        line6.setStrokeWidth(20);
        Line line7 = new Line(1100, 200, 1100, 300);
        line7.setStrokeWidth(20);
        Line line8 = new Line(1100, 200, 1100, 100);
        line8.setStrokeWidth(20);

        line5.setStroke(Color.rgb(144, 13, 255));
        line6.setStroke(Color.rgb(250, 225, 0));
        line7.setStroke(Color.rgb(50, 219, 240));
        line8.setStroke(Color.rgb(255, 1, 129));

        Group root1 = new Group(line1, line2, line3, line4);

        RotateTransition rotateTransition1 = new RotateTransition();
        rotateTransition1.setDuration(Duration.millis(2000));
        rotateTransition1.setNode(root1);
        rotateTransition1.setByAngle(360);
        rotateTransition1.setCycleCount(Timeline.INDEFINITE);
        rotateTransition1.setAutoReverse(false);
        rotateTransition1.setInterpolator(Interpolator.LINEAR);
        rotateTransition1.play();

        Group root2 = new Group(line5, line6, line7, line8);

        RotateTransition rotateTransition2 = new RotateTransition();
        rotateTransition2.setDuration(Duration.millis(2000));
        rotateTransition2.setNode(root2);
        rotateTransition2.setByAngle(360);
        rotateTransition2.setCycleCount(Timeline.INDEFINITE);
        rotateTransition2.setAutoReverse(false);
        rotateTransition2.setInterpolator(Interpolator.LINEAR);
        rotateTransition2.play();


        String localDir = System.getProperty("user.dir");

        InputStream stream1 = new FileInputStream(localDir+"\\QuestionMark.png");
        javafx.scene.image.Image image1 = new javafx.scene.image.Image(stream1);
        ImageView imageView1 = new ImageView();
        imageView1.setImage(image1);
        imageView1.setX(400);
        imageView1.setY(400);
        imageView1.setFitWidth(80);
        imageView1.setPreserveRatio(true);

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Bounds bounds = root.getBoundsInParent();
                System.out.println("Hello World");
                //imageView1.setFill(Color.DARKSLATEBLUE);
                try {
                    new Help();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        };
        //Registering the event filter
        imageView1.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

        InputStream stream2 = new FileInputStream(localDir+"\\Achievements.png");
        javafx.scene.image.Image image2 = new javafx.scene.image.Image(stream2);
        ImageView imageView2 = new ImageView();
        imageView2.setImage(image2);
        imageView2.setX(400);
        imageView2.setY(500);
        imageView2.setFitWidth(80);
        imageView2.setPreserveRatio(true);

        EventHandler<MouseEvent> eventHandler2 = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Bounds bounds = root.getBoundsInParent();
                System.out.println("Hello World");
                try {
                    new Achievements();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        };
        //Registering the event filter
        imageView2.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler2);


        InputStream stream31 = new FileInputStream(localDir + "\\Speaker.png");
        javafx.scene.image.Image image31 = new javafx.scene.image.Image(stream31);
        InputStream stream32 = new FileInputStream(localDir + "\\SpeakerMute.png");
        javafx.scene.image.Image image32 = new javafx.scene.image.Image(stream32);
        ImageView imageView3 = new ImageView();
        imageView3.setImage(image31);
        imageView3.setX(1010);
        imageView3.setY(400);
        imageView3.setFitWidth(70);
        imageView3.setPreserveRatio(true);

        EventHandler<MouseEvent> eventHandler3 = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                if (imageView3.getImage() == image31)
                {
                    imageView3.setImage(image32);
                    Main.sound = false;
                }
                else
                {
                    imageView3.setImage(image31);
                    Main.sound = true;
                }
            }
        };
        //Registering the event filter
        imageView3.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler3);

        InputStream stream41 = new FileInputStream(localDir +"\\music-icon.png");
        javafx.scene.image.Image image41 = new Image(stream41);
        InputStream stream42 = new FileInputStream(localDir +"\\muted-music.png");
        javafx.scene.image.Image image42 = new Image(stream42);
        ImageView imageView4 = new ImageView();
        imageView4.setImage(image41);
        imageView4.setX(1007);
        imageView4.setY(500);
        imageView4.setFitWidth(80);
        imageView4.setPreserveRatio(true);

        EventHandler<MouseEvent> eventHandler4 = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                if (imageView4.getImage() == image41)
                {
                    imageView4.setImage(image42);

//                    Main.music=false;
                    Main.mediaPlayerMain.stop();
                }
                else
                {
                    imageView4.setImage(image41);
                    Main.localDir = System.getProperty("user.dir");
                    Main.path = localDir+"\\BackgroundMusic.mp3";
                    Main.mediaMain = new Media(new File(Main.path).toURI().toString());
                    Main.mediaPlayerMain = new MediaPlayer(Main.mediaMain);
                    Main.music = true;
                    Main.mediaPlayerMain.setAutoPlay(Main.music);
                }
            }
        };
        //Registering the event filter
        imageView4.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler4);

        Group root3 = new Group(imageView1, imageView2, imageView3, imageView4);

        root.getChildren().add(root1);
        root.getChildren().add(root2);
        root.getChildren().add(root3);

    }
}