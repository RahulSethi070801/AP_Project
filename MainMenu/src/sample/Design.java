package sample;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
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

public class Design
{
    Group root;

    public void setRoot(Group root)
    {
        this.root = root;
    }

    public Group getRoot()
    {
        return root;
    }

    public void show()
    {
        root = new Group();
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Line line1 = new Line(200, 200, 300, 200);
        line1.setStrokeWidth(20);
        Line line2 = new Line(300, 200, 400, 200);
        line2.setStrokeWidth(20);
        Line line3 = new Line(300, 200, 300, 300);
        line3.setStrokeWidth(20);
        Line line4 = new Line(300, 200, 300, 100);
        line4.setStrokeWidth(20);

        line1.setStroke(Color.YELLOW);
        line2.setStroke(Color.GREEN);
        line3.setStroke(Color.CYAN);
        line4.setStroke(Color.BLUE);



        Line line5 = new Line(1000, 200, 1100, 200);
        line5.setStrokeWidth(20);
        Line line6 = new Line(1100, 200, 1200, 200);
        line6.setStrokeWidth(20);
        Line line7 = new Line(1100, 200, 1100, 300);
        line7.setStrokeWidth(20);
        Line line8 = new Line(1100, 200, 1100, 100);
        line8.setStrokeWidth(20);

        line5.setStroke(Color.YELLOW);
        line6.setStroke(Color.GREEN);
        line7.setStroke(Color.CYAN);
        line8.setStroke(Color.BLUE);



        Group root1 = new Group(line1, line2, line3, line4);

        RotateTransition rotateTransition1 = new RotateTransition();
        rotateTransition1.setDuration(Duration.millis(2000));
        rotateTransition1.setNode(root1);
        rotateTransition1.setByAngle(360);
        rotateTransition1.setCycleCount(50);
        rotateTransition1.setAutoReverse(false);
        rotateTransition1.setInterpolator(Interpolator.LINEAR);
        rotateTransition1.play();

        Group root2 = new Group(line5, line6, line7, line8);

        RotateTransition rotateTransition2 = new RotateTransition();
        rotateTransition2.setDuration(Duration.millis(2000));
        rotateTransition2.setNode(root2);
        rotateTransition2.setByAngle(360);
        rotateTransition2.setCycleCount(50);
        rotateTransition2.setAutoReverse(false);
        rotateTransition2.setInterpolator(Interpolator.LINEAR);
        rotateTransition2.play();

        root.getChildren().add(root1);
        root.getChildren().add(root2);

    }

}
