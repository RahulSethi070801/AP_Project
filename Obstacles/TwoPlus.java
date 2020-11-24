// package sample;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.application.Application;
// import javafx.fxml.FXMLLoader;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.awt.*;

public class TwoPlus extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");

        Line line1 = new Line(100, 200, 200, 200);
        line1.setStrokeWidth(10);
        Line line2 = new Line(200, 200, 300, 200);
        line2.setStrokeWidth(10);
        Line line3 = new Line(200, 200, 200, 300);
        line3.setStrokeWidth(10);
        Line line4 = new Line(200, 200, 200, 100);
        line4.setStrokeWidth(10);

        line1.setStroke(Color.YELLOW);
        line2.setStroke(Color.GREEN);
        line3.setStroke(Color.CYAN);
        line4.setStroke(Color.BLUE);

        Line line5 = new Line(400, 200, 500, 200);
        line5.setStrokeWidth(10);
        Line line6 = new Line(400, 200, 300, 200);
        line6.setStrokeWidth(10);
        Line line7 = new Line(400, 200, 400, 300);
        line7.setStrokeWidth(10);
        Line line8 = new Line(400, 200, 400, 100);
        line8.setStrokeWidth(10);

        line5.setStroke(Color.YELLOW);
        line6.setStroke(Color.GREEN);
        line7.setStroke(Color.CYAN);
        line8.setStroke(Color.BLUE);


        Group root1 = new Group(line1, line2, line3, line4);
        Group root2 = new Group(line5, line6, line7, line8);
        Group root3 = new Group();

        root3.getChildren().add(root2);
        root3.getChildren().add(root1);

        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.millis(4000));
        rotateTransition.setNode(root1);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(50);
        rotateTransition.setAutoReverse(false);
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.play();

        RotateTransition rotateTransition2 = new RotateTransition();
        rotateTransition2.setDuration(Duration.millis(4000));
        rotateTransition2.setNode(root2);
        rotateTransition2.setByAngle(-360);
        rotateTransition2.setCycleCount(50);
        rotateTransition2.setAutoReverse(false);
        rotateTransition2.setInterpolator(Interpolator.LINEAR);
        rotateTransition2.play();


        primaryStage.setScene(new Scene(root3, 800, 800));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
