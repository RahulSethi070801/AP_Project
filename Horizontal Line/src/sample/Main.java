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
import javafx.scene.shape.*;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");

        Line line1 = new Line(0, 200, 100, 200);
        line1.setStrokeWidth(10);
        Line line2 = new Line(100, 200, 200, 200);
        line2.setStrokeWidth(10);
        Line line3 = new Line(200, 200, 300, 200);
        line3.setStrokeWidth(10);
        Line line4 = new Line(300, 200, 400, 200);
        line4.setStrokeWidth(10);

        line1.setStroke(Color.YELLOW);
        line2.setStroke(Color.GREEN);
        line3.setStroke(Color.CYAN);
        line4.setStroke(Color.BLUE);

        Group root = new Group(line1, line2, line3, line4);

        TranslateTransition translateTransition1 = new TranslateTransition();
        translateTransition1.setDuration(Duration.millis(2000));
        translateTransition1.setNode(line1);
        translateTransition1.setByX(300);
        //translateTransition1.setFromX(0);
        //translateTransition1.setToX(300);
        translateTransition1.setCycleCount(50);
        translateTransition1.setAutoReverse(false);
        translateTransition1.setInterpolator(Interpolator.LINEAR);
        translateTransition1.play();

        TranslateTransition translateTransition2 = new TranslateTransition();
        translateTransition2.setDuration(Duration.millis(2000));
        translateTransition2.setNode(line2);
        translateTransition2.setByX(300);
        //translateTransition2.setFromX(100);
        //translateTransition2.setToX(200);
        translateTransition2.setCycleCount(50);
        translateTransition2.setAutoReverse(false);
        translateTransition2.setInterpolator(Interpolator.LINEAR);
        translateTransition2.play();

        TranslateTransition translateTransition3 = new TranslateTransition();
        translateTransition3.setDuration(Duration.millis(2000));
        translateTransition3.setNode(line3);
        translateTransition3.setByX(300);
        //translateTransition3.setFromX(200);
        //translateTransition3.setToX(100);
        translateTransition3.setCycleCount(50);
        translateTransition3.setAutoReverse(false);
        translateTransition3.setInterpolator(Interpolator.LINEAR);
        translateTransition3.play();

        TranslateTransition translateTransition4 = new TranslateTransition();
        translateTransition4.setDuration(Duration.millis(2000));
        translateTransition4.setNode(line4);
        translateTransition4.setByX(300);
        //translateTransition4.setFromX(300);
        //translateTransition1.setToX(0);
        translateTransition4.setCycleCount(50);
        translateTransition4.setAutoReverse(false);
        translateTransition4.setInterpolator(Interpolator.LINEAR);
        translateTransition4.play();



        primaryStage.setScene(new Scene(root, 800, 800));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
