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
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Time;
import java.util.Random;


class StartingGame implements Display
{
    private Group root;

    public StartingGame() throws FileNotFoundException, InterruptedException {
        this.root= new Group();
        Scene scene0 = new Scene(root, 1600, 1050, Color.BLACK);
        Main.stage.setScene(scene0);
        Main.stage.setX(-25);
        Main.stage.setY(-35);
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

    public void show() throws FileNotFoundException, InterruptedException
    {
        Heading hd = new Heading();
        hd.show();
        Group root0 = hd.getRoot();

        Arc arc1 = new Arc(720, 500, 120, 120, 0, 90);
        arc1.setFill(Color.rgb(144, 13, 255));
        arc1.setType(ArcType.ROUND);
        arc1.setStrokeWidth(30);

        Arc arc2 = new Arc(720, 500, 120, 120, 90, 90);
        arc2.setFill(Color.rgb(250, 225, 0));
        arc2.setType(ArcType.ROUND);
        arc2.setStrokeWidth(30);

        Arc arc3 = new Arc(720, 500, 120, 120, 180, 90);
        arc3.setFill(Color.rgb(50, 219, 240));
        arc3.setType(ArcType.ROUND);
        arc3.setStrokeWidth(30);

        Arc arc4 = new Arc(720, 500, 120, 120, 270, 90);
        arc4.setFill(Color.rgb(255, 1, 129));
        arc4.setType(ArcType.ROUND);
        arc4.setStrokeWidth(30);

        Arc arc5 = new Arc(720, 500, 85, 85, 0, 90);
        arc5.setFill(Color.rgb(144, 13, 255));
        arc5.setType(ArcType.ROUND);
        arc5.setStrokeWidth(25);

        Arc arc6 = new Arc(720, 500, 85, 85, 90, 90);
        arc6.setFill(Color.rgb (250, 225, 0));
        arc6.setType(ArcType.ROUND);
        arc6.setStrokeWidth(25);

        Arc arc7 = new Arc(720, 500, 85, 85, 180, 90);
        arc7.setFill(Color.rgb(50, 219, 240));
        arc7.setType(ArcType.ROUND);
        arc7.setStrokeWidth(25);

        Arc arc8 = new Arc(720, 500, 85, 85, 270, 90);
        arc8.setFill(Color.rgb(255, 1, 129));
        arc8.setType(ArcType.ROUND);
        arc8.setStrokeWidth(25);

        Arc arc9 = new Arc(720, 500, 50, 50, 0, 90);
        arc9.setFill(Color.rgb(144, 13, 255));
        arc9.setType(ArcType.ROUND);
        arc9.setStrokeWidth(25);

        Arc arc10 = new Arc(720, 500, 50, 50, 90, 90);
        arc10.setFill(Color.rgb (250, 225, 0));
        arc10.setType(ArcType.ROUND);
        arc10.setStrokeWidth(25);

        Arc arc11 = new Arc(720, 500, 50, 50, 180, 90);
        arc11.setFill(Color.rgb(50, 219, 240));
        arc11.setType(ArcType.ROUND);
        arc11.setStrokeWidth(25);

        Arc arc12 = new Arc(720, 500, 50, 50, 270, 90);
        arc12.setFill(Color.rgb(255, 1, 129));
        arc12.setType(ArcType.ROUND);
        arc12.setStrokeWidth(25);

        Circle circle = new Circle(720, 500, 100);
        circle.setFill(Color.rgb(0, 0, 0));
        //circle.setStrokeWidth(5.0f);
        //circle.setStroke(Color.BLACK);

        Circle circle1 = new Circle(720, 500, 65);
        circle1.setFill(Color.rgb(0, 0, 0));
        //circle1.setStrokeWidth(5.0f);
        //circle1.setStroke(Color.BLACK);

        Circle circle2 = new Circle(720, 500, 30);
        circle2.setFill(Color.rgb(0,0,0));
        //circle2.setStrokeWidth(5.0f);
        //circle2.setStroke(Color.BLACK);

        Group root1 = new Group();

        Group root11 = new Group(arc1,arc4,arc3,arc2,circle);
        root1.getChildren().add(root11);

        Group root22 = new Group(arc5,arc6,arc7,arc8,circle1);
        root1.getChildren().add(root22);

        Group root33 = new Group(arc9,arc10,arc11,arc12, circle2);
        root1.getChildren().add(root33);

        RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);
        rotate.setCycleCount(Timeline.INDEFINITE);
        rotate.setDuration(Duration.millis(1000));
        rotate.setAutoReverse(false);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setNode(root11);
        rotate.play();

        RotateTransition rotate1 = new RotateTransition();
        rotate1.setAxis(Rotate.Z_AXIS);
        rotate1.setByAngle(-360);
        rotate1.setCycleCount(Timeline.INDEFINITE);
        rotate1.setDuration(Duration.millis(1000));
        rotate1.setAutoReverse(false);
        rotate1.setInterpolator(Interpolator.LINEAR);
        rotate1.setNode(root22);
        rotate1.play();

        RotateTransition rotate2 = new RotateTransition();
        rotate2.setAxis(Rotate.Z_AXIS);
        rotate2.setByAngle(360);
        rotate2.setCycleCount(Timeline.INDEFINITE);
        rotate2.setDuration(Duration.millis(1000));
        rotate2.setAutoReverse(false);
        rotate2.setInterpolator(Interpolator.LINEAR);
        rotate2.setNode(root33);
        rotate2.play();

        Ball b = new Ball(708, 800);
        b.show();
        Group root2 = b.getRoot();
        b.setFill(Color.rgb(255, 1, 129));

        TranslateTransition translateTransition1 = new TranslateTransition(Duration.millis(600), root2);
        translateTransition1.setToY(-140);
        translateTransition1.setCycleCount(1);


        String localDir = System.getProperty("user.dir");
        String path = localDir+"\\jump.wav";
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(3);
        mediaPlayer.setAutoPlay(Main.sound);


        TranslateTransition translateTransition2 = new TranslateTransition(Duration.millis(600), root2);
        translateTransition2.setToY(0);
        translateTransition2.setCycleCount(1);
        translateTransition2.setAutoReverse(true);

        TranslateTransition translateTransition3 = new TranslateTransition(Duration.millis(600), root2);
        translateTransition3.setToY(-140);
        translateTransition3.setCycleCount(1);
        translateTransition3.setAutoReverse(true);

        TranslateTransition translateTransition4 = new TranslateTransition(Duration.millis(600), root2);
        //translateTransition4.setFromY(400);
        translateTransition4.setToY(0);
        translateTransition4.setCycleCount(1);
        translateTransition4.setAutoReverse(true);

        TranslateTransition translateTransition5 = new TranslateTransition(Duration.millis(300), root2);
        //translateTransition4.setFromY(400);
        translateTransition5.setToY(-310);
        translateTransition5.setCycleCount(1);
        translateTransition5.setAutoReverse(true);

        FadeTransition fadeTransition1 = new FadeTransition();
        fadeTransition1.setDuration(Duration.millis(1000));
        fadeTransition1.setNode(root);
        fadeTransition1.setFromValue(1);
        fadeTransition1.setToValue(0);

        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(translateTransition1, translateTransition2, translateTransition3, translateTransition4, translateTransition5, fadeTransition1);
        sequentialTransition.setCycleCount(1);
        sequentialTransition.setInterpolator(Interpolator.LINEAR);
        //sequentialTransition.setAutoReverse(true);
        sequentialTransition.play();
        sequentialTransition.setOnFinished(actionEvent -> {
            try {
                new MainPage();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        root.getChildren().addAll(root0, root1, root2);
    }
}