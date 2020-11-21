package sample;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.util.Duration;



class Ring
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
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //Main.stage.setTitle("Hello World");

        Arc arc1 = new Arc();
        arc1.setCenterX(700.0f);
        arc1.setCenterY(400.0f);
        arc1.setRadiusX(90.0f);
        arc1.setRadiusY(90.0f);
        arc1.setStartAngle(0.0f);
        arc1.setLength(90.0f);
        arc1.setFill(Color.rgb(144, 13, 255));

        Arc arc2 = new Arc();
        arc2.setCenterX(700.0f);
        arc2.setCenterY(400.0f);
        arc2.setRadiusX(90.0f);
        arc2.setRadiusY(90.0f);
        arc2.setStartAngle(90.0f);
        arc2.setLength(90.0f);
        arc2.setFill(Color.rgb (250, 225, 0));

        Arc arc3 = new Arc();
        arc3.setCenterX(700.0f);
        arc3.setCenterY(400.0f);
        arc3.setRadiusX(90.0f);
        arc3.setRadiusY(90.0f);
        arc3.setStartAngle(180.0f);
        arc3.setLength(90.0f);
        arc3.setFill(Color.rgb(50, 219, 240));

        Arc arc4 = new Arc();
        arc4.setCenterX(700.0f);
        arc4.setCenterY(400.0f);
        arc4.setRadiusX(90.0f);
        arc4.setRadiusY(90.0f);
        arc4.setStartAngle(270.0f);
        arc4.setLength(90.0f);
        arc4.setFill(Color.rgb(255, 1, 129));

        //Setting the type of the arc
        arc1.setType(ArcType.ROUND);
        arc2.setType(ArcType.ROUND);
        arc3.setType(ArcType.ROUND);
        arc4.setType(ArcType.ROUND);

        Circle circle = new Circle(700, 400, 70);
        circle.setFill(Color.BLACK);

        root = new Group(arc1, arc2, arc3, arc4, circle);

        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.millis(1000));
        rotateTransition.setNode(root);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setAutoReverse(false);
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.play();



    }
}
