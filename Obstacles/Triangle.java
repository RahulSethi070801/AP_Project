// package sample;
/*
 Triangle obstacle

*/
import javafx.animation.AnimationTimer;
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
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.awt.*;

public class Triangle extends Application {

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

//        Line line1 = new Line(100, 100, 300, 100);
//        line1.setStrokeWidth(5);
//        Line line2 = new Line(100, 100, 200, 100 + 100*Math.sqrt(3));
//        line2.setStrokeWidth(5);
//        Line line3 = new Line(300, 100, 200, 100 + 100*Math.sqrt(3));
//        line3.setStrokeWidth(5);

        Line line1 = new Line(200, 200, 376, 301.734);
        line1.setStrokeWidth(5);
        Line line2 = new Line(200, 200, 376, 98.266);
        line2.setStrokeWidth(5);
        Line line3 = new Line(376, 301.734, 376, 98.266);
        line3.setStrokeWidth(5);

        line1.setStroke(Color.YELLOW);
        line2.setStroke(Color.GREEN);
        line3.setStroke(Color.CYAN);

//        line1.setFill(Color.YELLOW);
//        line2.setFill(Color.GREEN);
//        line3.setFill(Color.CYAN);
        Group root = new Group(line2, line1, line3);
        //root.getChildren().addAll(line1, line2, line3);

        Rotate r = new Rotate();
        root.getTransforms().add(r);
        r.setPivotX(317.3);
        r.setPivotY(200);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                r.setAngle(r.getAngle()+2);
            }
        };
        timer.start();


//
//        RotateTransition rotateTransition = new RotateTransition();
//        rotateTransition.setDuration(Duration.millis(5000));
//        rotateTransition.setNode(root);
//        rotateTransition.setByAngle(360);
//        rotateTransition.setCycleCount(50);
//        rotateTransition.setAutoReverse(false);
//        rotateTransition.setInterpolator(Interpolator.LINEAR);
//        rotateTransition.play();


        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
