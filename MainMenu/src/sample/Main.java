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
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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
        primaryStage.setFullScreen(true);

        Text text1 = new Text();
        text1.setText("C");
        text1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 80));
        text1.setFill(Color.WHITE);
        text1.setStrokeWidth(5);
        text1.setX(500);
        text1.setY(150);

        Text text2 = new Text();
        text2.setText("L");
        text2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 80));
        text2.setFill(Color.WHITE);
        text2.setStrokeWidth(5);
        text2.setX(660);
        text2.setY(150);

        Text text3 = new Text();
        text3.setText("R");
        text3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 80));
        text3.setFill(Color.WHITE);
        text3.setStrokeWidth(5);
        text3.setX(805);
        text3.setY(150);

        Text text4 = new Text();
        text4.setText("SWITCH");
        text4.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 80));
        text4.setFill(Color.WHITE);
        text4.setStrokeWidth(5);
        text4.setX(500);
        text4.setY(300);


        Arc arc1 = new Arc();
        arc1.setCenterX(610.0f);
        arc1.setCenterY(125.0f);
        arc1.setRadiusX(40.0f);
        arc1.setRadiusY(40.0f);
        arc1.setStartAngle(0.0f);
        arc1.setLength(90.0f);
        arc1.setFill(Color.CYAN);
        arc1.setType(ArcType.ROUND);

        Arc arc2 = new Arc();
        arc2.setCenterX(610.0f);
        arc2.setCenterY(125.0f);
        arc2.setRadiusX(40.0f);
        arc2.setRadiusY(40.0f);
        arc2.setStartAngle(90.0f);
        arc2.setLength(90.0f);
        arc2.setFill(Color.PINK);
        arc2.setType(ArcType.ROUND);

        Arc arc3 = new Arc();
        arc3.setCenterX(610.0f);
        arc3.setCenterY(125.0f);
        arc3.setRadiusX(40.0f);
        arc3.setRadiusY(40.0f);
        arc3.setStartAngle(180.0f);
        arc3.setLength(90.0f);
        arc3.setFill(Color.YELLOW);
        arc3.setType(ArcType.ROUND);

        Arc arc4 = new Arc();
        arc4.setCenterX(610.0f);
        arc4.setCenterY(125.0f);
        arc4.setRadiusX(40.0f);
        arc4.setRadiusY(40.0f);
        arc4.setStartAngle(270.0f);
        arc4.setLength(90.0f);
        arc4.setFill(Color.DARKBLUE);
        arc4.setType(ArcType.ROUND);

        Circle circle1 = new Circle(610, 125, 30);
        circle1.setFill(Color.BLACK);

        Group root1 = new Group(arc1, arc2, arc3, arc4, circle1);

        RotateTransition rotateTransition1 = new RotateTransition();
        rotateTransition1.setDuration(Duration.millis(1000));
        rotateTransition1.setNode(root1);
        rotateTransition1.setByAngle(360);
        rotateTransition1.setCycleCount(50);
        rotateTransition1.setAutoReverse(false);
        rotateTransition1.setInterpolator(Interpolator.LINEAR);
        rotateTransition1.play();


        Arc arc5 = new Arc();
        arc5.setCenterX(760.0f);
        arc5.setCenterY(125.0f);
        arc5.setRadiusX(40.0f);
        arc5.setRadiusY(40.0f);
        arc5.setStartAngle(0.0f);
        arc5.setLength(90.0f);
        arc5.setFill(Color.CYAN);
        arc5.setType(ArcType.ROUND);

        Arc arc6 = new Arc();
        arc6.setCenterX(760.0f);
        arc6.setCenterY(125.0f);
        arc6.setRadiusX(40.0f);
        arc6.setRadiusY(40.0f);
        arc6.setStartAngle(90.0f);
        arc6.setLength(90.0f);
        arc6.setFill(Color.PINK);
        arc6.setType(ArcType.ROUND);

        Arc arc7 = new Arc();
        arc7.setCenterX(760.0f);
        arc7.setCenterY(125.0f);
        arc7.setRadiusX(40.0f);
        arc7.setRadiusY(40.0f);
        arc7.setStartAngle(180.0f);
        arc7.setLength(90.0f);
        arc7.setFill(Color.YELLOW);
        arc7.setType(ArcType.ROUND);

        Arc arc8 = new Arc();
        arc8.setCenterX(760.0f);
        arc8.setCenterY(125.0f);
        arc8.setRadiusX(40.0f);
        arc8.setRadiusY(40.0f);
        arc8.setStartAngle(270.0f);
        arc8.setLength(90.0f);
        arc8.setFill(Color.DARKBLUE);
        arc8.setType(ArcType.ROUND);

        Circle circle2 = new Circle(760, 125, 30);
        circle1.setFill(Color.BLACK);

        Group root2 = new Group(arc5, arc6, arc7, arc8, circle2);

    RotateTransition rotateTransition2 = new RotateTransition();
        rotateTransition2.setDuration(Duration.millis(1000));
        rotateTransition2.setNode(root2);
        rotateTransition2.setByAngle(360);
        rotateTransition2.setCycleCount(50);
        rotateTransition2.setAutoReverse(false);
        rotateTransition2.setInterpolator(Interpolator.LINEAR);
        rotateTransition2.play();

    Group root3 = new Group(text1, text2,text3, text4);




    Group root = new Group();
        root.getChildren().add(root1);
        root.getChildren().add(root2);
        root.getChildren().add(root3);

        primaryStage.setScene(new Scene(root, 800, 800, Color.BLACK));
        primaryStage.show();
}


    public static void main(String[] args) {
        launch(args);
    }
}
