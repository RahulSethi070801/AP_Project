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

public class Plus extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");

//        Polygon polygon1 = new Polygon();
//        polygon1.getPoints().addAll(new Double[]{100.0, 100.0, 150.0, 100.0, 150.0, 186.6});
//        polygon1.setFill(Color.GREEN);
//
//        Polygon polygon2 = new Polygon();
//        polygon2.getPoints().addAll(new Double[]{200.0, 100.0, 150.0, 100.0, 150.0, 186.6});
//        polygon2.setFill(Color.YELLOW);

//        Polygon polygon3 = new Polygon();
//        polygon3.getPoints().addAll(new Double[]{100.0, 100.0, 200.0, 100.0, 150.0, 186.6});
//        polygon3.setFill(Color.BLUE);

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

//        line1.setFill(Color.YELLOW);
//        line2.setFill(Color.GREEN);
//        line3.setFill(Color.CYAN);


        Group root = new Group(line1, line2, line3, line4);

        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.millis(2000));
        rotateTransition.setNode(root);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(50);
        rotateTransition.setAutoReverse(false);
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.play();


        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
